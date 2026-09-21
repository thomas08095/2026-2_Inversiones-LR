package co.edu.unbosque.controller;

import co.edu.unbosque.dto.AlojamientoDTO;
import co.edu.unbosque.exception.*;
import co.edu.unbosque.mapper.AlojamientoDataMapper;
import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.EstadoAlojamiento;
import co.edu.unbosque.persistence.AlojamientoDAO;
import co.edu.unbosque.persistence.impl.AlojamientoDAOFileImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlojamientoController {

    private final List<Alojamiento> alojamientos;
    private final AlojamientoDAO dao;
    private final AlojamientoDataMapper mapper;

    public AlojamientoController(String rutaArchivo) {
        this.dao = new AlojamientoDAOFileImpl(rutaArchivo);
        this.mapper = new AlojamientoDataMapper();
        this.alojamientos = new ArrayList<>();
    }

    /** Carga la informacion del archivo al iniciar la aplicacion. */
    public void cargarDatos() {
        try {
            List<AlojamientoDTO> dtos = dao.cargarTodos();
            alojamientos.clear();
            for (AlojamientoDTO dto : dtos) {
                alojamientos.add(mapper.dtoToEntity(dto));
            }
        } catch (ArchivoInexistenteException | ArchivoVacioException e) {
            // Primer uso de la aplicacion: no hay datos previos, se continua vacio.
        } catch (RegistroFormatoIncorrectoException | IOException e) {
            System.out.println("Aviso: no se pudieron cargar por completo los alojamientos -> " + e.getMessage());
        }
    }

    /** Persiste el estado actual en el archivo plano. */
    public void guardarCambios() {
        try {
            List<AlojamientoDTO> dtos = new ArrayList<>();
            for (Alojamiento a : alojamientos) {
                dtos.add(mapper.entityToDTO(a));
            }
            dao.guardarTodos(dtos);
        } catch (IOException e) {
            System.out.println("Error guardando alojamientos: " + e.getMessage());
        }
    }

    public List<Alojamiento> consultarTodos() {
        return new ArrayList<>(alojamientos);
    }

    public Alojamiento consultarDetalle(String id) throws IdentificadorInexistenteException {
        for (Alojamiento a : alojamientos) {
            if (a.getId().equals(id)) return a;
        }
        throw new IdentificadorInexistenteException("No existe un alojamiento con id: " + id);
    }

    public List<Alojamiento> buscar(String ciudad, String tipo, Integer capacidadMinima, Double precioMaximo) {
        List<Alojamiento> resultado = new ArrayList<>();
        for (Alojamiento a : alojamientos) {
            boolean cumple = true;
            if (ciudad != null && !ciudad.isBlank() && !a.getCiudad().equalsIgnoreCase(ciudad)) cumple = false;
            if (tipo != null && !tipo.isBlank() && !a.getTipo().equalsIgnoreCase(tipo)) cumple = false;
            if (capacidadMinima != null && a.getCapacidad() < capacidadMinima) cumple = false;
            if (precioMaximo != null && a.getPrecioBase() > precioMaximo) cumple = false;
            if (cumple) resultado.add(a);
        }
        return resultado;
    }

    public void registrarAlojamiento(Alojamiento alojamiento) throws IdentificadorDuplicadoException,
            DatoObligatorioVacioException, EntradaInvalidaException {
        if (alojamiento.getId() == null || alojamiento.getId().isBlank()) {
            throw new DatoObligatorioVacioException("El identificador del alojamiento es obligatorio.");
        }
        if (alojamiento.getNombre() == null || alojamiento.getNombre().isBlank()) {
            throw new DatoObligatorioVacioException("El nombre del alojamiento es obligatorio.");
        }
        for (Alojamiento a : alojamientos) {
            if (a.getId().equals(alojamiento.getId())) {
                throw new IdentificadorDuplicadoException("Ya existe un alojamiento con id: " + alojamiento.getId());
            }
        }
        if (alojamiento.getCapacidad() <= 0) {
            throw new EntradaInvalidaException("La capacidad debe ser mayor que cero.");
        }
        if (alojamiento.getPrecioBase() <= 0) {
            throw new EntradaInvalidaException("El precio por noche debe ser mayor que cero.");
        }
        if (alojamiento.getEstado() == null) {
            alojamiento.setEstado(EstadoAlojamiento.ACTIVO);
        }
        alojamientos.add(alojamiento);
        guardarCambios();
    }
}
