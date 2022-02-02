package es.iespuertodelacruz.cc.institutorestclient.model.repository;

import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.exception.ApiSyncException;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.LocalException;

public interface CRUDRepository<T, E> {

    public Optional<List<T>> selectAll();
    public Optional<T> selectById(E id);
    public void insert(T entity) throws LocalException, ApiSyncException;
    public void update(T entity) throws LocalException, ApiSyncException;
    public void deleteById(E id) throws LocalException, ApiSyncException;
    public void delete(T entity) throws LocalException, ApiSyncException;

}
