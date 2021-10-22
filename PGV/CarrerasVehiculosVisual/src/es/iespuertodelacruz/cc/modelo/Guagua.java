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
public class Guagua extends Vehiculo {
    
    private final double agilidad = 0.45d;

    public Guagua(String matricula, String marca, double potencia) {
        super(matricula, marca, potencia);
    }
    
    @Override
    protected void avanzar(Curva curva) {
        double distanciaInicial = distanciaRecorrida;
        while (distanciaRecorrida < (distanciaInicial + 100)) {
            if (!(velocidad < (velocidadMaxima/curva.getDificultad()*1.45))) {
                velocidad = (int) (velocidad/curva.getDificultad())*agilidad;
                estado = "Frenando en curva...";
                recorrer();
            } else {
                estado = "Acelerando en curva...";
                acelerar();
            }
            printData();
            tick();
        }
    }
    
    
}
