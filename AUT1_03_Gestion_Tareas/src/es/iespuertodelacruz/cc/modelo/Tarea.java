/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

import java.util.Date;

/**
 *
 * @author dama
 */
public class Tarea {
    
    Integer id;
    Materia materia;
    String titulo;
    String descripcion;
    Date fechaEntrega;

    /**
     * Constructor de la clase Tarea
     * @param materia La materia de la que es la materia
     * @param titulo Titulo de la tarea
     * @param descripcion Una descripcion de la tarea
     * @param fechaEntrega Fecha de entrega de la tarea
     */
    public Tarea(Materia materia, String titulo, String descripcion, Date fechaEntrega) {
        this.materia = materia;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
    }
    
    public Tarea () {
        
    }

    // Getters & Setters
    public Integer getID() {
        return id;
    }
    
    public Materia getMateria() {
        return materia;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setID(Integer id) {
        this.id = id;
    }
    
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    
    
}
