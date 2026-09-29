package co.edu.unbosque.controller;
import java.util.ArrayList;
import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.view.*;
public class Controller_ALOJAMIENTOS {

	ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
	VentanaEmergente v = new VentanaEmergente();
	
	public void consultar() {
	    if (alojamientos.isEmpty()) {
	        v.mostrar("No hay Alojamientos registrados actualmente.");
	        return;
	    }
	    
	    String txt = "||=================================== LISTA DE ALOJAMIENTOS ===============================||\n";
	    
	    for(Alojamiento a : alojamientos) {
	        txt += "\n" +    "||| NOMBRE: " + a.getNombre()  + " |||"
	             + "\n| CIUDAD: " + a.getCiudadEnum() 
	             + "                      | DIRECCION: " + a.getDireccion() 
	             + "\n| PRECIO BASE: " + a.getPrecioBase() + " COP" 
	             + "                | CAPACIDAD: " + a.getCapacidad() 
	             + "                | TIPO: "  + a.getTipo() 
	             + "                | ESTADO: "  + a.getEstado()
	             + "\n\n-==========================================================================================-\n";
	    }
	    
	    v.mostrar(txt);
	}
	
	public ArrayList<Alojamiento> buscarFiltro(Alojamiento aFILTRO, int capacidadMIN, int precioMIN){
		ArrayList<Alojamiento> resultados = new ArrayList<Alojamiento>();
		for (Alojamiento a : alojamientos) {
			boolean encontrado = true;
				if(aFILTRO.getCiudadEnum() != a.getCiudadEnum()) encontrado = false;
				if(a.getCapacidad() < capacidadMIN) encontrado = false;
				if(!aFILTRO.getTipo().equals(a.getTipo())) encontrado = false;
				if(a.getEstado() == Alojamiento.EstadoAlojamiento.CANCELADO) encontrado = false;
				if(a.getPrecioBase() < precioMIN) encontrado = false;
				if(encontrado) resultados.add(a);
		}
		return resultados;
	}
	
	public void registrarAlojamiento(Alojamiento a){
		if (a.getId().isBlank() || a.getId().isEmpty() || a.getId() == null ) {
			v.mostrarERROR("Lo Sentimos.\n---", "ERROR: ---");
			return;
		}
		if(a.getNombre() == null || a.getNombre().isBlank()) {
			v.mostrarERROR("Lo Sentimos.\n---", "ERROR: ---");
			return;
		}
		for (Alojamiento al : alojamientos) {
            if (al.getId().equals(a.getId())) {
            	v.mostrarERROR("Lo Sentimos.\nEste ID ya EXISTE", "ERROR: ID YA EXISTENTE");
            	return;
            }
        }
		if (a.getCapacidad() <= 0) {
			v.mostrarERROR("Lo Sentimos.\nMODO VAGINA: ACTIVADO", "ERROR: CAPACIDAD INVALIDA");
        	return;

        }
        if (a.getPrecioBase() <= 0) {
        	v.mostrarERROR("Lo Sentimos.\nMODO VAGINA: ACTIVADO", "ERROR: PRECIO BASE INVALIDO");
        	return;
        }
        alojamientos.add(a);		
	}
}
