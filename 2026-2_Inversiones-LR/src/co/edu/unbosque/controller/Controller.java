package co.edu.unbosque.controller;
import co.edu.unbosque.view.*;

public class Controller {
	

		private static Menu menu = new Menu();
		private static VentanaEmergente ventana = new VentanaEmergente();
	public static void start() {
		menu.start();
		ventana.LeerString("Bienvenido a HENRY CONDONES LR");

		
	}
	

}
