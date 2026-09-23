package co.edu.unbosque.model;


public class Cabaña extends Alojamiento{

	private final int tarifaServicio = 10000;
	
	public Cabaña() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cabaña(int id, String nombre, String ciudad, String ubicacion, int capacidad, double precioBase,
			boolean cancelado, String tipo, Ciudad ciudadEnum, EstadoAlojamiento estado) {
		super(id, nombre, ciudad, ubicacion, capacidad, precioBase, cancelado, estado, ciudadEnum, tipo);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double calcularValorReserva(int numeroDeNoches) {
		// TODO Auto-generated method stub
		return (getPrecioBase() * numeroDeNoches)+tarifaServicio;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Cabaña";
	}
}
