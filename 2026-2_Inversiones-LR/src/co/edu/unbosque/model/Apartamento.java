package co.edu.unbosque.model;


public class Apartamento extends Alojamiento{

	public Apartamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartamento(String id, String nombre, String direccion, int capacidad, double precioBase
			, String tipo, Ciudad ciudadEnum, EstadoAlojamiento estado) {
		super(id, nombre, direccion, capacidad, precioBase,estado, ciudadEnum, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularValorReserva(int numeroDeNoches) {
		// TODO Auto-generated method stub
		return (getPrecioBase() * numeroDeNoches);
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Apartamento";
	}
	
	

}
