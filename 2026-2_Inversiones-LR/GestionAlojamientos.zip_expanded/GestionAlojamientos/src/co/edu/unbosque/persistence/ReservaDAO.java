package co.edu.unbosque.persistence;

import co.edu.unbosque.dto.ReservaDTO;
import co.edu.unbosque.exception.ArchivoInexistenteException;
import co.edu.unbosque.exception.ArchivoVacioException;
import co.edu.unbosque.exception.RegistroFormatoIncorrectoException;

import java.io.IOException;
import java.util.List;

public interface ReservaDAO {
    List<ReservaDTO> cargarTodos() throws ArchivoInexistenteException, ArchivoVacioException, RegistroFormatoIncorrectoException, IOException;
    void guardarTodos(List<ReservaDTO> reservas) throws IOException;
}
