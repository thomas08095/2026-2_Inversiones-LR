package co.edu.unbosque.model;

public class Casa extends Alojamiento{

	private final int tarifaServicio = 15000;

	public Casa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Casa(String id, String nombre, String direccion, int capacidad, double precioBase,
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
		return "Casa";
	}

	

}
