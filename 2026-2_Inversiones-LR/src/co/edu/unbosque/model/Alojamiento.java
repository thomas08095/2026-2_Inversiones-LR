package co.edu.unbosque.model;

public abstract class Alojamiento {
	
	private String id;
    private String nombre;
    private String direccion;
    private int capacidad;
    private double precioBase;
    public  EstadoAlojamiento estado;
    public  Ciudad ciudadEnum;
    private String tipo;  
    
	public Alojamiento() {
		super();
	}


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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public void canceladoAlojamiento() { 
		this.estado = EstadoAlojamiento.CANCELADO;
	}

	public abstract double calcularValorReserva(int numeroDeNoches);
	

	public enum EstadoAlojamiento {
		ACTIVO, CANCELADO
	}
	
	public enum Ciudad {
        BOGOTA,
        MEDELLIN,
        BARRACABERMEJA
    }
    
    
}
