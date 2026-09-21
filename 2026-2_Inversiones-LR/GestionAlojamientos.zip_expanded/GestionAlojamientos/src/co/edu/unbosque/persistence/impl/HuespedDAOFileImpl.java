package co.edu.unbosque.persistence.impl;

import co.edu.unbosque.dto.HuespedDTO;
import co.edu.unbosque.exception.ArchivoInexistenteException;
import co.edu.unbosque.exception.ArchivoVacioException;
import co.edu.unbosque.exception.RegistroFormatoIncorrectoException;
import co.edu.unbosque.mapper.HuespedDataMapper;
import co.edu.unbosque.persistence.HuespedDAO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HuespedDAOFileImpl implements HuespedDAO {

    private final String rutaArchivo;
    private final HuespedDataMapper mapper;

    public HuespedDAOFileImpl(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.mapper = new HuespedDataMapper();
    }

    @Override
    public List<HuespedDTO> cargarTodos() throws ArchivoInexistenteException, ArchivoVacioException,
            RegistroFormatoIncorrectoException, IOException {
        Path path = Path.of(rutaArchivo);
        if (!Files.exists(path)) {
            throw new ArchivoInexistenteException("No se encontro el archivo de huespedes: " + rutaArchivo);
        }
        List<String> lineas = Files.readAllLines(path);
        if (lineas.isEmpty()) {
            throw new ArchivoVacioException("El archivo de huespedes esta vacio: " + rutaArchivo);
        }
        List<HuespedDTO> resultado = new ArrayList<>();
        for (String linea : lineas) {
            if (linea.trim().isEmpty()) continue;
            resultado.add(mapper.lineToDTO(linea));
        }
        return resultado;
    }

    @Override
    public void guardarTodos(List<HuespedDTO> huespedes) throws IOException {
        Path path = Path.of(rutaArchivo);
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (HuespedDTO dto : huespedes) {
                writer.write(mapper.dtoToLine(dto));
                writer.newLine();
            }
        }
    }
}
