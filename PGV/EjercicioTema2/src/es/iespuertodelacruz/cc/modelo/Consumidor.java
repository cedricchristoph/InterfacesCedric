/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

import java.util.ArrayList;

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
     * @param buffer 
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
            int rnd = getValue();
            System.out.println("Quiero leer " + rnd + " posiciones");
            for (Character c : buffer.read(rnd)) {
                readChars.add(c);
                System.out.println("He leido " + c);
            }
        }
        System.out.println(readChars.toString());
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
