/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

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
        tarea.setId(idCounter);
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
        tareas.remove(tareas.stream().filter(tarea -> tarea.getId()==id).findFirst().get());
    }

    /**
     * Metodo para vaciar la lista del gestor
     */
    public void removeAll() {
        tareas.stream().forEach(t -> tareas.remove(t));
    }
    
    public Tarea getTarea(Integer id) {
        return tareas.stream().filter(tarea -> Objects.equals(tarea.getId(), id)).findFirst().get();
    }
    
    /**
     * Funcion que devuelve un ArrayList de Tarea que su fecha de entrega es en el futuro
     * @return ArrayList Tarea
     */
    public ArrayList<Tarea> getTareas() {
        Date now = new Date(System.currentTimeMillis());
        return tareas.stream().filter(tarea -> now.before(tarea.getFechaEntrega())).collect(Collectors.toCollection(ArrayList::new));
    }
    
    /**
     * Funcion que devuelve un ArrayList de Tarea que su fecha de entrega es en el pasado
     * @return ArrayList Tarea
     */
    public ArrayList<Tarea> getHistorial() {
        Date now = new Date(System.currentTimeMillis());
        return tareas.stream().filter(tarea -> now.after(tarea.getFechaEntrega())).collect(Collectors.toCollection(ArrayList::new));
    }
}
