package es.iespuertodelacruz.cc.institutorestclient.model.networking.rest;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para CRUD Rest
 * @param <T> Objeto con el que se trabaja ej. Persona.java
 * @param <E> Idetnficador principal del objeto ej. Integer
 */
public interface CRUDRest<T, E> {

    public Optional<List<T>> selectAll();
    public Optional<T> selectById(E id);
    public boolean insert(T entity);
    public boolean update(T entity);
    public boolean deleteById(E id);

}
