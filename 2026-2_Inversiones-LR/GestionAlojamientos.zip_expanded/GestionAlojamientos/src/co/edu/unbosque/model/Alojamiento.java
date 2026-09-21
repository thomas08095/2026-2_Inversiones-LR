package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa la generalizacion de todo alojamiento.
 * Aplica Abstraccion (metodo calcularValorAdicional es responsabilidad de
 * cada subtipo) y Encapsulacion (atributos privados con getters/setters).
 */
public abstract class Alojamiento {

    private String id;
    private String nombre;
    private String ciudad;
    private String ubicacion;
    private int capacidad;
    private double precioBase;
    private EstadoAlojamiento estado;
    private String descripcion;
    private List<String> serviciosAdicionales;

    public Alojamiento() {
        this.serviciosAdicionales = new ArrayList<>();
    }

    public Alojamiento(String id, String nombre, String ciudad, String ubicacion,
                        int capacidad, double precioBase, EstadoAlojamiento estado,
                        String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
        this.estado = estado;
        this.descripcion = descripcion;
        this.serviciosAdicionales = new ArrayList<>();
    }

    /**
     * Cada subtipo define su propia regla de negocio para cargos
     * adicionales sobre el valor base (noches x precioBase).
     * Polimorfismo: cada hijo sobreescribe este metodo.
     */
    public abstract double calcularValorAdicional(long noches);

    /**
     * Nombre corto del tipo de alojamiento, usado en reportes y
     * en el archivo plano. Cada subclase lo implementa.
     */
    public abstract String getTipo();

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

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

    public EstadoAlojamiento getEstado() { return estado; }
    public void setEstado(EstadoAlojamiento estado) { this.estado = estado; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<String> getServiciosAdicionales() { return serviciosAdicionales; }
    public void setServiciosAdicionales(List<String> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    @Override
    public String toString() {
        return "[" + getTipo() + "] " + id + " - " + nombre + " (" + ciudad + ") - $" + precioBase
                + "/noche - Cap: " + capacidad + " - Estado: " + estado;
    }
}
