/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.model.dao;

import java.util.List;

/**
 *
 * @author Cedric Christoph
 */
public interface CRUD<T, E> {
    
    public void insert(T entity);
    public void delete(T entity);
    public void update(T entity);
    public List<T> selectAll();
    public T selectById(E id);
    
}
