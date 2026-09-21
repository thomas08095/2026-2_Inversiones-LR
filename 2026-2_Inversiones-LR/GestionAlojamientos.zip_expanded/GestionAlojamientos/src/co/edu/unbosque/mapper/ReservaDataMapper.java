package co.edu.unbosque.mapper;

import co.edu.unbosque.dto.ReservaDTO;
import co.edu.unbosque.exception.RegistroFormatoIncorrectoException;
import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.EstadoReserva;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.model.Reserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservaDataMapper {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ISO_LOCAL_DATE;

    public ReservaDTO entityToDTO(Reserva reserva) {
        ReservaDTO dto = new ReservaDTO();
        dto.setId(reserva.getId());
        dto.setIdHuesped(reserva.getHuesped().getId());
        dto.setIdAlojamiento(reserva.getAlojamiento().getId());
        dto.setFechaLlegada(reserva.getFechaLlegada().format(FORMATO_FECHA));
        dto.setFechaSalida(reserva.getFechaSalida().format(FORMATO_FECHA));
        dto.setNumeroHuespedes(reserva.getNumeroHuespedes());
        dto.setNumeroNoches(reserva.getNumeroNoches());
        dto.setValorTotal(reserva.getValorTotal());
        dto.setEstado(reserva.getEstado().name());
        return dto;
    }

    /**
     * El DTO solo tiene los identificadores de huesped y alojamiento; el
     * llamador (Controller) debe resolverlos consultando los DAO
     * correspondientes y pasarlos ya como objetos de dominio.
     */
    public Reserva dtoToEntity(ReservaDTO dto, Huesped huesped, Alojamiento alojamiento) {
        Reserva reserva = new Reserva();
        reserva.setId(dto.getId());
        reserva.setHuesped(huesped);
        reserva.setAlojamiento(alojamiento);
        reserva.setFechaLlegada(LocalDate.parse(dto.getFechaLlegada(), FORMATO_FECHA));
        reserva.setFechaSalida(LocalDate.parse(dto.getFechaSalida(), FORMATO_FECHA));
        reserva.setNumeroHuespedes(dto.getNumeroHuespedes());
        reserva.setNumeroNoches(dto.getNumeroNoches());
        reserva.setValorTotal(dto.getValorTotal());
        reserva.setEstado(EstadoReserva.valueOf(dto.getEstado()));
        return reserva;
    }

    public String dtoToLine(ReservaDTO dto) {
        return String.join("|",
                dto.getId(),
                dto.getIdHuesped(),
                dto.getIdAlojamiento(),
                dto.getFechaLlegada(),
                dto.getFechaSalida(),
                String.valueOf(dto.getNumeroHuespedes()),
                String.valueOf(dto.getNumeroNoches()),
                String.valueOf(dto.getValorTotal()),
                dto.getEstado());
    }

    public ReservaDTO lineToDTO(String linea) throws RegistroFormatoIncorrectoException {
        String[] campos = linea.split("\\|", -1);
        if (campos.length < 9) {
            throw new RegistroFormatoIncorrectoException("Registro de reserva con formato incorrecto: " + linea);
        }
        try {
            return new ReservaDTO(campos[0], campos[1], campos[2], campos[3], campos[4],
                    Integer.parseInt(campos[5]), Long.parseLong(campos[6]),
                    Double.parseDouble(campos[7]), campos[8]);
        } catch (NumberFormatException e) {
            throw new RegistroFormatoIncorrectoException("Dato numerico invalido en registro de reserva: " + linea);
        }
    }
}
