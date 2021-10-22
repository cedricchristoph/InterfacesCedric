/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Cedric Christoph
 */
public abstract class Field {
    
    protected boolean bomb;
    
    public Field(boolean isBomb) {
        this.bomb = isBomb;
    }
    
    public boolean isBomb() {
        return bomb;
    }
    
}
