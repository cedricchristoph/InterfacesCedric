package es.iespuertodelacruz.cc.institutorestclient.model.database;

import android.database.Cursor;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Helpers that fulfill the role of CRUD
 * @author cedric
 * @param <T> Object(s) that will be returned (ex. Person.java)
 * @param <E> Identification type in database (ex. Integer)
 */
public interface CRUDHelper<T, E>{

    public List<T> selectAll();
    public Optional<T> selectById(E id);
    public boolean insert(T entity);
    public boolean update(T entity);
    public boolean deleteById(E id);
    public boolean delete(T entity);

    public T getSingleResult(Cursor cursor);
    public List<T> getResultList(Cursor cursor);

}
