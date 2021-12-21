/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.entity;

import java.util.Objects;

/**
 *
 * @author cedric
 */
public class Receta {
    
    private Integer     id;
    private String      titulo;
    private User        autor;
    private TipoReceta  tipo;
    private String      ingredientes;
    private String      pasos;
    private Integer     comensales;
    private Integer     tiempoPreparacion;
    private Float       calorias;
    private String      imageURL;

    public Receta() {
    }

    public Receta(Integer id, String titulo, User autor, TipoReceta tipo, String ingredientes, String pasos, Integer comensales, Integer tiempoPreparacion, Float calorias, String imageURL) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.comensales = comensales;
        this.tiempoPreparacion = tiempoPreparacion;
        this.calorias = calorias;
        this.imageURL = imageURL;
    }

    
    // Getters and Setters 
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public TipoReceta getTipo() {
        return tipo;
    }

    public void setTipo(TipoReceta tipo) {
        this.tipo = tipo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public Integer getComensales() {
        return comensales;
    }

    public void setComensales(Integer comensales) {
        this.comensales = comensales;
    }

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Float getCalorias() {
        return calorias;
    }

    public void setCalorias(Float calorias) {
        this.calorias = calorias;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.titulo);
        hash = 23 * hash + Objects.hashCode(this.autor);
        hash = 23 * hash + Objects.hashCode(this.tipo);
        hash = 23 * hash + Objects.hashCode(this.ingredientes);
        hash = 23 * hash + Objects.hashCode(this.pasos);
        hash = 23 * hash + Objects.hashCode(this.comensales);
        hash = 23 * hash + Objects.hashCode(this.tiempoPreparacion);
        hash = 23 * hash + Objects.hashCode(this.calorias);
        hash = 23 * hash + Objects.hashCode(this.imageURL);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Receta other = (Receta) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.ingredientes, other.ingredientes)) {
            return false;
        }
        if (!Objects.equals(this.pasos, other.pasos)) {
            return false;
        }
        if (!Objects.equals(this.imageURL, other.imageURL)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.comensales, other.comensales)) {
            return false;
        }
        if (!Objects.equals(this.tiempoPreparacion, other.tiempoPreparacion)) {
            return false;
        }
        if (!Objects.equals(this.calorias, other.calorias)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
