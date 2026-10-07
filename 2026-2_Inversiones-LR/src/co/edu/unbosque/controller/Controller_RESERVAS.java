package co.edu.unbosque.controller;


import co.edu.unbosque.model.Alojamiento;
import co.edu.unbosque.model.Huesped;
import co.edu.unbosque.model.ProgramException;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.persistence.ReservaDAO;

public class Controller_RESERVAS {
	
	static protected ReservaDAO reservas = new ReservaDAO();
    
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
	
	public static void cancelarRESERVA(String id) throws ProgramException {
		reservas.cancelar(id);
	}

}