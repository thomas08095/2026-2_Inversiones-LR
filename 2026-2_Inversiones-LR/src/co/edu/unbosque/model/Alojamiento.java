package co.edu.unbosque.model;

public abstract class Alojamiento {
	
	private int id;
    private String nombre;
    private String ciudad;
    private String ubicacion;
    private int capacidad;
    private double precioBase;
    private boolean cancelado = false;
    protected  EstadoAlojamiento estado;
    protected  Ciudad ciudadEnum;
    private String tipo;  
    
	public Alojamiento() {
		super();
	}


	public Alojamiento(int id, String nombre, String ciudad, String ubicacion, int capacidad, double precioBase,
			boolean cancelado, EstadoAlojamiento estado, Ciudad ciudadEnum, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.precioBase = precioBase;
		this.cancelado = cancelado;
		this.estado = estado;
		this.ciudadEnum = ciudadEnum;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public abstract String getTipo();

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public EstadoAlojamiento getEstado() {
		return estado;
	}


	public void setEstado(EstadoAlojamiento estado) {
		this.estado = estado;
	}


	public Ciudad getCiudadEnum() {
		return ciudadEnum;
	}


	public void setCiudadEnum(Ciudad ciudadEnum) {
		this.ciudadEnum = ciudadEnum;
	}

	public void activarAlojamiento() { 
		this.estado = EstadoAlojamiento.ACTIVO; 
	}

	public void desactivarAlojamiento() { 
		this.estado = EstadoAlojamiento.INACTIVO;
	}

	public abstract double calcularValorReserva(int numeroDeNoches);
	

	public enum EstadoAlojamiento {

		ACTIVO, INACTIVO
	}
	
	public enum Ciudad {
        BOGOTA,
        MEDELLIN,
        CUCUTA,
        CARACAS,
        BUENOS_AIRES,
        BARRACABERMEJA
    }
    
    
}
