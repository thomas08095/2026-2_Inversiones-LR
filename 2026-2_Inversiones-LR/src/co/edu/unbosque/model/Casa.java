package co.edu.unbosque.model;

public class Casa extends Alojamiento{

	public Casa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Casa(int id, String nombre, String ciudad, String ubicacion, int capacidad, double precioBase,
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
