/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgv_multihilos13;

/**
 *
 * @author Cedric Christoph
 */
public class Coche extends Vehiculo {

    private final double agilidad = 1.1d;
    
    public Coche(String matricula, String marca, double potencia) {
        super(matricula, marca, potencia);
    }

    @Override
    protected void avanzar(Curva curva) {
        double distanciaInicial = distanciaRecorrida;
        while (distanciaRecorrida < (distanciaInicial + 100)) {
            if (!(velocidad < (velocidadMaxima/curva.getDificultad()*1.45))) {
                velocidad = (int) (velocidad/curva.getDificultad())*agilidad;
                recorrer();
            } else {
                acelerar();
            }
            printData();
            tick();
        }
    }
    
}
