package co.edu.unbosque.persistence;

import co.edu.unbosque.model.*;

public interface DAO<Objeto> {
    void crear(Objeto objeto) throws ProgramException;
    Objeto buscarPorId(String id) throws ProgramException;
    void eliminar(String id) throws ProgramException;
}
