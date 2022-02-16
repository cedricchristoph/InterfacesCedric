/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetcedric.server.command;

import telnetcedric.server.exception.MissingParameterException;

/**
 * El Help command muestra la página de ayuda principal y las ayudas específica de un comando que se le indica al comando
 * @author Cedric Christoph
 */
public class HelpCommand extends Command {
    
    public HelpCommand() {
        super("help", "cmd");
    }
    
    @Override
    public String getHelpText() {
        String result = 
                "                --- HELP PAGE ---\n" +
                "  Esta es la página de ayuda del servidor telnet.\n" +
                "  A continuación verás una lista de posibles comandos\n" +
                "  que puedes ejecutar. Para recibir más detalles\n" +
                "  sobre un comando en concreto introduce lo siguiente:\n\n" +
                "  help command=elComandoQueQuieresVer\n\n" +
                "  Lista de comandos admitidos por el servidor:\n";
        
        for (Command cmd : new CommandList().getList()) {
            result += "  - " + cmd.getBaseCmd() + "\n";
        }
        result += "\n";
        return result;
    }
    
    @Override
    public String execute(String rawCommand) throws MissingParameterException  {
        parseParameters(rawCommand);
        if (getReceivedParameters().size() == 0) {
            return getHelpText();
        } else {
            CommandList list = new CommandList();
            String baseCmd = getReceivedParameters().get("command");
            for (Command cmd : list.getList()) {
                if (cmd.getBaseCmd().equals(baseCmd))
                    return cmd.getHelpText();
            }
        }
        return "Command not found";
    }
}
