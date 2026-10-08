package co.edu.unbosque.persistence;

import java.util.ArrayList;
import java.util.List;
import co.edu.unbosque.model.*;

/**
 * DAO encargado de gestionar en memoria la colección de reservas.
 * A diferencia de los demás DAO, las reservas no se eliminan: se cancelan.
 */
public class ReservaDAO implements DAO<Reserva> {

    /** Lista donde se almacenan las reservas registradas. */
    private List<Reserva> reservas = new ArrayList<Reserva>();

    /**
     * Registra una nueva reserva en la lista.
     * 
     * @param reserva Reserva a almacenar.
     */
    @Override
    public void crear(Reserva reserva){
        reservas.add(reserva);
    }

    /**
     * Busca una reserva por su identificador.
     * El ID de la reserva se convierte a texto para compararlo con el recibido.
     * 
     * @param id Identificador de la reserva buscada.
     * @return Reserva que coincide con el identificador.
     * @throws ProgramException Si no existe una reserva con ese ID.
     */
    @Override
    public Reserva buscarPorId(String id) throws ProgramException {
        for (Reserva r : reservas) {
            if (String.valueOf(r.getId()).equals(id)) 
                
                return r;
        }
        throw new ProgramException("No existe una reserva con ese ID.");
    }

    /**
     * Obtiene la lista completa de reservas registradas.
     * 
     * @return Lista de reservas.
     */
    @Override
	public List<Reserva> darLista() {
		return reservas;
	}

    /**
     * Operación no permitida para las reservas, ya que estas se cancelan
     * mediante el método {@link #cancelar(String)}.
     * 
     * @param id Identificador de la reserva.
     * @throws ProgramException Siempre, porque las reservas no se eliminan.
     */
	@Override
    public void eliminar(String id) throws ProgramException {
        throw new ProgramException("Las reservas no se eliminan, se cancelan.");
    }

    /**
     * Cancela una reserva y libera el alojamiento asociado.
     * Cambia el estado de la reserva a CANCELADA y, si tiene alojamiento,
     * lo deja nuevamente en estado ACTIVO.
     * 
     * @param id Identificador de la reserva a cancelar.
     * @throws ProgramException Si la reserva no existe o ya se encuentra cancelada.
     */
    public void cancelar(String id) throws ProgramException {
        Reserva r = buscarPorId(id);
        if (r.getEstado() == Reserva.EstadoReserva.CANCELADA) {
            throw new ProgramException("La reserva " + id + " ya se encuentra cancelada.");
        }
        
        r.setEstado(Reserva.EstadoReserva.CANCELADA);
        if (r.getAlojamiento() != null) {
            r.getAlojamiento().setEstado(Alojamiento.EstadoAlojamiento.ACTIVO);
        }
    }
}