/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemafilosofos.entity;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cedric Christoph
 */
public class Mesa {
    
    /**
     * Variables de la mesa
     */
    Filosofo[] filosofos;
    Palillo[] palillos;
    
    /**
     * Constructor por defecto
     */
    public Mesa() {
        init();
    }
    
    /**
     * Metodo que instancia los filosofos y palillos
     */
    public void init() {
        filosofos = new Filosofo[5];
        palillos = new Palillo[5];
        for (int i = 0; i < filosofos.length; i++)
            filosofos[i] = new Filosofo(i+1, this);
        for (int i = 0; i < palillos.length; i++)
            palillos[i] = new Palillo(i+1);
    }
    
    /**
     * Metodo para comenzar la cena
     */
    public void iniciarCena() {
        for (Filosofo f : filosofos) {
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
            f.start();
        }
    }
    
    /**
     * Funcion que devuelve un palillo con un numero determinado
     * @param numero Numero del palillo a devolver
     * @return 
     */
    public synchronized Palillo getPalillo(int numero) {
        return palillos[numero-1];
    }
    
    /**
     * Funcion que devuelve un filosofo con un numero determinado
     * @param numero Numero del filosofo a devolver
     * @return 
     */
    public synchronized Filosofo getFilosofo(int numero) {
        return filosofos[numero-1];
    }
}
