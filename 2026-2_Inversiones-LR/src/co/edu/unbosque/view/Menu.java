package co.edu.unbosque.view;

public class Menu {
	
	private static String txt = "";
	
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
	
	public static String menu_ALOJAMIENTOS() {
		txt = ("||====== ALOJAMIENTOS =======||\n\n"
				+ "| 1. Consultar Alojamientos.\n"
				+ "| 2. Buscar Alojamientos.\n"
				+ "| 3. Consultar Detalles de Alojamientos.\n\n"
				+ "||=============================||\n");
		return txt;
	}
	
	public static String menu_ALOJAMIENTOS_CIUDADES() {
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
	
	public static String menu_ALOJAMIENTOS_TIPOS() {
		txt = ("||====== CIUDADES =======||\n\n"
				+ "| 1. CASA.\n"
				+ "| 2. APARTAMENTO.\n"
				+ "| 3. CABAÑA.\n\n"
				+ "||=============================||\n");
		return txt;
	}
	
	public static String menu_HUESPEDES() {
		txt = ("||====== HUESPEDES =======||\n\n"
				+ "| 1. Registrar Huespedes.\n"
				+ "| 2. Consultar Detalles de Huespedes.\n\n"
				+ "||=============================||\n");
		return txt;
	}
	
	public static String menu_RESERVAS() {
		txt = ("||=========== RESERVAS ===========||\n\n"
				+ "| 1. Crear Reserva.\n"
				+ "| 2. Consultar Detalles de Reserva.\n"
				+ "| 3. Cancelar Reserva.\n\n"
				+ "| 4. Matar a Henry (La paz nunca fue una opción) \n\n"
				+ "||=============================||\n");
		return txt;
	}
	
	

}
