package co.edu.unbosque.controller;

import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.EstadoReserva;
import co.edu.unbosque.model.Reserva;

import java.util.*;

public class ReporteController {

    private final AlojamientoController alojamientoController;
    private final ReservaController reservaController;

    public ReporteController(AlojamientoController alojamientoController, ReservaController reservaController) {
        this.alojamientoController = alojamientoController;
        this.reservaController = reservaController;
    }

    /** Reporte 1: cantidad de alojamientos registrados agrupados por ciudad. */
    public Map<String, Integer> alojamientosPorCiudad() {
        Map<String, Integer> resultado = new TreeMap<>();
        for (Alojamiento a : alojamientoController.consultarTodos()) {
            resultado.merge(a.getCiudad(), 1, Integer::sum);
        }
        return resultado;
    }

    /** Reporte 2: alojamientos disponibles (ACTIVO) agrupados por tipo. */
    public Map<String, Integer> alojamientosDisponiblesPorTipo() {
        Map<String, Integer> resultado = new TreeMap<>();
        for (Alojamiento a : alojamientoController.consultarTodos()) {
            if (a.getEstado().name().equals("ACTIVO")) {
                resultado.merge(a.getTipo(), 1, Integer::sum);
            }
        }
        return resultado;
    }

    /** Reporte 3: cantidad de alojamientos por tipo (sin filtrar por estado). */
    public Map<String, Integer> cantidadAlojamientosPorTipo() {
        Map<String, Integer> resultado = new TreeMap<>();
        for (Alojamiento a : alojamientoController.consultarTodos()) {
            resultado.merge(a.getTipo(), 1, Integer::sum);
        }
        return resultado;
    }

    /** Reporte 4: total de reservas confirmadas. */
    public long totalReservasConfirmadas() {
        return reservaController.consultarTodas().stream()
                .filter(r -> r.getEstado() == EstadoReserva.CONFIRMADA)
                .count();
    }

    /** Reporte 5: total de reservas canceladas. */
    public long totalReservasCanceladas() {
        return reservaController.consultarTodas().stream()
                .filter(r -> r.getEstado() == EstadoReserva.CANCELADA)
                .count();
    }

    /** Reporte 6: ingresos estimados asociados a las reservas confirmadas. */
    public double ingresosEstimados() {
        return reservaController.consultarTodas().stream()
                .filter(r -> r.getEstado() == EstadoReserva.CONFIRMADA)
                .mapToDouble(Reserva::getValorTotal)
                .sum();
    }

    /** Reporte 7: el alojamiento con mayor numero de reservas (todas, sin importar estado). */
    public String alojamientoConMasReservas() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Reserva r : reservaController.consultarTodas()) {
            conteo.merge(r.getAlojamiento().getId(), 1, Integer::sum);
        }
        return conteo.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> e.getKey() + " (" + e.getValue() + " reservas)")
                .orElse("No hay reservas registradas.");
    }
}
