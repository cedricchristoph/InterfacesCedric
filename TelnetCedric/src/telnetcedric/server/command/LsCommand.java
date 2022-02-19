/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetcedric.server.command;

import java.io.File;
import telnetcedric.server.exception.MissingParameterException;

/**
 * Ls command 
 * @author Cedric Christoph
 */
public class LsCommand extends Command {

    public LsCommand() {
        super("ls", "directory");
    }

    @Override
    public String getHelpText() {
        return  "           --- LS HELP PAGE ---\n" +
                "  El comando ls sirve para mostrar el contenido\n" +
                "  de un directorio entero. Se debe introducir\n" +
                "  'ls' seguido del parámetro 'directory' el cual\n" +
                "  incluirá la ruta al directorio que se quiere ver.\n\n" +
                "  > ls directory=/mi/directorio <\n\n";
    }
    
    @Override
    public String execute(String rawCommand) throws MissingParameterException {
        parseParameters(rawCommand);
        if (getReceivedParameters().size() == 0) {
            // No se especificó directorio
            throw new MissingParameterException("The parameter 'directory' has not been specified");
        } else {
            if (getReceivedParameters().get("directory") == null)
                throw new MissingParameterException("The parameter 'directory' has not been specified");
            else {
                return printDirContent(getReceivedParameters().get("directory"));
            }
        }
    }
    
    private String printDirContent(String dir) {
        File directory = new File(dir);
        File[] contents = directory.listFiles();
        String result = "";
        if (contents == null)
            return "Directory not found";
        for (File file : contents) {
            if (file.isFile())
                result += "[   FILE    ]  " + file.getName() + "\n";
            else
                result += "[ DIRECTORY ]  " + file.getName() + "\n";
        }
        return result;
    }
    
}
