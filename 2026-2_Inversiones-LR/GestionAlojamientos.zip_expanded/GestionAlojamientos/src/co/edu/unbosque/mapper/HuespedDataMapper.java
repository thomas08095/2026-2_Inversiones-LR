package co.edu.unbosque.mapper;

import co.edu.unbosque.dto.HuespedDTO;
import co.edu.unbosque.exception.RegistroFormatoIncorrectoException;
import co.edu.unbosque.model.Huesped;

public class HuespedDataMapper {

    public HuespedDTO entityToDTO(Huesped huesped) {
        return new HuespedDTO(huesped.getId(), huesped.getNombre(), huesped.getApellido(),
                huesped.getCorreo(), huesped.getTelefono());
    }

    public Huesped dtoToEntity(HuespedDTO dto) {
        return new Huesped(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getCorreo(), dto.getTelefono());
    }

    public String dtoToLine(HuespedDTO dto) {
        return String.join("|", dto.getId(), dto.getNombre(), dto.getApellido(), dto.getCorreo(), dto.getTelefono());
    }

    public HuespedDTO lineToDTO(String linea) throws RegistroFormatoIncorrectoException {
        String[] campos = linea.split("\\|", -1);
        if (campos.length < 5) {
            throw new RegistroFormatoIncorrectoException("Registro de huesped con formato incorrecto: " + linea);
        }
        return new HuespedDTO(campos[0], campos[1], campos[2], campos[3], campos[4]);
    }
}
