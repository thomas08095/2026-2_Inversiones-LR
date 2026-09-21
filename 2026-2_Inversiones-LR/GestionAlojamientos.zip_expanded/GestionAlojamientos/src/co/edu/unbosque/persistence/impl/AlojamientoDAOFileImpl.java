package co.edu.unbosque.persistence.impl;

import co.edu.unbosque.dto.AlojamientoDTO;
import co.edu.unbosque.exception.ArchivoInexistenteException;
import co.edu.unbosque.exception.ArchivoVacioException;
import co.edu.unbosque.exception.RegistroFormatoIncorrectoException;
import co.edu.unbosque.mapper.AlojamientoDataMapper;
import co.edu.unbosque.persistence.AlojamientoDAO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AlojamientoDAOFileImpl implements AlojamientoDAO {

    private final String rutaArchivo;
    private final AlojamientoDataMapper mapper;

    public AlojamientoDAOFileImpl(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.mapper = new AlojamientoDataMapper();
    }

    @Override
    public List<AlojamientoDTO> cargarTodos() throws ArchivoInexistenteException, ArchivoVacioException,
            RegistroFormatoIncorrectoException, IOException {
        Path path = Path.of(rutaArchivo);
        if (!Files.exists(path)) {
            throw new ArchivoInexistenteException("No se encontro el archivo de alojamientos: " + rutaArchivo);
        }
        List<String> lineas = Files.readAllLines(path);
        if (lineas.isEmpty()) {
            throw new ArchivoVacioException("El archivo de alojamientos esta vacio: " + rutaArchivo);
        }
        List<AlojamientoDTO> resultado = new ArrayList<>();
        for (String linea : lineas) {
            if (linea.trim().isEmpty()) continue;
            resultado.add(mapper.lineToDTO(linea));
        }
        return resultado;
    }

    @Override
    public void guardarTodos(List<AlojamientoDTO> alojamientos) throws IOException {
        Path path = Path.of(rutaArchivo);
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AlojamientoDTO dto : alojamientos) {
                writer.write(mapper.dtoToLine(dto));
                writer.newLine();
            }
        }
    }
}
