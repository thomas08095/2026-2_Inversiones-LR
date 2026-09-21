package co.edu.unbosque.persistence;

import co.edu.unbosque.dto.HuespedDTO;
import co.edu.unbosque.exception.ArchivoInexistenteException;
import co.edu.unbosque.exception.ArchivoVacioException;
import co.edu.unbosque.exception.RegistroFormatoIncorrectoException;

import java.io.IOException;
import java.util.List;

public interface HuespedDAO {
    List<HuespedDTO> cargarTodos() throws ArchivoInexistenteException, ArchivoVacioException, RegistroFormatoIncorrectoException, IOException;
    void guardarTodos(List<HuespedDTO> huespedes) throws IOException;
}
