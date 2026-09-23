package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
	
	private String id;
	private Huesped huesped;
	private Alojamiento alojamiento;
	private LocalDate fechaLlegada;
    private LocalDate fechaSalida; 
	private int numeroHuespedes;
	private int numeroDeNoches;
	private double valorTotal;
	private EstadoReserva estado;
	
	public Reserva() {
		super();
	}

	public Reserva(String id, Huesped huesped, Alojamiento alojamiento, LocalDate fechaLlegada, LocalDate fechaSalida,
			int numeroHuespedes, int numeroDeNoches, double valorTotal, EstadoReserva estado) {
		super();
		this.id = id;
		this.huesped = huesped;
		this.alojamiento = alojamiento;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.numeroHuespedes = numeroHuespedes;
		this.numeroDeNoches = numeroDeNoches;
		this.valorTotal = valorTotal;
		this.estado = estado;
	}
	
	public int calcularNumNoches() {
		if(this.fechaLlegada == null && this.fechaSalida == null) {
			return 0;
		}
		long noches = ChronoUnit.DAYS.between(this.fechaLlegada, this.fechaSalida);
		
		if(noches <= 0) {
			throw new IllegalArgumentException("La fecha de salida debe ser posterior a la fecha de llegada");
		}
		
		return this.numeroDeNoches;
	}
	
	public void validarCantidadHuespedes() {
		if(this.numeroHuespedes <= 0) {
			throw new IllegalArgumentException("El número de huéspedes debe ser mayor que cero");
		}
		
		if(this.alojamiento == null) {
			throw new IllegalStateException("Debe asignar un alojamiento antes de validar los huéspedes");
		}
		
		if(this.numeroHuespedes > this.alojamiento.getCapacidad()) {
			throw new IllegalArgumentException("El número de huéspedes supera la capacidad del alojamiento");
		}
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(LocalDate fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getNumeroHuespedes() {
		return numeroHuespedes;
	}

	public void setNumeroHuespedes(int numeroHuespedes) {
		this.numeroHuespedes = numeroHuespedes;
	}

	public int getNumeroDeNoches() {
		return numeroDeNoches;
	}

	public void setNumeroDeNoches(int numeroDeNoches) {
		this.numeroDeNoches = numeroDeNoches;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public EstadoReserva getEstado() {
		return estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}
	
	
	public enum EstadoReserva {

		CONFIRMADA, CANCELADA, PENDIENTE
	}
	
	
	
}
