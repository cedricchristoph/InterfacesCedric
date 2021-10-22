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
public class Productor extends Thread {
    
    /**
     * Variables de clase Productor
     */
    private final char[] abc;
    private final Buffer buffer;
    private ArrayList<Character> output;
    
    /**
     * Constructor de la clase Productor
     * @param buffer Objeto buffer a usar
     */
    public Productor(Buffer buffer) {
        this.buffer = buffer;
        abc = getAbc();
        output = new ArrayList();
    }

    /**
     * Metodo para iniciar el hilo
     */
    @Override
    public void run() {
        while (output.size() < 15) {
            char c = getRandomChar();
            output.add(c);
            buffer.write(c);
        }
        System.out.println(output.toString());
    }

    /**
     * Funcion que devuelve un caracter aleatorio del abecedario
     * @return Char
     */
    private char getRandomChar() {
        int randomPos = (int) ((Math.random() * (26 - 0)) + 0);
        return abc[randomPos];
    }
    
    /**
     * Funcion que devuelve un array que contiene el abecedario
     * @return Array de Char
     */
    private char[] getAbc() {
        char[] s = new char[26];
        for (int i = 0; i < 26; i++) {
            s[i] = (char) ('A' + i);
        }
        return s;
    }
}
