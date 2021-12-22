/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.entity;

/**
 *
 * @author cedric
 */
public class TipoReceta {
    
    private Integer id;
    private String tipo;
    private String imageURL;
    
    public TipoReceta() {
    }

    public TipoReceta(Integer id, String tipo, String imageURL) {
        this.id = id;
        this.tipo = tipo;
        this.imageURL = imageURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
    public String toString() {
        return getTipo();
    }
    
}
