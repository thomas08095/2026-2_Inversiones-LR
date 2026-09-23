package co.edu.unbosque.controller;
import co.edu.unbosque.view.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.Alojamiento.Ciudad;
public class Controller {

		private static Menu menu = new Menu();
		private static VentanaEmergente ventana = new VentanaEmergente();
		private static Alojamiento a = new Casa();
		
		public static void start() {
			
			boolean end = false;
			int respuesta = 0;
			while(!end) {
				respuesta = ventana.LeerInt(Menu.menu_PRINCIPAL());
				
				switch(respuesta) {
				case 1:
					respuesta = ventana.LeerInt(Menu.menu_ALOJAMIENTOS());
					
					switch(respuesta) {
					case 1: 
						alojamientos_BUSCAR(respuesta);
						break;
					default:
						System.out.println("GAY");
						break;
					}
					
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
		
		public static void alojamientos_BUSCAR(int respuesta) {
				respuesta = ventana.LeerInt(menu.menu_ALOJAMIENTOS_CIUDADES());	
				respuesta = ventana.LeerInt(menu.menu_ALOJAMIENTOS_TIPOS());	
				respuesta = ventana.LeerInt("¿Capacidad Minima?");
				respuesta = ventana.LeerInt("¿Precio Maximo Por Noche?");
			}	
}
