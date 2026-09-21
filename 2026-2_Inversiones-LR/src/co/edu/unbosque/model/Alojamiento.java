package co.edu.unbosque.model;

public abstract class Alojamiento {
	
	private long id;
    private String nombre;
    private String ciudad;
    private String ubicacion;
    private int capacidad;
    private double precioBase;
    private boolean estado = false;
    private String tipo;  
    
	public Alojamiento() {
		super();
	}

	public Alojamiento(long id, String nombre, String ciudad, String ubicacion, int capacidad, double precioBase,
			boolean estado, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.precioBase = precioBase;
		this.estado = estado;
		this.tipo = tipo;
	}
	
	public abstract double getPrecioAdicional();

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
    
    
}
