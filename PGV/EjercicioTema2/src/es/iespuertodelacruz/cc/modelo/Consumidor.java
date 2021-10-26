/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cedric Christoph
 */
public class Consumidor extends Thread{
    
    /**
     * Variables de la clase Consumidor
     */
    private Buffer buffer;
    private ArrayList<Character> readChars;
    
    /**
     * Constructor de la clase Consumidor
     * @param buffurn output;
    }er 
     */
    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
        readChars = new ArrayList();
    }
    
    /**
     * Metodo para iniciar el hilo
     */
    @Override
    public void run() {
        while (readChars.size() < 15) {
            char c = buffer.read();
            readChars.add(c);
            System.out.println("Lei " + c);
        }
        System.out.println("Leido " + readChars.toString());
    }
    
    /**
     * Funcion que devuelve un integer random
     */
    private int getValue() {
        int min = 0;
        int max = buffer.getBufferMaximum();
        int output = (int) ((Math.random() * (max - min)) + min);
        if (output == 0)
            return 1;
        return output;
    }
    
}
