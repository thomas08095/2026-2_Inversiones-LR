package co.edu.unbosque.controller;

import co.edu.unbosque.view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        String rutaAlojamientos = "data/alojamientos.txt";
        String rutaHuespedes = "data/huespedes.txt";
        String rutaReservas = "data/reservas.txt";

        AlojamientoController alojamientoController = new AlojamientoController(rutaAlojamientos);
        HuespedController huespedController = new HuespedController(rutaHuespedes);
        ReservaController reservaController = new ReservaController(rutaReservas, alojamientoController, huespedController);
        ReporteController reporteController = new ReporteController(alojamientoController, reservaController);

        // Carga inicial de archivos al iniciar la aplicacion.
        alojamientoController.cargarDatos();
        huespedController.cargarDatos();
        reservaController.cargarDatos();

        MenuPrincipal menu = new MenuPrincipal(alojamientoController, huespedController, reservaController, reporteController);
        menu.iniciar();
    }
}
