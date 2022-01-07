/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.entity;

import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.AuthorizationsDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.AuthorizedSection;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author cedric
 */
public class Level {
    
    private Integer id;
    private String name;
    private ArrayList<Authorization> authorizations;
    
    /**
     * Constructor por defecto
     */
    public Level() {
    }

    /**
     * Constructor completo
     * @param id
     * @param name
     * @param authorizations 
     */
    public Level(Integer id, String name, ArrayList<Authorization> authorizations) {
        this.id = id;
        this.name = name;
        this.authorizations = authorizations;
    }

    /**
     * Metodo que crea una autorizacion para el level para poder acceder a cierta seccion indicada
     * @param section Seccion a la que se le autoriza el level
     */
    public void authorize(AuthorizedSection section) {
        AuthorizationsDAO dao = new AuthorizationsDAO();
        Authorization a = new Authorization();
        a.setLevel(this);
        a.setSection(section);
        dao.insert(a);
        reloadAuthorizations();
    }
    
    /**
     * Metodo que elimina una autorizacion del level para prohibir el acceso a la seccion indicada
     * @param section Seccion a la que se restringe el acceso para el level
     */
    public void forbid(AuthorizedSection section) {
        AuthorizationsDAO dao = new AuthorizationsDAO();
        Authorization a = null;
        for (Authorization auth : authorizations) {
            if (auth.getSection() == section)
                a = auth;
        }
        if (a == null) return;
        dao.delete(a);
        reloadAuthorizations();
    }
    
    /**
     * Recarga las autorizaciones
     */
    private void reloadAuthorizations() {
        AuthorizationsDAO dao = new AuthorizationsDAO();
        authorizations = (ArrayList<Authorization>) dao.selectLevelAuthorizations(this);
    }
    
    /* Getters and Setters */
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Authorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(ArrayList<Authorization> authorizations) {
        this.authorizations = authorizations;
    } 

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
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
        final Level other = (Level) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
