package co.edu.unbosque.persistence;

import java.util.ArrayList;
import java.util.List;
import co.edu.unbosque.model.*;

public class ReservaDAO implements DAO<Reserva> {

    private List<Reserva> reservas = new ArrayList<Reserva>();

    @Override
    public void crear(Reserva reserva) throws ProgramException {
        reservas.add(reserva);
    }

    @Override
    public Reserva buscarPorId(String id) throws ProgramException {
        for (Reserva r : reservas) {
            // String.valueOf funciona si el id de Reserva es int o String
            if (String.valueOf(r.getId()).equals(id)) return r;
        }
        throw new ProgramException("No existe una reserva con ese ID.");
    }
    @Override
    public void eliminar(String id) throws ProgramException {
        throw new ProgramException("Las reservas no se eliminan, se cancelan.");
    }
}