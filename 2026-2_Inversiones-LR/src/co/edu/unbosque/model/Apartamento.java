package co.edu.unbosque.model;

/**
 * Representa un alojamiento de tipo Apartamento.
 * Extiende de la clase base Alojamiento e implementa sus métodos abstractos.
 * Los apartamentos no incluyen tarifas de servicio adicionales.
 */
public class Apartamento extends Alojamiento{

	/**
	 * Constructor por defecto de la clase Apartamento.
	 */
	public Apartamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado para inicializar un Apartamento.
	 * 
	 * @param id Identificador único.
	 * @param nombre Nombre descriptivo.
	 * @param direccion Ubicación física.
	 * @param capacidad Capacidad máxima de personas.
	 * @param precioBase Precio base por noche.
	 * @param tipo Categoría del alojamiento.
	 * @param ciudadEnum Ciudad donde se ubica.
	 * @param estado Estado actual del apartamento.
	 */
	public Apartamento(String id, String nombre, String direccion, int capacidad, double precioBase
			, String tipo, Ciudad ciudadEnum, EstadoAlojamiento estado) {
		super(id, nombre, direccion, capacidad, precioBase,estado, ciudadEnum, tipo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calcula el valor total de la reserva para un apartamento.
	 * En este caso, el cálculo es únicamente el precio base por el número de noches.
	 * 
	 * @param numeroDeNoches Cantidad de noches reservadas.
	 * @return Valor total de la reserva sin recargos.
	 */
	@Override
	public double calcularValorReserva(int numeroDeNoches) {
		// TODO Auto-generated method stub
		return (getPrecioBase() * numeroDeNoches);
	}

	/**
	 * Obtiene el identificador de tipo para este alojamiento.
	 * 
	 * @return La cadena "Apartamento".
	 */
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Apartamento";
	}
}
