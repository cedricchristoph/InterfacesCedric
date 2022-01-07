/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.entity;

import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.AuthorizedSection;
import java.util.Objects;

/**
 * Class Authorization
 * @author cedric
 */
public class Authorization {
  
    private int id;
    private Level level;
    private AuthorizedSection section;

    public Authorization() {
    }

    public Authorization(int id, Level level, AuthorizedSection section) {
        this.id = id;
        this.level = level;
        this.section = section;
    }

    // Getters & Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public AuthorizedSection getSection() {
        return section;
    }

    public void setSection(AuthorizedSection section) {
        this.section = section;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.level);
        hash = 23 * hash + Objects.hashCode(this.section);
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
        final Authorization other = (Authorization) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.level, other.level)) {
            return false;
        }
        if (this.section != other.section) {
            return false;
        }
        return true;
    }

    
}
