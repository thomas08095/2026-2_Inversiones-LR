package co.edu.unbosque.model;

public class Casa extends Alojamiento {

    private static final double TARIFA_LIMPIEZA = 50000.0;

    public Casa() {
        super();
    }

    public Casa(String id, String nombre, String ciudad, String ubicacion,
                int capacidad, double precioBase, EstadoAlojamiento estado,
                String descripcion) {
        super(id, nombre, ciudad, ubicacion, capacidad, precioBase, estado, descripcion);
    }

    @Override
    public double calcularValorAdicional(long noches) {
        // Regla de negocio: toda reserva de una casa paga una tarifa
        // fija de limpieza, sin importar el numero de noches.
        return TARIFA_LIMPIEZA;
    }

    @Override
    public String getTipo() {
        return "CASA";
    }
}
