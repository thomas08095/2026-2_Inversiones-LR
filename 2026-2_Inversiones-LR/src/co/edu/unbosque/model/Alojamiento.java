package co.edu.unbosque.model;

/**
 * Clase abstracta que representa un alojamiento genérico en el sistema.
 * Define los atributos fundamentales y los comportamientos base que deben 
 * compartir todos los tipos de alojamientos (Casa, Apartamento, Cabaña, etc.).
 */
public abstract class Alojamiento {
	
	private String id;
    private String nombre;
    private String direccion;
    private int capacidad;
    private double precioBase;
    public  EstadoAlojamiento estado;
    public  Ciudad ciudadEnum;
    private String tipo; 
    
    /**
     * Constructor por defecto de la clase Alojamiento.
     */
    
	public Alojamiento() {
		super();
	}
	/**
     * Constructor parametrizado para inicializar un alojamiento con todos sus datos.
     * 
     * @param id Identificador único del alojamiento.
     * @param nombre Nombre comercial o descriptivo del alojamiento.
     * @param direccion Dirección física donde se encuentra ubicado.
     * @param capacidad Cantidad máxima de personas que puede albergar.
     * @param precioBase Valor base del alquiler por noche.
     * @param estado Estado actual de disponibilidad (ACTIVO, OCUPADO, CANCELADO).
     * @param ciudadEnum Ciudad donde se ubica el alojamiento.
     * @param tipo Categoría del alojamiento (Casa, Apartamento, etc.).
     */
	public Alojamiento(String id, String nombre, String direccion, int capacidad, double precioBase
			, EstadoAlojamiento estado, Ciudad ciudadEnum, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.capacidad = capacidad;
		this.precioBase = precioBase;
		this.estado = estado;
		this.ciudadEnum = ciudadEnum;
		this.tipo = tipo;
	}

	/**
	 * Obtiene el identificador del alojamiento.
	 * @return ID del alojamiento.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador del alojamiento.
	 * @param id Nuevo identificador.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del alojamiento.
	 * @return Nombre del alojamiento.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del alojamiento.
	 * @param nombre Nuevo nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la dirección del alojamiento.
	 * @return Dirección del alojamiento.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección del alojamiento.
	 * @param direccion Nueva dirección.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene la capacidad máxima de huéspedes.
	 * @return Capacidad del alojamiento.
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Establece la capacidad máxima de huéspedes.
	 * @param capacidad Nueva capacidad.
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Obtiene el precio base por noche.
	 * @return Precio base del alojamiento.
	 */
	public double getPrecioBase() {
		return precioBase;
	}

	/**
	 * Establece el precio base por noche.
	 * @param precioBase Nuevo precio base.
	 */
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	/**
	 * Método abstracto que debe ser implementado por las clases hijas 
	 * para retornar el tipo específico de alojamiento.
	 * 
	 * @return Cadena de texto con el tipo de alojamiento.
	 */
	public abstract String getTipo();

	/**
	 * Establece el tipo de alojamiento.
	 * @param tipo Nuevo tipo de alojamiento.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Obtiene el estado actual de disponibilidad.
	 * @return Estado del alojamiento.
	 */
	public EstadoAlojamiento getEstado() {
		return estado;
	}

	/**
	 * Establece un nuevo estado de disponibilidad.
	 * @param estado Nuevo estado.
	 */
	public void setEstado(EstadoAlojamiento estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene la ciudad donde se encuentra el alojamiento.
	 * @return Enumerador con la ciudad.
	 */
	public Ciudad getCiudadEnum() {
		return ciudadEnum;
	}

	/**
	 * Establece la ciudad donde se encuentra el alojamiento.
	 * @param ciudadEnum Nueva ciudad.
	 */
	public void setCiudadEnum(Ciudad ciudadEnum) {
		this.ciudadEnum = ciudadEnum;
	}

	/**
	 * Cambia el estado del alojamiento a ACTIVO, dejándolo disponible para reservas.
	 */
	public void activarAlojamiento() { 
		this.estado = EstadoAlojamiento.ACTIVO; 
	}

	/**
	 * Cambia el estado del alojamiento a CANCELADO, inhabilitándolo para reservas.
	 */
	public void canceladoAlojamiento() { 
		this.estado = EstadoAlojamiento.CANCELADO;
	}

	/**
	 * Método abstracto para calcular el valor total de una reserva.
	 * Cada clase hija debe implementar sus propias reglas y tarifas adicionales.
	 * 
	 * @param numeroDeNoches Cantidad de noches a reservar.
	 * @return Valor total calculado.
	 */
	public abstract double calcularValorReserva(int numeroDeNoches);
	
	/**
	 * Enumeración que define los estados posibles de un alojamiento.
	 */
	public enum EstadoAlojamiento {
		ACTIVO, OCUPADO, CANCELADO
	}
	
	/**
	 * Enumeración que define las ciudades donde la empresa opera.
	 */
	public enum Ciudad {
        BOGOTA,
        MEDELLIN,
        BARRACABERMEJA
    }
}
