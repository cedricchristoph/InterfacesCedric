/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertocruz.cc.componentes;

/**
 *
 * @author dama
 */
public enum TipoEvento {
    BANQUETE, JORNADA, CONGRESO;
    
    /**
     * Funcion para devolver el ENUM dependiendo de la entrada por STRING
     * @param input
     * @return
     */
    public static TipoEvento getTipo(String input) {
        switch(input) {
            case "Banquete":
                return BANQUETE;
            case "Jornada":
                return JORNADA;
            case "Congreso":
                return CONGRESO;
        }
        return null;
    }
}
