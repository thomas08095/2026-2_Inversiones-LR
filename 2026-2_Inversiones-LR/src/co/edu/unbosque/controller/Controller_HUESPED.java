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
				break;
			}
		}
		huespedes.add(h);
	}

}
