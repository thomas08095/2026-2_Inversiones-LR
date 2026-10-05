package co.edu.unbosque.persistence;

import co.edu.unbosque.model.*;

public class HuespedDAO implements DAO{

    ArrayList<Huesped> huespedes = new ArrayList<Huesped>();


    public void crear(Huesped huesped) throws ProgramException {
        huespedes.add(huesped);
    }
    


}