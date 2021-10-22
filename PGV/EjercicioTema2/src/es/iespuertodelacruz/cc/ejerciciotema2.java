/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc;

import es.iespuertodelacruz.cc.modelo.*;

/**
 *
 * @author Cedric Christoph
 */
public class ejerciciotema2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Buffer myBuffer = new Buffer(6);
        Productor producer = new Productor(myBuffer);
        Consumidor consumer = new Consumidor(myBuffer);
        
        producer.start();
        consumer.start();
    }
    
}
