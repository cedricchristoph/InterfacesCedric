package es.iespuertodelacruz.cc.institutorestclient.model.repository;

import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.exception.ApiSyncException;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.LocalException;

/**
 *
 * @param <T> El objeto con el que se trabaja (Alumno, Persona, Asignatura)
 * @param <E> El tipo de dato del identificador primario de T
 */
public interface CRUDRepository<T, E> {

    public Optional<List<T>> selectAll();
    public Optional<T> selectById(E id);
    public void insert(T entity) throws LocalException, ApiSyncException;
    public void update(T entity) throws LocalException, ApiSyncException;
    public void deleteById(E id) throws LocalException, ApiSyncException;
    public void delete(T entity) throws LocalException, ApiSyncException;

}
