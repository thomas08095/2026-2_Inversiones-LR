package co.edu.unbosque.persistence;

import java.util.List;

import co.edu.unbosque.model.*;

/**
 * Interfaz genérica que define las operaciones básicas de persistencia
 * (crear, buscar, listar y eliminar) que debe implementar cada DAO del sistema.
 * 
 * @param <Objeto> Tipo de entidad que gestiona el DAO.
 */
public interface DAO<Objeto> {

    /**
     * Registra un nuevo objeto en la colección.
     * 
     * @param objeto Objeto a almacenar.
     */
    void crear(Objeto objeto);

    /**
     * Busca un objeto a partir de su identificador.
     * 
     * @param id Identificador del objeto buscado.
     * @return Objeto que coincide con el identificador.
     * @throws ProgramException Si no existe un objeto con ese identificador.
     */
    Objeto buscarPorId(String id) throws ProgramException;

    /**
     * Obtiene todos los objetos almacenados.
     * 
     * @return Lista con los objetos registrados.
     */
    List<Objeto> darLista();

    /**
     * Elimina un objeto a partir de su identificador.
     * 
     * @param id Identificador del objeto a eliminar.
     * @throws ProgramException Si no existe un objeto con ese identificador
     *                          o si la eliminación no está permitida.
     */
    void eliminar(String id) throws ProgramException;
}