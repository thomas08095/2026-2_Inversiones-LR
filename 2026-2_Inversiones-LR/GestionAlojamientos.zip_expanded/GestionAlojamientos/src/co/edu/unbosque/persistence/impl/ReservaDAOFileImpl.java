package co.edu.unbosque.persistence.impl;

import co.edu.unbosque.dto.ReservaDTO;
import co.edu.unbosque.exception.ArchivoInexistenteException;
import co.edu.unbosque.exception.ArchivoVacioException;
import co.edu.unbosque.exception.RegistroFormatoIncorrectoException;
import co.edu.unbosque.mapper.ReservaDataMapper;
import co.edu.unbosque.persistence.ReservaDAO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAOFileImpl implements ReservaDAO {

    private final String rutaArchivo;
    private final ReservaDataMapper mapper;

    public ReservaDAOFileImpl(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.mapper = new ReservaDataMapper();
    }

    @Override
    public List<ReservaDTO> cargarTodos() throws ArchivoInexistenteException, ArchivoVacioException,
            RegistroFormatoIncorrectoException, IOException {
        Path path = Path.of(rutaArchivo);
        if (!Files.exists(path)) {
            throw new ArchivoInexistenteException("No se encontro el archivo de reservas: " + rutaArchivo);
        }
        List<String> lineas = Files.readAllLines(path);
        if (lineas.isEmpty()) {
            throw new ArchivoVacioException("El archivo de reservas esta vacio: " + rutaArchivo);
        }
        List<ReservaDTO> resultado = new ArrayList<>();
        for (String linea : lineas) {
            if (linea.trim().isEmpty()) continue;
            resultado.add(mapper.lineToDTO(linea));
        }
        return resultado;
    }

    @Override
    public void guardarTodos(List<ReservaDTO> reservas) throws IOException {
        Path path = Path.of(rutaArchivo);
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (ReservaDTO dto : reservas) {
                writer.write(mapper.dtoToLine(dto));
                writer.newLine();
            }
        }
    }
}
