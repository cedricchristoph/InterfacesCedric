/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import java.util.List;

/**
 * CRUD Interface
 * @author cedric
 * @param <T> object to handle ex. Person
 * @param <E> object identifier ex. Integer
 */
public interface CRUD<T, E> {
    
    boolean insert(T entity);
    boolean delete(T entity);
    boolean update(T entity);
    List<T> selectAll();
    T selectById(E id);
    
}
