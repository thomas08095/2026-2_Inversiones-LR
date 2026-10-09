package co.edu.unbosque.view;

/**
 * Clase de la vista encargada de construir los textos de los menús del sistema.
 * Cada método retorna el menú como una cadena lista para mostrarse al usuario.
 */
public class Menu {
	
	/** Texto del último menú construido; es compartido por todos los métodos. */
	private static String txt = "";
	
	/**
	 * Construye el menú principal de Inversiones LR.
	 * 
	 * @return Texto con las opciones: alojamientos, huéspedes, reservas, reportes y salir.
	 */
	public static String menu_PRINCIPAL() {
		txt = ("||====== INVERSIONES LR =======||\n\n"
				+ "| 1. Gestion de Alejamientos.\n"
				+ "| 2. Gestion de Huespedes.\n"
				+ "| 3. Gestion de Reservas.\n"
				+ "| 4. Reportes.\n"
				+ "| 5. Salir\n\n"
				+ "||=============================||\n");
		return txt;
		
	}
	
	/**
	 * Construye el menú de gestión de alojamientos.
	 * 
	 * @return Texto con las opciones de consultar y buscar alojamientos.
	 */
	public static String menu_ALOJAMIENTOS() {
		txt = ("||====== ALOJAMIENTOS =======||\n\n"
				+ "| 1. Consultar Alojamientos.\n"
				+ "| 2. Buscar Alojamientos.\n"
				+ "||=============================||\n");
		return txt;
	}
	
	/**
	 * Construye el menú con la lista de ciudades disponibles.
	 * 
	 * @return Texto con las ciudades que se pueden elegir.
	 */
	public String menu_ALOJAMIENTOS_CIUDADES() {
		txt = ("||====== CIUDADES =======||\n\n"
				+ "| 1. BOGOTA.\n"
				+ "| 2. MEDELLIN.\n"
				+ "| 3. CUCUTA.\n"
				+ "| 4. CARACAS.\n"
				+ "| 3. BUENOS AIRES.\n"
				+ "| 5. BARRACABERMEJA.\n\n"
				+ "||=============================||\n");
		return txt;
	}
	
	/**
	 * Construye el menú con los tipos de alojamiento disponibles.
	 * 
	 * @return Texto con las opciones: casa, apartamento y cabaña.
	 */
	public String menu_ALOJAMIENTOS_TIPOS() {
		txt = ("||====== CIUDADES =======||\n\n"
				+ "| 1. CASA.\n"
				+ "| 2. APARTAMENTO.\n"
				+ "| 3. CABAÑA.\n\n"
				+ "||=============================||\n");
		return txt;
	}
	
	/**
	 * Construye el menú de gestión de huéspedes.
	 * 
	 * @return Texto con las opciones de registrar y consultar huéspedes.
	 */
	public String menu_HUESPEDES() {
		txt = ("||====== HUESPEDES =======||\n\n"
				+ "| 1. Registrar Huespedes.\n"
				+ "| 2. Consultar Detalles de Huespedes.\n\n"
				+ "||=============================||\n");
		return txt;
	}
	
	/**
	 * Construye el menú de gestión de huéspedes (variante con el mismo contenido
	 * que {@link #menu_HUESPEDES()}).
	 * 
	 * @return Texto con las opciones de registrar y consultar huéspedes.
	 */
	public static String menu_HUESPEDES_() {
		txt = ("||====== HUESPEDES =======||\n\n"
				+ "| 1. Registrar Huespedes.\n"
				+ "| 2. Consultar Detalles de Huespedes.\n\n"
				+ "||=============================||\n");
		return txt;
	}
	
	/**
	 * Construye el menú de gestión de reservas.
	 * 
	 * @return Texto con las opciones de crear, consultar y cancelar reservas.
	 */
	public String menu_RESERVAS() {
		txt = ("||=========== RESERVAS ===========||\n\n"
				+ "| 1. Crear Reserva.\n"
				+ "| 2. Consultar Detalles de Reserva.\n"
				+ "| 3. Cancelar Reserva.\n\n"
				+ "||=============================||\n");
		return txt;
	}
	
	

}