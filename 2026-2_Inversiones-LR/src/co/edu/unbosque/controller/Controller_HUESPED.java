package co.edu.unbosque.controller;
import java.util.ArrayList;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.view.*;
public class Controller_HUESPED {
	
	ArrayList<Huesped> huespedes = new ArrayList<Huesped>();
	VentanaEmergente v = new VentanaEmergente();
	
	public void registrarHuesped(Huesped h){
		
		if(h.getId().isBlank() || h.getId().isEmpty()) {
			v.mostrarERROR("Lo Sentimos.\nTu ID esta vacia.", "ERROR: ID INVALIDA");
			return;
		}
		if(h.getNombreCompleto().isBlank() || h.getNombreCompleto().isEmpty()) {
			v.mostrarERROR("Lo Sentimos.\nTu Nombre o Apellido esta vacio.", "ERROR: NOMBRE INVALIDO");
			return;
		}
		if(!h.validarCorreo(h.getCorreo()) || h.getCorreo().isBlank() || h.getCorreo().isEmpty()) {
			v.mostrarERROR("Lo Sentimos.\nEl Correo no es valido.", "ERROR: Correo Invalido");
			return;
		}
		if(!(h.getTelefono().length() == 10 || h.getTelefono().isBlank() || h.getTelefono().isEmpty())) {
			v.mostrarERROR("Lo Sentimos.\nEl Telofono no es valido. (Recuerda que son 10 Digitos.)", "ERROR: Telefono Invalido");
			return;
		}
		for(Huesped i : huespedes) {
			if(i.getId().equals(h.getId())) {
				v.mostrarERROR("EL ID YA EXISTE", "ERROR: ID ya existente");
				return;
			}
		}
		huespedes.add(h);
		v.mostrar("Se Resigistro Al Huesped con Exito.");
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
