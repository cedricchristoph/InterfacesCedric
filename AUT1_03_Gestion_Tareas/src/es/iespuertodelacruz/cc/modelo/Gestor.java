/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

import java.util.ArrayList;

/**
 *
 * @author Cedric Christoph
 */
public class Gestor {
    
    ArrayList<Tarea> tareas;
    Integer idCounter = 0;
    
    public Gestor() {
        tareas = new ArrayList<>();
    }

    /**
     * Metodo para añadir una tarea al gestor
     * @param tarea 
     */
    public void add(Tarea tarea) {
        tarea.setID(idCounter);
        idCounter += 1;
        tareas.add(tarea);
    }
    
    /**
     * Metodo para eliminar una tarea de la lista
     * @param tarea Objeto tarea a borrar
     */
    public void remove(Tarea tarea) {
        tareas.remove(tarea);
    }
    
    /**
     * Metodo para eliminar una tarea de la lista
     * @param id Posicion en la lista a eliminar
     */
    public void remove(int id) {
        tareas.remove(tareas.stream().filter(tarea -> tarea.getID()==id).findFirst().get());
    }

    /**
     * Metodo para vaciar la lista del gestor
     */
    public void removeAll() {
        tareas.stream().forEach(t -> tareas.remove(t));
    }
    
    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
}
