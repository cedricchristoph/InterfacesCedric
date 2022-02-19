/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetcedric.server.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import telnetcedric.server.exception.MissingParameterException;

/**
 * Clase abstracta para generar comandos
 * Esta clase incluye comportamientos por defecto como el parsear de los parámetros que pueden tener los comandos
 * @author Cedric Christoph
 */
public abstract class Command implements ICommand {
    
    String baseCmd;
    ArrayList<String> possibleParameters;
    HashMap<String, String> receivedParameters;
    
    public Command(String baseCmd, String... strParameters) {
        this.baseCmd = baseCmd;
        possibleParameters = new ArrayList<String>();
        receivedParameters = new HashMap<String, String>();
        Arrays.stream(strParameters).forEach(p -> possibleParameters.add(p));
    }
    
    protected void parseParameters(String strParameters) {
        try {
            strParameters = strParameters.replace(baseCmd, "");
            strParameters = strParameters.trim();
            String[] parametersRaw = strParameters.split(" ");
            for (String paramStr : parametersRaw) {
                String[] split = paramStr.split("=");
                String key = split[0];
                String value = split[1];
                receivedParameters.put(key, value);
            }
        } catch (Exception e) {
            
        }
    }
    
    @Override
    public String execute(String rawCommand) throws MissingParameterException {
        return "Command not implemented";
    }
    
    public String getHelpText() {
        return "No help text specified for this command";
    }

    public String getBaseCmd() {
        return baseCmd;
    }

    public void setBaseCmd(String baseCmd) {
        this.baseCmd = baseCmd;
    }

    public ArrayList<String> getPossibleParameters() {
        return possibleParameters;
    }

    public void setPossibleParameters(ArrayList<String> possibleParameters) {
        this.possibleParameters = possibleParameters;
    }

    public HashMap<String, String> getReceivedParameters() {
        return receivedParameters;
    }

    public void setReceivedParameters(HashMap<String, String> receivedParameters) {
        this.receivedParameters = receivedParameters;
    }
    
    
    
}
