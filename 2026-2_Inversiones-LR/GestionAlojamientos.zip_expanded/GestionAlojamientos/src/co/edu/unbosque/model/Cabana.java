package co.edu.unbosque.model;

public class Cabana extends Alojamiento {

    private static final double PORCENTAJE_SERVICIO = 0.10;

    public Cabana() {
        super();
    }

    public Cabana(String id, String nombre, String ciudad, String ubicacion,
                  int capacidad, double precioBase, EstadoAlojamiento estado,
                  String descripcion) {
        super(id, nombre, ciudad, ubicacion, capacidad, precioBase, estado, descripcion);
    }

    @Override
    public double calcularValorAdicional(long noches) {
        // Regla de negocio: la cabana cobra un 10% de tarifa de servicio
        // sobre el valor base (noches x precioBase).
        return getPrecioBase() * noches * PORCENTAJE_SERVICIO;
    }

    @Override
    public String getTipo() {
        return "CABANA";
    }
}
