package co.edu.unbosque.persistence;

import co.edu.unbosque.model.*;
import java.util.List;
import java.util.ArrayList;

/**
 * DAO encargado de gestionar en memoria la colección de huéspedes.
 * Implementa las operaciones básicas definidas en la interfaz DAO.
 */
public class HuespedDAO implements DAO<Huesped> {

    /** Lista donde se almacenan los huéspedes registrados. */
    private List<Huesped> huespedes = new ArrayList<Huesped>();

    /**
     * Registra un nuevo huésped en la lista.
     * 
     * @param huesped Huésped a almacenar.
     */
    @Override
    public void crear(Huesped huesped)  {
        huespedes.add(huesped);
    }

    /**
     * Busca un huésped por su identificador.
     * 
     * @param id Identificador del huésped buscado.
     * @return Huésped que coincide con el identificador.
     * @throws ProgramException Si no existe un huésped con ese ID.
     */
     public Huesped buscarPorId(String id) throws ProgramException {
        for (Huesped h : huespedes) {
            if (h.getId().equals(id)) 
                
                return h;
        }
        throw new ProgramException("No existe un huesped con ese ID.");
    }

    /**
     * Obtiene la lista completa de huéspedes registrados.
     * 
     * @return Lista de huéspedes.
     */
	@Override
	public List<Huesped> darLista() {
		return huespedes;
	}

    /**
     * Elimina un huésped de la lista según su identificador.
     * 
     * @param id Identificador del huésped a eliminar.
     * @throws ProgramException Si no existe un huésped con ese ID.
     */
	public void eliminar(String id) throws ProgramException {
        for (int i = 0; i < huespedes.size(); i++) {
            if (huespedes.get(i).getId().equals(id)) {
                huespedes.remove(i);
                return;
            }
        }
        throw new ProgramException("No existe un huesped con ese ID.");
    }
}