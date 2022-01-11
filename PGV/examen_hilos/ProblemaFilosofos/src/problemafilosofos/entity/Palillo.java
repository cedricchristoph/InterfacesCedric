/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemafilosofos.entity;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Cedric Christoph
 */
public class Palillo {
    
    /**
     * Variables del palillo
     */
    private int numero;
    private Filosofo usadoPor;
    private Semaphore semaforo;
    
    /**
     * Constructor de un palillo
     * @param id Identificador numerico
     */
    public Palillo(int id) {
        semaforo = new Semaphore(1);
        numero = id;
    }

    /**
     * Metodo para que un filósofo pueda cojer el palillo
     * @param filosofo Filosofo que quiere usar el palillo
     * @return Boolean si se ha cogido el palillo
     */
    public boolean cojer(Filosofo filosofo) {
        try {
            semaforo.acquire(1);
            usadoPor = filosofo;
            return true;
        } catch (InterruptedException ex) {
            return false;
        }
    }
    
    /**
     * Metodo para que el filósofo suelte el palillo
     */
    public void soltar() {
        usadoPor = null;
        semaforo.release(1);
    }
    
    // GETTERS & SETTERS 
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
