package co.edu.unbosque.model;

public class Apartamento extends Alojamiento {

    public Apartamento() {
        super();
    }

    public Apartamento(String id, String nombre, String ciudad, String ubicacion,
                        int capacidad, double precioBase, EstadoAlojamiento estado,
                        String descripcion) {
        super(id, nombre, ciudad, ubicacion, capacidad, precioBase, estado, descripcion);
    }

    @Override
    public double calcularValorAdicional(long noches) {
        // Regla de negocio: un apartamento no incluye cargos adicionales.
        return 0.0;
    }

    @Override
    public String getTipo() {
        return "APARTAMENTO";
    }
}
