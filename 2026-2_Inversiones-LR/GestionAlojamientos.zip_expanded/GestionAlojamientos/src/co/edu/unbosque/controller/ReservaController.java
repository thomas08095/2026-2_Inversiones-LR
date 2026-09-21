package co.edu.unbosque.controller;

import co.edu.unbosque.dto.ReservaDTO;
import co.edu.unbosque.exception.*;
import co.edu.unbosque.mapper.ReservaDataMapper;
import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.EstadoAlojamiento;
import co.edu.unbosque.model.EstadoReserva;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.persistence.ReservaDAO;
import co.edu.unbosque.persistence.impl.ReservaDAOFileImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ReservaController {

    private final List<Reserva> reservas;
    private final ReservaDAO dao;
    private final ReservaDataMapper mapper;
    private final AlojamientoController alojamientoController;
    private final HuespedController huespedController;

    public ReservaController(String rutaArchivo, AlojamientoController alojamientoController,
                              HuespedController huespedController) {
        this.dao = new ReservaDAOFileImpl(rutaArchivo);
        this.mapper = new ReservaDataMapper();
        this.reservas = new ArrayList<>();
        this.alojamientoController = alojamientoController;
        this.huespedController = huespedController;
    }

    public void cargarDatos() {
        try {
            List<ReservaDTO> dtos = dao.cargarTodos();
            reservas.clear();
            for (ReservaDTO dto : dtos) {
                try {
                    Huesped h = huespedController.consultarPorId(dto.getIdHuesped());
                    Alojamiento a = alojamientoController.consultarDetalle(dto.getIdAlojamiento());
                    reservas.add(mapper.dtoToEntity(dto, h, a));
                } catch (IdentificadorInexistenteException e) {
                    System.out.println("Aviso: se omitio una reserva con referencia invalida -> " + e.getMessage());
                }
            }
        } catch (ArchivoInexistenteException | ArchivoVacioException e) {
            // No hay datos previos.
        } catch (RegistroFormatoIncorrectoException | IOException e) {
            System.out.println("Aviso: no se pudieron cargar por completo las reservas -> " + e.getMessage());
        }
    }

    public void guardarCambios() {
        try {
            List<ReservaDTO> dtos = new ArrayList<>();
            for (Reserva r : reservas) {
                dtos.add(mapper.entityToDTO(r));
            }
            dao.guardarTodos(dtos);
        } catch (IOException e) {
            System.out.println("Error guardando reservas: " + e.getMessage());
        }
    }

    public List<Reserva> consultarTodas() {
        return new ArrayList<>(reservas);
    }

    public List<Reserva> consultarPorHuesped(String idHuesped) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getHuesped().getId().equals(idHuesped)) resultado.add(r);
        }
        return resultado;
    }

    public List<Reserva> consultarPorAlojamiento(String idAlojamiento) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getAlojamiento().getId().equals(idAlojamiento)) resultado.add(r);
        }
        return resultado;
    }

    public Reserva crearReserva(String id, String idHuesped, String idAlojamiento,
                                 LocalDate fechaLlegada, LocalDate fechaSalida, int numeroHuespedes)
            throws IdentificadorInexistenteException, IdentificadorDuplicadoException,
            ReglaDeNegocioException, FechaInvalidaException, EntradaInvalidaException, DatoObligatorioVacioException {

        if (id == null || id.isBlank()) {
            throw new DatoObligatorioVacioException("El identificador de la reserva es obligatorio.");
        }
        for (Reserva r : reservas) {
            if (r.getId().equals(id)) {
                throw new IdentificadorDuplicadoException("Ya existe una reserva con id: " + id);
            }
        }

        Huesped huesped = huespedController.consultarPorId(idHuesped);
        Alojamiento alojamiento = alojamientoController.consultarDetalle(idAlojamiento);

        if (alojamiento.getEstado() != EstadoAlojamiento.ACTIVO) {
            throw new ReglaDeNegocioException("No se puede reservar un alojamiento inactivo.");
        }
        if (fechaLlegada == null || fechaSalida == null) {
            throw new FechaInvalidaException("Las fechas de llegada y salida son obligatorias.");
        }
        if (!fechaSalida.isAfter(fechaLlegada)) {
            throw new FechaInvalidaException("La fecha de salida debe ser posterior a la fecha de llegada.");
        }
        if (numeroHuespedes <= 0) {
            throw new EntradaInvalidaException("El numero de huespedes debe ser mayor que cero.");
        }
        if (numeroHuespedes > alojamiento.getCapacidad()) {
            throw new ReglaDeNegocioException("El numero de huespedes supera la capacidad del alojamiento.");
        }

        long noches = ChronoUnit.DAYS.between(fechaLlegada, fechaSalida);
        double valorBase = noches * alojamiento.getPrecioBase();
        double valorAdicional = alojamiento.calcularValorAdicional(noches);
        double valorTotal = valorBase + valorAdicional;

        Reserva reserva = new Reserva(id, huesped, alojamiento, fechaLlegada, fechaSalida, numeroHuespedes);
        reserva.setValorTotal(valorTotal);
        reserva.setEstado(EstadoReserva.CONFIRMADA);

        reservas.add(reserva);
        guardarCambios();
        return reserva;
    }

    public void cancelarReserva(String id) throws IdentificadorInexistenteException, ReglaDeNegocioException {
        for (Reserva r : reservas) {
            if (r.getId().equals(id)) {
                if (r.getEstado() == EstadoReserva.CANCELADA) {
                    throw new ReglaDeNegocioException("La reserva " + id + " ya se encuentra cancelada.");
                }
                r.setEstado(EstadoReserva.CANCELADA);
                guardarCambios();
                return;
            }
        }
        throw new IdentificadorInexistenteException("No existe una reserva con id: " + id);
    }
}
