package co.edu.unbosque.model;

import java.time.LocalDate;

public class Reserva {

    private String id;
    private Huesped huesped;
    private Alojamiento alojamiento;
    private LocalDate fechaLlegada;
    private LocalDate fechaSalida;
    private int numeroHuespedes;
    private long numeroNoches;
    private double valorTotal;
    private EstadoReserva estado;

    public Reserva() {
    }

    public Reserva(String id, Huesped huesped, Alojamiento alojamiento,
                    LocalDate fechaLlegada, LocalDate fechaSalida, int numeroHuespedes) {
        this.id = id;
        this.huesped = huesped;
        this.alojamiento = alojamiento;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.numeroHuespedes = numeroHuespedes;
        this.numeroNoches = java.time.temporal.ChronoUnit.DAYS.between(fechaLlegada, fechaSalida);
        this.estado = EstadoReserva.CONFIRMADA;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Huesped getHuesped() { return huesped; }
    public void setHuesped(Huesped huesped) { this.huesped = huesped; }

    public Alojamiento getAlojamiento() { return alojamiento; }
    public void setAlojamiento(Alojamiento alojamiento) { this.alojamiento = alojamiento; }

    public LocalDate getFechaLlegada() { return fechaLlegada; }
    public void setFechaLlegada(LocalDate fechaLlegada) { this.fechaLlegada = fechaLlegada; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }

    public int getNumeroHuespedes() { return numeroHuespedes; }
    public void setNumeroHuespedes(int numeroHuespedes) { this.numeroHuespedes = numeroHuespedes; }

    public long getNumeroNoches() { return numeroNoches; }
    public void setNumeroNoches(long numeroNoches) { this.numeroNoches = numeroNoches; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public EstadoReserva getEstado() { return estado; }
    public void setEstado(EstadoReserva estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Reserva " + id + " - Huesped: " + (huesped != null ? huesped.getId() : "N/A")
                + " - Alojamiento: " + (alojamiento != null ? alojamiento.getId() : "N/A")
                + " - " + fechaLlegada + " a " + fechaSalida
                + " - Noches: " + numeroNoches + " - Total: $" + valorTotal
                + " - Estado: " + estado;
    }
}
