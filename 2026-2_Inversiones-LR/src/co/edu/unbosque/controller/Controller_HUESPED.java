package co.edu.unbosque.controller;
import java.util.ArrayList;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;


public class Controller_HUESPED {
	
	ArrayList<Huesped> huespedes = new ArrayList<Huesped>();
	VentanaEmergente v = new VentanaEmergente();
	
	public void registrarHuesped(Huesped h) throws ProgramException {
        if(h.getId() == null || h.getId().isBlank() || h.getId().isEmpty()) {
            throw new ProgramException("Tu ID esta vacia.");
        }
        if(h.getNombreCompleto() == null || h.getNombreCompleto().isBlank() || h.getNombreCompleto().isEmpty()) {
            throw new ProgramException("Tu Nombre o Apellido esta vacio.");
        }
        if(!h.validarCorreo(h.getCorreo()) || h.getCorreo().isBlank() || h.getCorreo().isEmpty()) {
            throw new ProgramException("El Correo no es valido.");
        }
        if(h.getTelefono() == null || !(h.getTelefono().length() == 10 || h.getTelefono().isBlank() || h.getTelefono().isEmpty())) {
            throw new ProgramException("El Telefono no es valido. (Recuerda que son 10 Digitos.)");
        }
        for(Huesped i : huespedes) {
            if(i.getId().equals(h.getId())) {
                throw new ProgramException("EL ID YA EXISTE.");
            }
        }
        huespedes.add(h);
    }
	
	public String consultarHuespedes() throws ProgramException {
		if (huespedes.isEmpty()) {
	        throw new ProgramException("No hay huéspedes registrados actualmente.");
	    }
		String txt = "||====== LISTA DE HUESPEDES ======||\n";
		for(Huesped i : huespedes) {
			txt += "\n| NOMBRE: " + i.getNombreCompleto()
			+ "\n| ID: " + i.getId() + "\n| CORREO: " + i.getCorreo() + "\n| TELEFONO: " + i.getTelefono()
			+ "\n-------------------------------------------------------\n";
		}
		return txt;
	}

}
