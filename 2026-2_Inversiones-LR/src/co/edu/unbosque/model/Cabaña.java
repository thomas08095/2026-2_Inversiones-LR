package co.edu.unbosque.model;


public class Cabaña extends Alojamiento{

	private final int tarifaServicio = 10000;
	
	public Cabaña() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cabaña(String id, String nombre, String direccion, int capacidad, double precioBase,
			String tipo, Ciudad ciudadEnum, EstadoAlojamiento estado) {
		super(id, nombre, direccion, capacidad, precioBase, estado, ciudadEnum, tipo);
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
