package co.edu.unbosque.model;

/**
 * Representa un alojamiento de tipo Casa.
 * Extiende de la clase base Alojamiento e incluye una tarifa de limpieza/servicio fija.
 */
public class Casa extends Alojamiento{

	/** Tarifa adicional fija por servicio aplicable a las casas. */
	private final int tarifaServicio = 15000;

	/**
	 * Constructor por defecto de la clase Casa.
	 */
	public Casa() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado para inicializar una Casa.
	 * 
	 * @param id Identificador único.
	 * @param nombre Nombre descriptivo.
	 * @param direccion Ubicación física.
	 * @param capacidad Capacidad máxima de personas.
	 * @param precioBase Precio base por noche.
	 * @param tipo Categoría del alojamiento.
	 * @param ciudadEnum Ciudad donde se ubica.
	 * @param estado Estado actual de la casa.
	 */
	public Casa(String id, String nombre, String direccion, int capacidad, double precioBase,
			String tipo, Ciudad ciudadEnum, EstadoAlojamiento estado) {
		super(id, nombre, direccion, capacidad, precioBase, estado, ciudadEnum, tipo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calcula el valor total de la reserva para una casa.
	 * Incluye el costo de las noches más la tarifa de servicio específica.
	 * 
	 * @param numeroDeNoches Cantidad de noches reservadas.
	 * @return Valor total de la reserva con recargo de servicio.
	 */
	@Override
	public double calcularValorReserva(int numeroDeNoches) {
		// TODO Auto-generated method stub
		return (getPrecioBase() * numeroDeNoches)+tarifaServicio;
	}

	/**
	 * Obtiene el identificador de tipo para este alojamiento.
	 * 
	 * @return La cadena "Casa".
	 */
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Casa";
	}
}

