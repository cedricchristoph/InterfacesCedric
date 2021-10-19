/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

/**
 *
 * @author Cedric Christoph
 */
public class Curva {

    public static final double DIFICULTAD_BAJA = 1.5d;
    public static final double DIFICULTAD_MEDIA = 2.5d;
    public static final double DIFICULTAD_ALTA = 3d;    
    
    private double dificultad;
    
    public Curva(double dificultad) {
        this.dificultad = dificultad;
    }
    
    public double getDificultad() {
       return dificultad;
    }
    
    
    
}
