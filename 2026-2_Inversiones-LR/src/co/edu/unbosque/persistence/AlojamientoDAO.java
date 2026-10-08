package co.edu.unbosque.persistence;

import java.util.ArrayList;
import java.util.List;
import co.edu.unbosque.model.*;

/**
 * DAO encargado de gestionar en memoria la colección de alojamientos.
 * Implementa las operaciones básicas definidas en la interfaz DAO.
 */
public class AlojamientoDAO implements DAO<Alojamiento> {

    /** Lista donde se almacenan los alojamientos registrados. */
    private List<Alojamiento> alojamientos = new ArrayList<Alojamiento>();

    /**
     * Registra un nuevo alojamiento en la lista.
     * 
     * @param alojamiento Alojamiento a almacenar.
     */
    @Override
    public void crear(Alojamiento alojamiento){
        alojamientos.add(alojamiento);
    }

    /**
     * Busca un alojamiento por su identificador.
     * 
     * @param id Identificador del alojamiento buscado.
     * @return Alojamiento que coincide con el identificador.
     * @throws ProgramException Si no existe un alojamiento con ese ID.
     */
    @Override
    public Alojamiento buscarPorId(String id) throws ProgramException {
        for (Alojamiento a : alojamientos) {
            if (a.getId().equals(id)) 
				return a;
        }
        throw new ProgramException("No existe un alojamiento con ese ID.");
    }

    /**
     * Obtiene la lista completa de alojamientos registrados.
     * 
     * @return Lista de alojamientos.
     */
    @Override
	public List<Alojamiento> darLista() {
		return alojamientos;
	}

    /**
     * Elimina un alojamiento de la lista según su identificador.
     * 
     * @param id Identificador del alojamiento a eliminar.
     * @throws ProgramException Si no existe un alojamiento con ese ID.
     */
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