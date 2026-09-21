package co.edu.unbosque.dto;

/**
 * Objeto plano de transferencia de datos. No tiene comportamiento de
 * negocio; solo transporta la informacion entre capas y hacia/desde
 * el archivo de persistencia.
 */
public class AlojamientoDTO {

    private String id;
    private String tipo; // APARTAMENTO, CASA, CABANA
    private String nombre;
    private String ciudad;
    private String ubicacion;
    private int capacidad;
    private double precioBase;
    private String estado; // ACTIVO, INACTIVO
    private String descripcion;
    private String serviciosAdicionales; // separados por coma

    public AlojamientoDTO() {
    }

    public AlojamientoDTO(String id, String tipo, String nombre, String ciudad, String ubicacion,
                           int capacidad, double precioBase, String estado, String descripcion,
                           String serviciosAdicionales) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
        this.estado = estado;
        this.descripcion = descripcion;
        this.serviciosAdicionales = serviciosAdicionales;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getServiciosAdicionales() { return serviciosAdicionales; }
    public void setServiciosAdicionales(String serviciosAdicionales) { this.serviciosAdicionales = serviciosAdicionales; }
}
