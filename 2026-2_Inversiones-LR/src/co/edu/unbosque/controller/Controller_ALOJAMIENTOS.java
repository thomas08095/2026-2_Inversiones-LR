package co.edu.unbosque.controller;
import java.util.ArrayList;
import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.model.ProgramException;
import co.edu.unbosque.persistence.AlojamientoDAO;
import co.edu.unbosque.view.*;
public class Controller_ALOJAMIENTOS {
	
	protected AlojamientoDAO alojamientos = new AlojamientoDAO();
	
	public String consultar() throws ProgramException {
	    if (alojamientos.darLista().isEmpty()) {
	        throw new ProgramException("No hay Alojamientos registrados actualmente.");
	    }
	    
	    String txt = "||================================================================== LISTA DE ALOJAMIENTOS ==============================================================||\n";
	    
	    for(Alojamiento a : alojamientos.darLista()) {
	        txt += "\n" +    "||| ID: " + a.getId() + " ||| NOMBRE: " + a.getNombre()  + " |||"
	             + "\n| CIUDAD: " + a.getCiudadEnum() 
	             + "                      | DIRECCION: " + a.getDireccion() 
	             + "				      | PRECIO BASE: " + a.getPrecioBase() + " COP" 
	             + "                | CAPACIDAD: " + a.getCapacidad() 
	             + "                | TIPO: "  + a.getTipo() 
	             + "                | ESTADO: "  + a.getEstado()
	             + "\n\n-=============================================================================================================================================================-\n";
	    }
	    return txt;
	}
	
	public String consultarF(ArrayList<Alojamiento> alo) {
	    if (alo.isEmpty()) {
	        return "No hay Alojamientos que Cumplan con los Requisitos.\n(o estan ocupados)\nDisculpe las molestias";
	    }
	    
	    String txt = "||================================================================== LISTA DE ALOJAMIENTOS ==============================================================||\n";
	    
	    for(Alojamiento a : alo) {
	        txt += "\n" +    "||| ID: " + a.getId() + " ||| NOMBRE: " + a.getNombre()  + " |||"
	             + "\n| CIUDAD: " + a.getCiudadEnum() 
	             + "                      | DIRECCION: " + a.getDireccion() 
	             + "				      | PRECIO BASE: " + a.getPrecioBase() + " COP" 
	             + "                | CAPACIDAD: " + a.getCapacidad() 
	             + "                | TIPO: "  + a.getTipo() 
	             + "                | ESTADO: "  + a.getEstado()
	             + "\n\n-=============================================================================================================================================================-\n";
	    }
	    return txt;
	}
	
	public ArrayList<Alojamiento> consultarF_RESERVAS(ArrayList<Alojamiento> alo) throws ProgramException  {
	    if (alo.isEmpty()) {
	        throw new ProgramException("No hay Alojamientos que Cumplan con los Requisitos.\n(o estan ocupados)\nDisculpe las molestias");
	    }
	    return alo;
	}
	
	public String buscarFiltro(Alojamiento aFILTRO, int capacidadMIN, int precioMIN) throws ProgramException{
		ArrayList<Alojamiento> resultados = new ArrayList<Alojamiento>();
		for (Alojamiento a : alojamientos.darLista()) {
			boolean encontrado = true;
				if(aFILTRO.getCiudadEnum() != a.getCiudadEnum() && aFILTRO.getCiudadEnum() != null) encontrado = false;
				if(a.getCapacidad() < capacidadMIN) encontrado = false;
				if(!aFILTRO.getTipo().equals(a.getTipo())) encontrado = false;
				if(a.getEstado() == Alojamiento.EstadoAlojamiento.CANCELADO || a.getEstado() == Alojamiento.EstadoAlojamiento.OCUPADO) encontrado = false;
				if(precioMIN > 0 && a.getPrecioBase() < precioMIN) encontrado = false;
				if(encontrado) resultados.add(a);
		}
		return consultarF(resultados);
	}
	
	public void buscarFiltroRESERVAS(Alojamiento aFILTRO, int capacidadMIN, int precioMIN) throws ProgramException{
		ArrayList<Alojamiento> resultados = new ArrayList<Alojamiento>();
		for (Alojamiento a : alojamientos.darLista()) {
			boolean encontrado = true;
				if(aFILTRO.getCiudadEnum() != a.getCiudadEnum() && aFILTRO.getCiudadEnum() != null) encontrado = false;
				if(a.getCapacidad() < capacidadMIN) encontrado = false;
				if(!aFILTRO.getTipo().equals(a.getTipo())) encontrado = false;
				if(a.getEstado() == Alojamiento.EstadoAlojamiento.CANCELADO || a.getEstado() == Alojamiento.EstadoAlojamiento.OCUPADO) encontrado = false;
				if(precioMIN > 0 && a.getPrecioBase() < precioMIN) encontrado = false;
				if(encontrado) resultados.add(a);
		}
		consultarF_RESERVAS(resultados);
	}
	
	public String ID_MostrarAlojamiento() throws ProgramException {
		if (alojamientos.darLista().isEmpty()) {
	        throw new ProgramException("No hay huéspedes registrados actualmente.");
	    }
		String txt = "||====== LISTA DE ALOJAMIENTOS ======||\n";
		for(Alojamiento a : alojamientos.darLista()) {
				txt +=("\n| NOMBRE: " + a.getNombre()
				+ "              | ID: " + a.getId() + "\n-------------------------------------------------------\n");
		}
		return txt;
	}
	
	public Alojamiento ID_buscarAlojamiento(String id) throws ProgramException {
		return alojamientos.buscarPorId(id);
	}
	
	public void registrarAlojamiento(Alojamiento a) throws ProgramException {
        if (a.getId() == null || a.getId().isBlank() || a.getId().isEmpty()) {
            throw new ProgramException("El ID del alojamiento está vacío.");
        }
        if(a.getNombre() == null || a.getNombre().isBlank()) {
            throw new ProgramException("El nombre del alojamiento está vacío.");
        }
        for (Alojamiento al : alojamientos.darLista()) {
            if (al.getId().equals(a.getId())) {
                throw new ProgramException("Este ID ya EXISTE.");
            }
        }
        if (a.getCapacidad() <= 0) {
            throw new ProgramException("La capacidad debe ser mayor a cero.");
        }
        if (a.getPrecioBase() <= 0) {
            throw new ProgramException("El precio base debe ser mayor a cero.");
        }
        alojamientos.crear(a);
    }
	
}
 