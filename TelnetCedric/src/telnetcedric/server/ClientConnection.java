/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetcedric.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import telnetcedric.server.command.CommandList;
import telnetcedric.server.exception.CommandNotFoundException;

/**
 *
 * @author Cedric Christoph
 */
public class ClientConnection extends Thread {
    
    // Variables
    Socket socket;
    InputStream input;
    OutputStream output;
    
    DataInputStream is;
    DataOutputStream os;
    
    public ClientConnection(Socket socket) throws IOException {
        this.socket = socket;
        input = socket.getInputStream();
        output = socket.getOutputStream();
        is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }
    
    /**
     * Comunica con un cliente, obliga al login antes de recibir y ejecutar los comandos del cliente
     */
    @Override
    public void run() {
        try {
             String username = null;
             String password = null;
            // Login
            while(true) {
                os.writeUTF("========= LOGIN PAGE =========\n" +
                            "Username: ");
                os.flush();
                username = is.readUTF();
                os.writeUTF("Password: ");
                os.flush();
                password = is.readUTF();
                // Validación de usuario
                if (username != null && password != null) {
                    break;
                }
            }
            // Mensaje de bienvenida
            String userInput = "";
            os.writeUTF("========= LOGGED  IN =========\n\n¡Bienvenido al servidor " + username + "!\n"
                    + "Si no conoces los comandos que admite el servidor introduce 'help' "
                    + "\npara conseguir una lista de posibles comandos.\n\n"
                    + "Para cerrar sesión en el servidor introduce 'exit'\n\n"
                    + "< Telnet prompt >\n");
            os.flush();
            Logger.getLogger(ClientConnection.class.getName()).log(Level.INFO, "Enviado mensaje de bienvenida a cliente " + socket.getInetAddress());
            // Iniciar bucle de recibir comando, ejecutar comando
            do {
                try {
                    Logger.getLogger(ClientConnection.class.getName()).log(Level.INFO, "Esperando entrada de comandos de cliente " + socket.getInetAddress());
                    userInput = is.readUTF();
                    Logger.getLogger(ClientConnection.class.getName()).log(Level.INFO, "Procediendo a ejecutar el comando recibido del cliente " + socket.getInetAddress());
                    os.writeUTF(commandExecutor(userInput));
                    os.flush();
                } catch (CommandNotFoundException ex) {
                    Logger.getLogger(ClientConnection.class.getName()).log(Level.WARNING, "[ SERVER ]: Usuario ha introducido un comando desconocido", ex);
                } catch (EOFException ex) {
            
                }
            } while (!userInput.equals("exit"));
            System.out.println("[ SERVER ]: Desconexión normal registrada");
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, "[ SERVER ]: Conexión con cliente interrumpida", ex);
        }
    }
    
    /**
     * Este método se encargará de que se ejecute el comando que el usuario ha introducido
     * @param command
     * @throws CommandNotFoundException 
     */
    public String commandExecutor(String command) throws CommandNotFoundException {
        CommandList list = new CommandList();
        return list.execute(command);
    }
}
