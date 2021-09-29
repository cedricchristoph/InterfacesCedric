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
    
    FileManager manager;
    ArrayList<Tarea> tareas;
    Integer idCounter = 0;
    
    /**
     * Constructor por defecto
     */
    public Gestor() {
        manager = new FileManager(this);
        tareas = new ArrayList<>();
    }
    
    public Gestor(boolean cargarDatos) {
        manager = new FileManager(this);
        if (cargarDatos)
            tareas = manager.cargarTareas();
        else
            tareas = new ArrayList<>();
    }

    /* Getters & Setters */
    public Integer getIdCounter() {
        return idCounter;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public void setIdCounter(Integer idCounter) {
        this.idCounter = idCounter;
    }        
    
    /**
     * Metodo para añadir una tarea al gestor
     * @param tarea 
     */
    public void add(Tarea tarea) {
        tarea.setId(idCounter);
        idCounter += 1;
        tareas.add(tarea);
        guardarTareas();
    }
    
    /**
     * Metodo para eliminar una tarea de la lista
     * @param tarea Objeto tarea a borrar
     */
    public void remove(Tarea tarea) {
        tareas.remove(tarea);
        guardarTareas();
    }
    
    /**
     * Metodo para eliminar una tarea de la lista
     * @param id Posicion en la lista a eliminar
     */
    public void remove(int id) {
        tareas.remove(tareas.stream().filter(tarea -> tarea.getId()==id).findFirst().get());
        guardarTareas();
    }

    /**
     * Metodo para vaciar la lista del gestor
     */
    public void removeAll() {
        tareas.stream().forEach(t -> tareas.remove(t));
        guardarTareas();
    }
    
    /**
     * Funcion que devuelve un objeto Tarea con el id indicado
     * @param id Id de la tarea a encontrar
     * @return Objeto tarea con id indicado
     */
    public Tarea getTarea(Integer id) {
        return tareas.stream().filter(tarea -> Objects.equals(tarea.getId(), id)).findFirst().get();
    }
    
    /**
     * Metodo para marcar una tarea como hecha
     * @param id Id de la tarea
     */
    public void marcarHecha(Integer id) {
        getTarea(id).setHecha(true);
        guardarTareas();
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
    
    /**
     * Metodo para guardar las tareas al fichero
     */
    private void guardarTareas() {
        manager.guardarTareas(tareas);
    }
}
