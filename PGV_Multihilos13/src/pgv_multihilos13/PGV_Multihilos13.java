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

    private static int distancia = 1000;
    private static int curvas = 5;
    
    /**        System.out.println(llegadas.size() + " " + vehiculos.length);
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("========== BIENVENIDO A: RACE SIMULATOR ==========\n");
        System.out.println(" Autor: Cedric Christoph");
        System.out.println(" Version: 1.0");
        System.out.println("==================================================\n\n");
        new Menu().iniciar();
    }
    
}
