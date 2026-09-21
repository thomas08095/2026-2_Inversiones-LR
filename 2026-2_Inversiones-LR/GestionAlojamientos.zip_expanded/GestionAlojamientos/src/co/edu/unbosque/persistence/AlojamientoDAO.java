package co.edu.unbosque.persistence;

import co.edu.unbosque.dto.AlojamientoDTO;
import co.edu.unbosque.exception.ArchivoInexistenteException;
import co.edu.unbosque.exception.ArchivoVacioException;
import co.edu.unbosque.exception.RegistroFormatoIncorrectoException;

import java.io.IOException;
import java.util.List;

public interface AlojamientoDAO {
    List<AlojamientoDTO> cargarTodos() throws ArchivoInexistenteException, ArchivoVacioException, RegistroFormatoIncorrectoException, IOException;
    void guardarTodos(List<AlojamientoDTO> alojamientos) throws IOException;
}
