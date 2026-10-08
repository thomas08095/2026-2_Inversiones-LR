package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa una reserva de alojamiento realizada por un huésped.
 * Contiene la lógica de negocio para validar fechas, capacidades y calcular estancias.
 */
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
	
	/**
	 * Constructor por defecto de la clase Reserva.
	 */
	public Reserva() {
		super();
	}

	/**
	 * Constructor parametrizado para inicializar una reserva completa.
	 * 
	 * @param id Identificador único de la reserva.
	 * @param huesped Objeto Huesped titular de la reserva.
	 * @param alojamiento Objeto Alojamiento reservado.
	 * @param fechaLlegada Fecha programada para el ingreso.
	 * @param fechaSalida Fecha programada para la salida.
	 * @param numeroHuespedes Cantidad total de personas a hospedarse.
	 * @param numeroDeNoches Cantidad calculada de noches.
	 * @param valorTotal Valor financiero total de la reserva.
	 * @param estado Estado actual de la reserva (CONFIRMADA, CANCELADA).
	 */
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
	
	/**
	 * Valida las reglas de negocio cronológicas para las fechas de la reserva.
	 * Verifica nulidad, coherencia temporal y que las fechas no sean en el pasado.
	 * 
	 * @throws ProgramException Si las fechas están vacías, son inválidas o incoherentes.
	 */
	public void validarFechas() throws ProgramException {
		if(this.fechaLlegada == null || this.fechaSalida == null) {
	        throw new ProgramException("Las fechas de llegada y salida no pueden estar vacías.");
	    }
		
		LocalDate hoy = LocalDate.now();
	    if(this.fechaLlegada.isBefore(hoy)) {
	        throw new ProgramException("La fecha de llegada no puede ser anterior a la fecha actual.");
	    }
	    
	    if(!this.fechaSalida.isAfter(this.fechaLlegada)) {
	        throw new ProgramException("La fecha de salida debe ser estrictamente posterior a la fecha de llegada.");
	    }
	}
	
	/**
	 * Calcula el número de noches entre la fecha de llegada y la fecha de salida.
	 * 
	 * @return Cantidad entera de noches calculadas.
	 * @throws ProgramException Si las fechas no cumplen las validaciones de negocio.
	 */
	public int calcularNumNoches() throws ProgramException {
		validarFechas();
        long noches = ChronoUnit.DAYS.between(this.fechaLlegada, this.fechaSalida);
        return (int) noches;
    }
    
	/**
	 * Valida que la cantidad de huéspedes ingresada sea válida y no supere
	 * la capacidad máxima del alojamiento seleccionado.
	 * 
	 * @throws ProgramException Si la cantidad es menor a 1 o excede la capacidad del alojamiento.
	 */
    public void validarCantidadHuespedes() throws ProgramException {
        if(this.numeroHuespedes <= 0) {
            throw new ProgramException("El número de huéspedes debe ser mayor que cero");
        }
        
        if(this.alojamiento == null) {
            throw new ProgramException("Debe asignar un alojamiento antes de validar los huéspedes");
        }
        
        if(this.numeroHuespedes > this.alojamiento.getCapacidad()) {
            throw new ProgramException("El número de huéspedes supera la capacidad del alojamiento");
        }
	}
	
    /**
     * Obtiene el identificador de la reserva.
     * @return ID de la reserva.
     */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador de la reserva.
	 * @param id Nuevo identificador.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el huésped asociado a la reserva.
	 * @return Objeto Huesped.
	 */
	public Huesped getHuesped() {
		return huesped;
	}

	/**
	 * Establece el huésped asociado a la reserva.
	 * @param huesped Nuevo titular.
	 */
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

	/**
	 * Obtiene el alojamiento reservado.
	 * @return Objeto Alojamiento.
	 */
	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	/**
	 * Establece el alojamiento a reservar.
	 * @param alojamiento Nuevo alojamiento.
	 */
	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	/**
	 * Obtiene la fecha de llegada de la reserva.
	 * @return Fecha de ingreso.
	 */
	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}

	/**
	 * Establece la fecha de llegada de la reserva.
	 * @param fechaLlegada Nueva fecha de ingreso.
	 */
	public void setFechaLlegada(LocalDate fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	/**
	 * Obtiene la fecha de salida de la reserva.
	 * @return Fecha de salida.
	 */
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Establece la fecha de salida de la reserva.
	 * @param fechaSalida Nueva fecha de salida.
	 */
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Obtiene la cantidad de huéspedes registrados para la estadía.
	 * @return Número de huéspedes.
	 */
	public int getNumeroHuespedes() {
		return numeroHuespedes;
	}

	/**
	 * Establece la cantidad de huéspedes registrados para la estadía.
	 * @param numeroHuespedes Nueva cantidad de huéspedes.
	 */
	public void setNumeroHuespedes(int numeroHuespedes) {
		this.numeroHuespedes = numeroHuespedes;
	}

	/**
	 * Obtiene el número calculado de noches.
	 * @return Cantidad de noches.
	 */
	public int getNumeroDeNoches() {
		return numeroDeNoches;
	}

	/**
	 * Establece el número de noches de la reserva.
	 * @param numeroDeNoches Cantidad de noches.
	 */
	public void setNumeroDeNoches(int numeroDeNoches) {
		this.numeroDeNoches = numeroDeNoches;
	}

	/**
	 * Obtiene el valor financiero total a pagar por la reserva.
	 * @return Total de la reserva.
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * Establece el valor financiero total a pagar por la reserva.
	 * @param valorTotal Nuevo valor total.
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * Obtiene el estado actual de la reserva.
	 * @return Estado de la reserva.
	 */
	public EstadoReserva getEstado() {
		return estado;
	}

	/**
	 * Establece el estado de la reserva.
	 * @param estado Nuevo estado.
	 */
	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}
	
	/**
	 * Enumeración que define los estados posibles que puede tomar una reserva.
	 */
	public enum EstadoReserva {
		CONFIRMADA, CANCELADA
	}
}


