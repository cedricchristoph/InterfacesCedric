/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemafilosofos.entity;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Cedric Christoph
 */
public class Filosofo extends Thread {

    /**
     * Variables del Filsofo
     */
    private int id;
    private Mesa mesa;
    private Palillo[] palillos;
    private boolean[] usando;

    /**
     * Constructor del filosofo
     * @param id
     * @param mesa 
     */
    public Filosofo(int id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
        palillos = new Palillo[2];
    }

    @Override
    public void run() {
        getPalillos();
        while (true) {
            cojerPalillos();
            if (usando[0] && usando[1]) {
                try {
                    // Tenemos los dos palillos. Comemos :P
                    int tiempo = getRandom();
                    System.out.println("Filósofo " + id + " tiene los palillos " + palillos[0].getNumero() + " y " + palillos[1].getNumero() + " y va comer durante " + tiempo + " segundos");
                    sleep(tiempo*1000);
                    soltarPalillos();
                    sleep(100);
                } catch (InterruptedException ex) {
                    
                }
            }            
        }
    }

    /**
     * Metodo para cojer los palillos
     */
    private void cojerPalillos() {
        usando = new boolean[2];
        for (int i = 0; i < 2; i++) {
            usando[i] = palillos[i].cojer(this);
            System.out.println("El filósofo " + id + " cogió el palillo " + palillos[i].getNumero());
        }
    }

    /**
     * Metodo para soltar los palillos
     */
    private void soltarPalillos() {
        for (Palillo p : palillos) {
            p.soltar();
        }
        usando = new boolean[2];
        System.out.println("El filósofo " + id + " soltó ambos palillos");
    }

    /**
     * Metodo para recoger los palillos que debe usar el filosofo
     */
    private void getPalillos() {
        getPalilloIzquierdo();
        getPalilloDerecho();
    }
    
    /**
     * Recoge el palillo que debe ser usado por el lado izquierdo del filosofo
     */
    private void getPalilloIzquierdo() {
        // El palillo a la izquierda tiene el mismo id que el propio filósofo
        palillos[0] = mesa.getPalillo(id);
    }

    /**
     * Recoge el palillo que debe ser usado por el lado dercho del filosofo
     */
    private void getPalilloDerecho() {
        // El palillo a la derecha es el id del filósofo menos 1 (en caso de uno salta a 5)
        int palilloId = id - 1;
        if (palilloId < 1) {
            palilloId = 5;
        }
        palillos[1] = mesa.getPalillo(palilloId);
    }
    
    /**
     * Devuelve un numero random
     * @return 
     */
    private int getRandom() {
        return (int) (Math.random() * ( 6 - 3 ));
    }

}
