package co.edu.unbosque.controller;
import java.util.ArrayList;
import co.edu.unbosque.persistence.*;
import co.edu.unbosque.model.*;
/**
 * Controlador Dedicado unicamente a los Alojamientos.
 * <p>Este controlador se dedica al control de todo lo relacionado con los Alojamientos,
 * su creacion, consultarlo con filtros y sin estos y mucho mas.
 * <p>Todo el Cerebro de los Alojamientos.
 */
public class Controller_ALOJAMIENTOS {
	
	private AlojamientoDAO alojamientos = new AlojamientoDAO();
	
	/**
	 * Muestra todos los Alojamientos existentes.
	 */
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
	
	/**
	 * Consultar Alojamientos con Filtros.
	 * <p>Mediante los Filtros impuesto por el Usuario, se mostrara al Usuario los apartamentos que cumplan
	 * sus requerimientos al pie de la letra.
	 * Este solo muestra.
	 * @param alo Es donde entra la Lista ya filtrada.
	 * @return retorna en String los Apartamentos filtrados
	 */
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
	
	/**
	 * Consultar Alojamientos con Filtros.
	 * <p>Mediante los Filtros impuesto por el Usuario, se mostrara al Usuario los apartamentos que cumplan
	 * sus requerimientos al pie de la letra.
	 * Este solo muestra y los pasa por los filtros nuevamente.
	 * @param alo Es donde entra la Lista ya filtrada.
	 * @return retorna los Apartamentos filtrados.
	 */
	public ArrayList<Alojamiento> consultarF_RESERVAS(ArrayList<Alojamiento> alo) throws ProgramException  {
	    if (alo.isEmpty()) {
	        throw new ProgramException("No hay Alojamientos que Cumplan con los Requisitos.\n(o estan ocupados)\nDisculpe las molestias");
	    }
	    return alo;
	}
	
	/**
	 * Mediante los Filtros impuestos por el usuario, compara cada uno de los alojamientos existentes
	 * con el deseado por el usuario y se verifica si hay o no.
	 * @param aFILTRO El Alojamiento deseado por el Usuario
	 * @param capacidadMIN Capacidad Minima de Personas del Alojamiento
	 * @param precioMAX Precio Maximo del Valor del Alojamiento
	 * @return Metodo de ConsultarFiltros, para mostrar en String los Alojamientos seleccionados.
	 * @throws ProgramException si hay errores al ejecutarse
	 */
	public String buscarFiltro(Alojamiento aFILTRO, int capacidadMIN, int precioMAX) throws ProgramException{
		ArrayList<Alojamiento> resultados = new ArrayList<Alojamiento>();
		for (Alojamiento a : alojamientos.darLista()) {
			boolean encontrado = true;
				if(aFILTRO.getCiudadEnum() != a.getCiudadEnum() && aFILTRO.getCiudadEnum() != null) encontrado = false;
				if(a.getCapacidad() < capacidadMIN) encontrado = false;
				if(!aFILTRO.getTipo().equals(a.getTipo())) encontrado = false;
				if(a.getEstado() == Alojamiento.EstadoAlojamiento.CANCELADO || a.getEstado() == Alojamiento.EstadoAlojamiento.OCUPADO) encontrado = false;
				if(precioMAX > 0 && a.getPrecioBase() > precioMAX) encontrado = false;
				if(encontrado) resultados.add(a);
		}
		return consultarF(resultados);
	}
	/**
	 * Mediante los Filtros impuestos por el usuario, compara cada uno de los alojamientos existentes
	 * con el deseado por el usuario y se verifica si hay o no.
	 * @param aFILTRO El Alojamiento deseado por el Usuario
	 * @param capacidadMIN Capacidad Minima de Personas del Alojamiento
	 * @param precioMAX Precio Maximo del Valor del Alojamiento
	 * @return Metodo de ConsultarFiltros CON RESERVA, para mostrar en ArrayList los Alojamientos seleccionados.
	 * @throws ProgramException si hay errores al ejecutarse.
	 */
	public void buscarFiltroRESERVAS(Alojamiento aFILTRO, int capacidadMIN, int precioMAX) throws ProgramException{
		ArrayList<Alojamiento> resultados = new ArrayList<Alojamiento>();
		for (Alojamiento a : alojamientos.darLista()) {
			boolean encontrado = true;
				if(aFILTRO.getCiudadEnum() != a.getCiudadEnum() && aFILTRO.getCiudadEnum() != null) encontrado = false;
				if(a.getCapacidad() < capacidadMIN) encontrado = false;
				if(!aFILTRO.getTipo().equals(a.getTipo())) encontrado = false;
				if(a.getEstado() == Alojamiento.EstadoAlojamiento.CANCELADO || a.getEstado() == Alojamiento.EstadoAlojamiento.OCUPADO) encontrado = false;
				if(precioMAX > 0 && a.getPrecioBase() > precioMAX) encontrado = false;
				if(encontrado) resultados.add(a);
		}
		consultarF_RESERVAS(resultados);
	}
	
	/**
	 * Muestras las IDS de los Alojamentos.
	 * @return Alojamientos con su ID y Nombre (String)
	 * @throws ProgramException si hay errores al ejecutarse.
	 */
	public String ID_MostrarAlojamiento() throws ProgramException {
		if (alojamientos.darLista().isEmpty()) {
	        throw new ProgramException("No hay Alojamientos registrados actualmente.");
	    }
		String txt = "||====== LISTA DE ALOJAMIENTOS ======||\n";
		for(Alojamiento a : alojamientos.darLista()) {
				txt +=("\n| NOMBRE: " + a.getNombre()
				+ "              | ID: " + a.getId() + "\n-------------------------------------------------------\n");
		}
		return txt;
	}
	/**
	 * Reporte para los Alojamientos, los que hay de cada uno.
	 * @return Alojamientos con su cantidad de CASAS, APARTAMENTO y CABAÑA.
	 * @throws ProgramException si hay errores al ejecutarse.
	 */
	public String reporteAlojamientosPorTipo() throws ProgramException {
        if (alojamientos.darLista().isEmpty()) {
            throw new ProgramException("No hay alojamientos para generar el reporte por tipo.");
        }
        
        int casas = 0, apartamentos = 0, cabanas = 0;
        
        for (Alojamiento a : alojamientos.darLista()) {
            if (a.getTipo().equalsIgnoreCase("Casa")) {
                casas++;
            } else if (a.getTipo().equalsIgnoreCase("Apartamento")) {
                apartamentos++;
            } else if (a.getTipo().equalsIgnoreCase("Cabaña") || a.getTipo().equalsIgnoreCase("Cabana")) {
                cabanas++;
            }
        }
        
        String txt = "||====== CANTIDAD DE ALOJAMIENTOS POR TIPO ======||\n\n"
                   + "| Casas registradas: " + casas + "\n"
                   + "| Apartamentos registrados: " + apartamentos + "\n"
                   + "| Cabañas registradas: " + cabanas + "\n\n"
                   + "||===============================================||\n";
        
        return txt;
    }
	/**
	 * Busca un Alojamiento especifico por su ID.
	 * @param id ID que se desea buscar
	 * @return Alojamientos con su cantidad de CASAS, APARTAMENTO y CABAÑA.
	 * @throws ProgramException si hay errores al ejecutarse.
	 */
	public Alojamiento ID_buscarAlojamiento(String id) throws ProgramException {
		return alojamientos.buscarPorId(id);
	}
	/**
	 * Registra el Alojamiento en AlojamientoDAO, verifica las reglas que tiene que 
	 * seguir la implementacion del apartamento y de ahi se verifica si lo registra o no.
	 * @param a Alojamiento a Registrar.
	 * @throws ProgramException si hay errores al ejecutarse.
	 */
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
 