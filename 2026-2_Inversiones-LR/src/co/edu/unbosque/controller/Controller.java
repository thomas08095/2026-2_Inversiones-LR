package co.edu.unbosque.controller;
import co.edu.unbosque.view.*;

public class Controller {
	

		private static Menu menu = new Menu();
		private static VentanaEmergente ventana = new VentanaEmergente();
		
		
		public static void start() {
			
			boolean end = false;
			int respuesta = 0;
			while(!end) {
				respuesta = ventana.LeerInt(menu.menu_PRINCIPAL());
				
				switch(respuesta) {
				case 1:
					respuesta = ventana.LeerInt(menu.menu_ALOJAMIENTOS());
					break;
				case 2:
					respuesta = ventana.LeerInt(menu.menu_HUESPEDES());
					break;
				case 3:
					respuesta = ventana.LeerInt(menu.menu_RESERVAS());
					break;
				case 4:
					break;
				case 5:
					end = true;
					ventana.mostrar("\n!! == MUCHAS GRACIAS == !!\n");
					break;
				default:
					ventana.mostrar("\n!! == OPCION INVALIDA == !!\n");
					break;
				}
			}
	}
}
