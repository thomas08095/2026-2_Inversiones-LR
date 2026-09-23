package co.edu.unbosque.model;

import co.edu.unbosque.model.Alojamiento.Ciudad;
import co.edu.unbosque.model.Alojamiento.EstadoAlojamiento;

public class Apartamento extends Alojamiento{

	public Apartamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartamento(int id, String nombre, String ciudad, String ubicacion, int capacidad, double precioBase,
			boolean cancelado, String tipo, Ciudad ciudadEnum, EstadoAlojamiento estado) {
		super(id, nombre, ciudad, ubicacion, capacidad, precioBase, cancelado, estado, ciudadEnum, tipo);
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
