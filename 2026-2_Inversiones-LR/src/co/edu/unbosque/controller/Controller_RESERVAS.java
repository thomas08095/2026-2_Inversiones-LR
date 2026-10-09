package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.Reserva.EstadoReserva;
import co.edu.unbosque.persistence.*;
/**
 * Controlador Dedicado unicamente a las Reservas.
 * <p>Este controlador se dedica al control de todo lo relacionado con las Reservas,
 * su creacion, cancelacion y mas.
 * <p>Todo el Cerebro de las Reservas.
 */
public class Controller_RESERVAS {
	
	static private ReservaDAO reservas = new ReservaDAO();
    
	/**
	 * Creador de Reservas.
	 * <p>Metodo definitivo para la creacion de las Reservas, pasa por varias verificaciones de 
	 * los datos impuestos por el usuario a ver si es posible crear la reserva o otras variables.
	 * <p>Guarda la reserva en su DAO respectivo.
	 * @param r La Reserva a Crear.
	 * @param h Huesped de la Reserva.
	 * @param a Alojamiento de la Reserva.
	 * @throws ProgramException Por si sale error en su creacion.
	 */
	public static void crearRESERVA(Reserva r,Huesped h, Alojamiento a) throws ProgramException {
		
		if (r.getId() == null || r.getId().isBlank()) {
            throw new ProgramException("El identificador de la reserva es obligatorio.");
        }
        for (Reserva rAUX : reservas.darLista()) {
            if (r.getId().equals(rAUX.getId())) {
            	throw new ProgramException("Ya existe una reserva con id: " + rAUX.getId());
            }
        }
        if (h == null) {
        	throw new ProgramException("La reserva debe estar asociada a un huesped registrado.");
        }
        if (a == null) {
        	throw new ProgramException("La reserva debe estar asociada a un alojamiento registrado.");
        }
        if(a.getEstado() == Alojamiento.EstadoAlojamiento.CANCELADO || a.getEstado() == Alojamiento.EstadoAlojamiento.OCUPADO){
        	throw new ProgramException("ALOJAMIENTO OCUPADO O CANCELADO");
        }
        
        r.setHuesped(h);
        r.setAlojamiento(a);
        r.validarCantidadHuespedes();
        
        int noches = r.calcularNumNoches();
        r.setNumeroDeNoches(noches);
        r.setValorTotal(a.calcularValorReserva(noches));
        r.setEstado(Reserva.EstadoReserva.CONFIRMADA);
        a.setEstado(Alojamiento.EstadoAlojamiento.OCUPADO);
        
		reservas.crear(r);
	}
	
	/**
	 * Consulta las Reservas creadas por el Usuario.
	 * @return retorna en String las Reservas.
	 * @throws ProgramException si no hay reservas, da error.
	 */
	public static String consultarReservas() throws ProgramException {
		if (!hayRESERVAS()) {
            throw new ProgramException("No hay reservas registradas en el sistema.");
		}
        
        String txt = "||====== LISTA DE RESERVAS ======||\n";
        
        for (Reserva r : reservas.darLista()) {
            txt += "\n| ID RESERVA: " + r.getId()
                 + "\n| ESTADO: " + r.getEstado()
                 + "\n| HUESPED: " + r.getHuesped().getNombreCompleto()
                 + "\n| ALOJAMIENTO: " + r.getAlojamiento().getNombre()
                 + "\n| FECHAS: " + r.getFechaLlegada() + " a " + r.getFechaSalida()
                 + "\n| TOTAL: $" + r.getValorTotal()
                 + "\n-------------------------------------------------------\n";
        }
        return txt;
    }
	/**
	 * Muestra las Reservas con sus IDS.
	 * @return retorna en String las Reserva con su ID y otros datos menores.
	 */
	public static String ID_MostrarReservas(){
		String txt = "||============ LISTA DE RESERVAS ============||";
		for(Reserva r : reservas.darLista()) {
			if(r.getEstado() == EstadoReserva.CONFIRMADA) {
			txt +=("\n| ID: " + r.getId() +
					"\n| HUESPED: " + r.getHuesped().getNombreCompleto() +
					"\n| ALOJAMIENTO: " + r.getAlojamiento().getNombre() +
					"\n----------------");
			}
		}
		txt+="\n||====================================================||";
		return txt;
	}
	
	
	/**
	 * Cancelacion de la Reserva dada por su ID.
	 * @param id ID de la Reserva a Cancelar.
	 * @throws ProgramException Por si no hay RESERVAS.
	 */
	public static void cancelarRESERVA(String id) throws ProgramException {
		 if (!hayRESERVAS()) {
	            throw new ProgramException("No hay reservas registradas en el sistema.");
	    }
		reservas.cancelar(id);
	}
	
	/**
	 * Verifica que hayan Reservas Existentes.
	 * @return true o false, dependiendo si hay o no reservas.
	 */
	public static boolean hayRESERVAS() {
		 if (reservas.darLista().isEmpty()) {
	            return false;
	    }
		 else return true;
	}

}
