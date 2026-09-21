package co.edu.unbosque.mapper;

import co.edu.unbosque.dto.AlojamientoDTO;
import co.edu.unbosque.exception.RegistroFormatoIncorrectoException;
import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.Apartamento;
import co.edu.unbosque.model.Cabana;
import co.edu.unbosque.model.Casa;
import co.edu.unbosque.model.EstadoAlojamiento;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Traduce entre el modelo de dominio (Alojamiento y sus subtipos), el DTO
 * plano y la representacion textual usada para persistir en archivo plano.
 * Separador de campos: "|". Separador de servicios adicionales: ",".
 */
public class AlojamientoDataMapper {

    private static final String SEPARADOR = "\\|";

    public AlojamientoDTO entityToDTO(Alojamiento alojamiento) {
        AlojamientoDTO dto = new AlojamientoDTO();
        dto.setId(alojamiento.getId());
        dto.setTipo(alojamiento.getTipo());
        dto.setNombre(alojamiento.getNombre());
        dto.setCiudad(alojamiento.getCiudad());
        dto.setUbicacion(alojamiento.getUbicacion());
        dto.setCapacidad(alojamiento.getCapacidad());
        dto.setPrecioBase(alojamiento.getPrecioBase());
        dto.setEstado(alojamiento.getEstado().name());
        dto.setDescripcion(alojamiento.getDescripcion());
        dto.setServiciosAdicionales(String.join(",", alojamiento.getServiciosAdicionales()));
        return dto;
    }

    public Alojamiento dtoToEntity(AlojamientoDTO dto) {
        Alojamiento alojamiento;
        switch (dto.getTipo()) {
            case "CASA":
                alojamiento = new Casa();
                break;
            case "CABANA":
                alojamiento = new Cabana();
                break;
            case "APARTAMENTO":
            default:
                alojamiento = new Apartamento();
                break;
        }
        alojamiento.setId(dto.getId());
        alojamiento.setNombre(dto.getNombre());
        alojamiento.setCiudad(dto.getCiudad());
        alojamiento.setUbicacion(dto.getUbicacion());
        alojamiento.setCapacidad(dto.getCapacidad());
        alojamiento.setPrecioBase(dto.getPrecioBase());
        alojamiento.setEstado(EstadoAlojamiento.valueOf(dto.getEstado()));
        alojamiento.setDescripcion(dto.getDescripcion());
        if (dto.getServiciosAdicionales() != null && !dto.getServiciosAdicionales().isEmpty()) {
            alojamiento.setServiciosAdicionales(new ArrayList<>(Arrays.asList(dto.getServiciosAdicionales().split(","))));
        }
        return alojamiento;
    }

    public String dtoToLine(AlojamientoDTO dto) {
        return String.join("|",
                dto.getId(),
                dto.getTipo(),
                dto.getNombre(),
                dto.getCiudad(),
                dto.getUbicacion(),
                String.valueOf(dto.getCapacidad()),
                String.valueOf(dto.getPrecioBase()),
                dto.getEstado(),
                dto.getDescripcion() == null ? "" : dto.getDescripcion(),
                dto.getServiciosAdicionales() == null ? "" : dto.getServiciosAdicionales());
    }

    public AlojamientoDTO lineToDTO(String linea) throws RegistroFormatoIncorrectoException {
        String[] campos = linea.split(SEPARADOR, -1);
        if (campos.length < 9) {
            throw new RegistroFormatoIncorrectoException("Registro de alojamiento con formato incorrecto: " + linea);
        }
        try {
            AlojamientoDTO dto = new AlojamientoDTO();
            dto.setId(campos[0]);
            dto.setTipo(campos[1]);
            dto.setNombre(campos[2]);
            dto.setCiudad(campos[3]);
            dto.setUbicacion(campos[4]);
            dto.setCapacidad(Integer.parseInt(campos[5]));
            dto.setPrecioBase(Double.parseDouble(campos[6]));
            dto.setEstado(campos[7]);
            dto.setDescripcion(campos[8]);
            dto.setServiciosAdicionales(campos.length > 9 ? campos[9] : "");
            return dto;
        } catch (NumberFormatException e) {
            throw new RegistroFormatoIncorrectoException("Dato numerico invalido en registro de alojamiento: " + linea);
        }
    }
}
