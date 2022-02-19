/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetcedric.server.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import telnetcedric.server.exception.MissingParameterException;

/**
 * Comando cat sirve para ver el contenido de un fichero indicado
 * @author Cedric Christoph
 */
public class CatCommand extends Command {
    
    public CatCommand() {
        super("cat", "path");
    }
    
    @Override
    public String getHelpText() {
        return  "           --- CAT HELP PAGE ---\n" +
                "  El comando cat se usa para ver el contenido de un\n" +
                "  fichero. Para ello introduciremos 'cat' seguido del\n" +
                "  parámetro 'path' que incluirá la ruta al fichero.\n\n" +
                "  > cat path=/mi/directorio/fichero.txt <\n\n";
    }
    
    @Override
    public String execute(String rawCommand) throws MissingParameterException  {
        
        parseParameters(rawCommand);
        if (getReceivedParameters().size() == 0) {
            // No se especificó directorio
            throw new MissingParameterException("The parameter 'path' has not been specified");
        } else {
            if (getReceivedParameters().get("path") == null)
                throw new MissingParameterException("The parameter 'path' has not been specified");
            else {
                return printFileContent(getReceivedParameters().get("path"));
            }
        }
        
    }
    
    private String printFileContent(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }
            return result;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CatCommand.class.getName()).log(Level.WARNING, null, ex);
            return "File not found";
        } catch (IOException ex) {
            Logger.getLogger(CatCommand.class.getName()).log(Level.WARNING, null, ex);
            return "File reading error ocurred";
        }
    }
}
