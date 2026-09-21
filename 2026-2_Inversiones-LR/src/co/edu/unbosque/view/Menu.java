package co.edu.unbosque.view;

import java.util.Scanner;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void start() {
		boolean end = false;
		int respuesta = 0;
		while(!end) {
			menu_PRINCIPAL();
			respuesta = sc.nextInt();
			
			switch(respuesta) {
			case 1:
				menu_ALOJAMIENTOS();
				respuesta = sc.nextInt();
				break;
			case 2:
				menu_HUESPEDES();
				respuesta = sc.nextInt();
				break;
			case 3:
				menu_RESERVAS();
				respuesta = sc.nextInt();
				break;
			case 4:
				break;
			case 5:
				end = true;
				System.out.println("\n!! == MUCHAS GRACIAS == !!\n");
				break;
			default:
				System.out.println("\n!! == OPCION INVALIDA == !!\n");
				break;
			}
		}
	}
	
	public static void menu_PRINCIPAL() {
		System.out.println("||====== INVERSIONES LR =======||\n\n"
				+ "| 1. Gestion de Alejamientos.\n"
				+ "| 2. Gestion de Huespedes.\n"
				+ "| 3. Gestion de Reservas.\n"
				+ "| 4. Reportes.\n"
				+ "| 5. Salir\n\n"
				+ "||=============================||\n");
	}
	
	public static void menu_ALOJAMIENTOS() {
		System.out.println("||====== ALOJAMIENTOS =======||\n\n"
				+ "| 1. Consultar Alojamientos.\n"
				+ "| 2. Buscar Alojamientos.\n"
				+ "| 3. Consultar Detalles de Alojamientos.\n\n"
				+ "||=============================||\n");
	}
	
	public static void menu_HUESPEDES() {
		System.out.println("||====== HUESPEDES =======||\n\n"
				+ "| 1. Registrar Huespedes.\n"
				+ "| 2. Consultar Detalles de Huespedes.\n\n"
				+ "||=============================||\n");
	}
	
	public static void menu_RESERVAS() {
		System.out.println("||=========== RESERVAS ===========||\n\n"
				+ "| 1. Crear Reserva.\n"
				+ "| 2. Consultar Detalles de Reserva.\n"
				+ "| 3. Cancelar Reserva.\n\n"
				+ "| 4. Matar a Henry (La paz nunca fue una opción) \n\n"
				+ "||=============================||\n");
		
		
	}
	
	public static void menu_RESERVASVOID() {
		System.out.println("||=========== RESERVAS ===========||\n\n"
				+ "| 1. Crear Reserva.\n"
				+ "| 2. Consultar Detalles de Reserva.\n"
				+ "| 3. Cancelar Reserva.\n\n"
				+ "| 4. Matar a Henry (La paz nunca fue una opción) \n\n"
				+ "||=============================||\n");
		
		
	}

}
