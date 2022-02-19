/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetcedric.server.exception;

/**
 *
 * @author Cedric Christoph
 */
public class MissingParameterException extends Exception {
    public MissingParameterException(String ex) {
        super(ex);
    }
}
