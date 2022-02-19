/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetcedric.server.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import telnetcedric.server.exception.CommandNotFoundException;
import telnetcedric.server.exception.MissingParameterException;
/**
 *
 * @author Cedric Christoph
 */
public class CommandList {
    
    private ArrayList<Command> list = new ArrayList<Command>();
    
    public CommandList() {
        list.add(new LsCommand());
        list.add(new CatCommand());
        list.add(new HelpCommand());
    }
    
    /**
     * Busca el comando que se debe ejecutar y lo ejecuta
     * @param rawcmd
     * @return Devuelve la salida del comando
     * @throws CommandNotFoundException Si no se encuentra el comando
     */
    public String execute(String rawcmd) throws CommandNotFoundException {
        String baseCmd = rawcmd.split(" ")[0];
        boolean executed = false;
        String result = "";
        for (Command cmd : list) {
            if (cmd.getBaseCmd().equals(baseCmd)) {
                try {
                    executed = true;
                    result = cmd.execute(rawcmd);
                } catch (MissingParameterException ex) {
                    Logger.getLogger(CommandList.class.getName()).log(Level.WARNING, ex.getMessage());
                    result = ex.getMessage();
                }
            }
        }
        if (!executed)
            return "Command not found";
        return result;
    }

    // Getters & Setters
    public ArrayList<Command> getList() {
        return list;
    }

    public void setList(ArrayList<Command> list) {
        this.list = list;
    }
    
    
}
