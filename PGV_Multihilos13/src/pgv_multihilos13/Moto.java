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
public class Moto extends Vehiculo {
    
    private double agilidad = 1.40d;
    
    public Moto(String matricula, String marca, double potencia) {
        super(matricula, marca, potencia);
    }
    
    @Override
    public void run() {
        while (distanciaRecorrida < carrera.getRecorrido().getDistanciaTotal()) {
            avanzar();
            tick();
        }
    }

    @Override
    protected void avanzar(Curva curva) {
        //System.out.println("La curva es de dificultad " + curva.getDificultad());
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

    @Override
    protected void avanzar() {
        if (distanciaRecorrida < carrera.getRecorrido().getDistanciaTotal()) {
            if (nextIsCurva()) {
                //System.out.println("Cogiendo curva...");
                int siguientePosicion = (int) ((getDistanciaRecorrida() / 100)) + 1;
                avanzar(carrera.getRecorrido().getCurva(siguientePosicion));
            } else {
                if (velocidad < velocidadMaxima) {
                    //System.out.println("Acelerando...");
                    acelerar();
                    printData();
                } else {
                    //System.out.println("Manteniendo velocidad...");
                    recorrer();
                    printData();
                }
            }
        } else {
            
        }
    }
    
    
}
