/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cedric Christoph
 */
public class Buffer {
    
    /**
     * Variables de la clase Buffer
     */
    private char[] buffer;
    private int index;
    private boolean filled;
    private boolean empty;
    
    private boolean reading;
    private int readingLength;
    
    /**
     * Constructor de la clase Buffer
     * @param size Tamaño del buffer
     */
    public Buffer(Integer size) {
        buffer = new char[size];
        index = 0;
        filled = false;
        empty = true;
    }
    
    public synchronized void write (char c) {
        while(filled){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error write: " + ex.getMessage());
            }
        }
        empty = false;
        filled = index >= ((buffer.length)-1);
        if(!filled) {
            index++;
            buffer[index] = c;
        }
        notifyAll();
    }
 
    public synchronized char read () {
        while(empty){
            try {
                wait();
            } catch (InterruptedException ex) {
               
            }
        }
        empty = index <= 1;
        filled = false;
        char c = buffer[index];
        index--;
        notifyAll();
        return c;
    }
    
    
//    
//    /**
//     * Funcion que devuelve el valor que se ha introducido en el buffer
//     * @param size A leer
//     * @return Char
//     */
//    public synchronized char[] read(int size) {
//        char[] output = new char[size];
//        readingLength = size;
//        while (index < (size - 1)) {
//            try {
//                wait();
//            } catch (InterruptedException ex) {
//                
//            }
//        }
//        reading = true;
//        System.arraycopy(buffer, 0, output, 0, (size));
//        buffer = new char[buffer.length];
//        index = 0;
//        reading = false;
//        notifyAll();
//        return output;
//    }
//    
//    /**
//     * Metodo para escribir al buffer un character
//     * @param input Char
//     */
//    public synchronized void write(char input) {
//        while (reading || (index >= buffer.length)) {
//            try {
//                if ((readingLength-1) > index)
//                    break;
//                wait();
//            } catch (InterruptedException ex) {
//                
//            }
//        }
//        buffer[index] = input;
//        index++;
//        reading = true;
//        notifyAll();
//    }
//    
    /**
     * Funcion que devuelve el maximo del Buffer
     * @return 
     */
    public synchronized int getBufferMaximum() {
        return buffer.length;
    }
}
