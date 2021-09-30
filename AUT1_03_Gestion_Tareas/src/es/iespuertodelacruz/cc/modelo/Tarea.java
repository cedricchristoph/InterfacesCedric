/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

import java.util.Date;

/**
 *
 * @author Cedric Christoph
 */
public class Tarea {
    
    Integer id;
    Materia materia;
    String titulo;
    String descripcion;
    Date fechaEntrega;
    boolean hecha;
    
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

    /**
     * Constructor de la clase Tarea
     * @param id Id de la tarea
     * @param materia La materia de la que es la materia
     * @param titulo Titulo de la tarea
     * @param descripcion Una descripcion de la tarea
     * @param millis Fecha en milisegundos
     * @param hecha Si la tarea ha sido completada
     */
    public Tarea(Integer id, Materia materia, String titulo, String descripcion, long millis, boolean hecha) {
        this.id = id;
        this.materia = materia;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = new Date(millis);
        this.hecha = hecha;
    }
    
    /**
     * Constructor por defecto
     */
    public Tarea () {
        
    }

    // Getters & Setters
    public Integer getId() {
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

    public boolean estaHecha() {
        return hecha;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHecha(boolean hecha) {
        this.hecha = hecha;
    }
    
    /**
     * Funcion que devuelve los datos de la tarea como linea de texto separado por ;
     * @return String de datos
     */
    public String getTareaAsDataRow() {
        String datarow = getId() + ";" + materia.getNombre() + ";" + getTitulo() + ";" + getDescripcion() + ";" + fechaEntrega.getTime() + ";" + estaHecha() + "\n";
        return datarow;
    }
    
    
}
