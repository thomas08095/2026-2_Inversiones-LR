package co.edu.unbosque.controller;
import java.util.ArrayList;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.view.*;
public class Controller_HUESPED {
	
	ArrayList<Huesped> huespedes = new ArrayList<Huesped>();
	VentanaEmergente v = new VentanaEmergente();
	
	public void registrarHuesped(Huesped h){
		for(Huesped i : huespedes) {
			if(i.getId() == h.getId()) {
				v.mostrarERROR("EL ID Y EXISTE", "ERROR: HENRY");
				return;
			}
		}
		huespedes.add(h);
	}
	
	public void consultarHuespedes() {
		if (huespedes.isEmpty()) {
	        v.mostrar("No hay huéspedes registrados actualmente.");
	        return;
	    }
		String txt = "||====== LISTA DE HUESPEDES ======||\n";
		for(Huesped i : huespedes) {
			txt += "\n| NOMBRE: " + i.getNombreCompleto()
			+ "\n| ID: " + i.getId() + "\n| CORREO: " + i.getCorreo() + "\n| TELEFONO: " + i.getTelefono()
			+ "\n-------------------------------------------------------\n";
		}
		v.mostrar(txt);
	}

}
