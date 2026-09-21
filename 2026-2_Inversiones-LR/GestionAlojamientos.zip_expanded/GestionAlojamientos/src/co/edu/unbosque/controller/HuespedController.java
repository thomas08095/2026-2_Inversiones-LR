package co.edu.unbosque.controller;

import co.edu.unbosque.dto.HuespedDTO;
import co.edu.unbosque.exception.*;
import co.edu.unbosque.mapper.HuespedDataMapper;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.persistence.HuespedDAO;
import co.edu.unbosque.persistence.impl.HuespedDAOFileImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HuespedController {

    private final List<Huesped> huespedes;
    private final HuespedDAO dao;
    private final HuespedDataMapper mapper;

    public HuespedController(String rutaArchivo) {
        this.dao = new HuespedDAOFileImpl(rutaArchivo);
        this.mapper = new HuespedDataMapper();
        this.huespedes = new ArrayList<>();
    }

    public void cargarDatos() {
        try {
            List<HuespedDTO> dtos = dao.cargarTodos();
            huespedes.clear();
            for (HuespedDTO dto : dtos) {
                huespedes.add(mapper.dtoToEntity(dto));
            }
        } catch (ArchivoInexistenteException | ArchivoVacioException e) {
            // No hay datos previos.
        } catch (RegistroFormatoIncorrectoException | IOException e) {
            System.out.println("Aviso: no se pudieron cargar por completo los huespedes -> " + e.getMessage());
        }
    }

    public void guardarCambios() {
        try {
            List<HuespedDTO> dtos = new ArrayList<>();
            for (Huesped h : huespedes) {
                dtos.add(mapper.entityToDTO(h));
            }
            dao.guardarTodos(dtos);
        } catch (IOException e) {
            System.out.println("Error guardando huespedes: " + e.getMessage());
        }
    }

    public List<Huesped> consultarTodos() {
        return new ArrayList<>(huespedes);
    }

    public Huesped consultarPorId(String id) throws IdentificadorInexistenteException {
        for (Huesped h : huespedes) {
            if (h.getId().equals(id)) return h;
        }
        throw new IdentificadorInexistenteException("No existe un huesped con id: " + id);
    }

    public void registrarHuesped(Huesped huesped) throws IdentificadorDuplicadoException,
            DatoObligatorioVacioException {
        if (huesped.getId() == null || huesped.getId().isBlank()) {
            throw new DatoObligatorioVacioException("El identificador del huesped es obligatorio.");
        }
        if (huesped.getNombre() == null || huesped.getNombre().isBlank()) {
            throw new DatoObligatorioVacioException("El nombre del huesped es obligatorio.");
        }
        if (huesped.getApellido() == null || huesped.getApellido().isBlank()) {
            throw new DatoObligatorioVacioException("El apellido del huesped es obligatorio.");
        }
        if (huesped.getCorreo() == null || huesped.getCorreo().isBlank()) {
            throw new DatoObligatorioVacioException("El correo del huesped es obligatorio.");
        }
        for (Huesped h : huespedes) {
            if (h.getId().equals(huesped.getId())) {
                throw new IdentificadorDuplicadoException("Ya existe un huesped con id: " + huesped.getId());
            }
        }
        huespedes.add(huesped);
        guardarCambios();
    }
}
