/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetcedric.server.command;

import telnetcedric.server.exception.MissingParameterException;

/**
 * Intefaz para crear un comando
 * @author Cedric Christoph
 */
public interface ICommand {
 
    String execute(String rawCommand) throws MissingParameterException;
    String getHelpText();
}
