package co.edu.unbosque.model;

public class Casa extends Alojamiento{

	public Casa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Casa(int id, String nombre, String ciudad, String ubicacion, int capacidad, double precioBase,
			boolean cancelado, String tipo, Ciudad ciudadEnum, EstadoAlojamiento estado) {
		super(id, nombre, ciudad, ubicacion, capacidad, precioBase, cancelado, estado, ciudadEnum, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrecioAdicional() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
