package co.edu.unbosque.model;

public class Apartamento extends Alojamiento{

	public Apartamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartamento(long id, String nombre, String ciudad, String ubicacion, int capacidad, double precioBase,
			boolean cancelado, String tipo) {
		super(id, nombre, ciudad, ubicacion, capacidad, precioBase, cancelado, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrecioAdicional() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
