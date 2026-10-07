package co.edu.unbosque.controller;
import co.edu.unbosque.model.*;
import co.edu.unbosque.persistence.HuespedDAO;


public class Controller_HUESPED {
	
	protected HuespedDAO huespedes = new HuespedDAO();
	
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
        if(h.getTelefono() == null || !h.getTelefono().matches("\\d{10}")) {
            throw new ProgramException("El Telefono no es valido. (Recuerda que son 10 Digitos.)");
        }
        for(Huesped i : huespedes.darLista()) {
            if(i.getId().equals(h.getId())) {
                throw new ProgramException("EL ID YA EXISTE.");
            }
        }
        huespedes.crear(h);
    }
	
	
	
	public String consultarHuespedes() throws ProgramException {
		if (huespedes.darLista().isEmpty()) {
	        throw new ProgramException("No hay huéspedes registrados actualmente.");
	    }
		String txt = "||====== LISTA DE HUESPEDES ======||\n";
		for(Huesped i : huespedes.darLista()) {
			txt += "\n| NOMBRE: " + i.getNombreCompleto()
			+ "\n| ID: " + i.getId() + "\n| CORREO: " + i.getCorreo() + "\n| TELEFONO: " + i.getTelefono()
			+ "\n-------------------------------------------------------\n";
		}
		return txt;
	}
	
	public String ID_MostrarHuespedes() throws ProgramException {
		if (huespedes.darLista().isEmpty()) {
	        throw new ProgramException("No hay huéspedes registrados actualmente.");
	    }
		String txt = "||====== LISTA DE HUESPEDES ======||\n";
		for(Huesped h : huespedes.darLista()) {
				txt +=("\n| NOMBRE: " + h.getNombreCompleto()
				+ "              | ID: " + h.getId() + "\n-------------------------------------------------------\n");
		}
		return txt;
	}
	
	public Huesped ID_buscarHuesped(String id) throws ProgramException {
		return huespedes.buscarPorId(id);
	}

}
