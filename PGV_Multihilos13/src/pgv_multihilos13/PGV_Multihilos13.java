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
public class PGV_Multihilos13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Recorrido r = new Recorrido(5000, 20);
        Vehiculo[] v = {
            new Moto("1123LEW", "Kawasaki", Vehiculo.VEHICULO_MUY_POTENTE)
        };
        Carrera carrera = new Carrera(r, v);
        carrera.start();
    }
    
}
