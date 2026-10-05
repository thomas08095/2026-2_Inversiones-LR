package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.view.VentanaEmergente;

public class Controller_RESERVAS {
	
	static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	static VentanaEmergente v = new VentanaEmergente();
    private static Controller_HUESPED con_H = new Controller_HUESPED();
    private static Controller_ALOJAMIENTOS con_A = new Controller_ALOJAMIENTOS();
    
	public static void crearRESERVA(Reserva r,Huesped h, Alojamiento a) {
		Reserva r_FINAL = new Reserva();
		double valorBASE = 0;
		double valorFINAL = 0;
		
		if (r.getId() == null || r.getId().isBlank()) {
            v.mostrarERROR("El identificador de la reserva es obligatorio.", "ERROR"); 
            return;
        }
        for (Reserva rAUX : reservas) {
            if (r.getId().equals(rAUX.getId())) {
            	v.mostrarERROR("Ya existe una reserva con id: " + rAUX.getId(), "ERROR");
            	 return;
            }
        }
        
        if(a.getEstado() == Alojamiento.EstadoAlojamiento.CANCELADO || a.getEstado() == Alojamiento.EstadoAlojamiento.OCUPADO){
        	v.mostrarERROR("ALOJAMIENTO OCUPADO O CANCELADO","ERROR");
        	return;
        }
        else if(r.getNumeroDeNoches() <= 0) {
        	v.mostrarERROR("NUMERO DE NOCHES INVALIDAS","ERROR");
        }
        else if(r.getNumeroHuespedes() <= 0) {
        	v.mostrarERROR("NUMERO DE HUESPEDES INVALIDAS","ERROR");
        }
        else if (r.getNumeroHuespedes() > a.getCapacidad()) {
        	v.mostrarERROR("El numero de huespedes supera la capacidad del alojamiento.","ERROR");
        }
        
		reservas.add(r);
	}
	
	public static void cancelarRESERVA(Reserva r) {
		
	}

}
