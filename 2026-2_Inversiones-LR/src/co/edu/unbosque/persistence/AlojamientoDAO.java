package co.edu.unbosque.persistence;

import java.util.ArrayList;
import java.util.List;
import co.edu.unbosque.model.*;

public class AlojamientoDAO implements DAO<Alojamiento> {

    private List<Alojamiento> alojamientos = new ArrayList<Alojamiento>();

    @Override
    public void crear(Alojamiento alojamiento) throws ProgramException {
        alojamientos.add(alojamiento);
    }

    @Override
    public Alojamiento buscarPorId(String id) throws ProgramException {
        for (Alojamiento a : alojamientos) {
            if (a.getId().equals(id)) 
				return a;
        }
        throw new ProgramException("No existe un alojamiento con ese ID.");
    }

    @Override
    public void eliminar(String id) throws ProgramException {
        for (int i = 0; i < alojamientos.size(); i++) {
            if (alojamientos.get(i).getId().equals(id)) {
                alojamientos.remove(i);
                return;
            }
        }
        throw new ProgramException("No existe un alojamiento con ese ID.");
    }
}