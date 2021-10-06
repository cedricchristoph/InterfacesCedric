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
        double distanciaInicial = distanciaRecorrida;
        while (distanciaInicial < (distanciaInicial + 100)) {
            velocidad = (int) (velocidad/curva.getDificultad())*agilidad;
            distanciaRecorrida += velocidad;
            printVelocidad();
            tick();
        }
    }

    @Override
    protected void avanzar() {
        if (nextIsCurva()) {
            System.out.println("Cogiendo curva...");
            int siguientePosicion = (int) ((getDistanciaRecorrida() / 100)) + 1;
            avanzar(carrera.getRecorrido().getCurva(siguientePosicion));
        } else {
            if (velocidad < velocidadMaxima) {
                System.out.println("Acelerando...");
                acelerar();
                printVelocidad();
            } else {
                System.out.println("Manteniendo velocidad...");
                distanciaRecorrida += velocidad;
                printVelocidad();
            }
        }
    }
    
    private boolean nextIsCurva() {
        int siguientePosicion = (int) ((getDistanciaRecorrida() / 100)) + 1;
        return carrera.getRecorrido().getRuta()[siguientePosicion];
    }
}
