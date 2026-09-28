package co.edu.unbosque.controller;
import java.util.ArrayList;
import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.view.*;
public class Controller_ALOJAMIENTOS {

	ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
	VentanaEmergente v = new VentanaEmergente();
	
	public void registrarHuesped(Alojamiento a){
		if (a.getId().isBlank() || a.getId().isEmpty() || a.getId() == null ) {
			v.mostrarERROR("Lo Sentimos.\n---", "ERROR: ---");
		}
		if(a.getNombre() == null || a.getNombre().isBlank()) {
			v.mostrarERROR("Lo Sentimos.\n---", "ERROR: ---");
		}
	}
}
