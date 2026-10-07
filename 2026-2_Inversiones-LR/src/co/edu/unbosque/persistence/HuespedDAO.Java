package co.edu.unbosque.persistence;

import co.edu.unbosque.model.*;
import java.util.Collection;
import java.util.ArrayList;

public class HuespedDAO implements DAO<Huesped> {


    private Collection<Huesped> huespedes = new ArrayList<Huesped>();

    @Override
    public void crear(Huesped huesped)  {
        huespedes.add(huesped);
    }

     public Huesped buscarPorId(String id) throws ProgramException {
        for (Huesped h : huespedes) {
            if (h.getId().equals(id)) 
                
                return h;
        }
        throw new ProgramException("No existe un huesped con ese ID.");
    }

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