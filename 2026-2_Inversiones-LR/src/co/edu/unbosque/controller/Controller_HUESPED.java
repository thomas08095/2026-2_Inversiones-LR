package co.edu.unbosque.controller;
import co.edu.unbosque.model.*;
import co.edu.unbosque.persistence.HuespedDAO;

/**
 * Controlador Dedicado unicamente a los Huespedes.
 * <p>Este controlador se dedica al control de todo lo relacionado con los Huespedes,
 * su creacion, consultar sus detalles y mas.
 * <p>Todo el Cerebro de los Huespedes.
 */
public class Controller_HUESPED {
	
	private HuespedDAO huespedes = new HuespedDAO();
	
	/**
	 * Registra a un Huesped.
	 * <p>Segun los requerimientos del Usuario, se creara un Huesped si cumple con las reglas del programa.
	 * @param h Huesped a Crear.
	 * @throws ProgramException por si salen errores en la creacion.
	 */
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
	
	
	
	/**
	 * Consulta y muestra todos los Huespedes registrados en el Programa.
	 * @return retorna en String los Huespedes registrados.
	 * @throws ProgramException Por si no hay errores.
	 */
	public String consultarHuespedes() throws ProgramException {
		if (!hayHuespedes()) {
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
	
	/**
	 * Muestra a los Huespedes por su ID.
	 * @return retorna en String los Huespedes con su Nombre e ID.
	 */
	public String ID_MostrarHuespedes() {
		String txt = "||====== LISTA DE HUESPEDES ======||\n";
		for(Huesped h : huespedes.darLista()) {
				txt +=("\n| NOMBRE: " + h.getNombreCompleto()
				+ "              | ID: " + h.getId() + "\n-------------------------------------------------------\n");
		}
		return txt;
	}
	
	/**
	 * Busca a los Huespedes por su ID.
	 * @param id del Huesped a Buscar.
	 * @return el Huesped del ID correspondiente
	 * @throws ProgramException por si no existe el Huesped o no hay registrados.
	 */
	public Huesped ID_buscarHuesped(String id) throws ProgramException {
		return huespedes.buscarPorId(id);
	}
	
	/**
	 * Verifica que existan Huespedes en el Arreglo.
	 */
	public boolean hayHuespedes(){
		if(huespedes.darLista().isEmpty()) return false;
		else return true;
	}

}
