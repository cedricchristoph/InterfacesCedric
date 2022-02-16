/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetcedric.server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cedric Christoph
 */
public class Server extends Thread {
    
    private int port;
    
    private ServerSocket socket;
    private int maxConnections;
    
    public Server(int port, int maxConnections) {
        this.port = port;
        this.maxConnections = maxConnections;
    }
    
    /**
     * Instancia un servidor telnet y reenvía las conexiones a objetos ClientConnection
     */
    @Override
    public void run() {
        System.out.println("[ SERVER ]: ONLINE");
        System.out.println("[ SERVER ]: Puerto: " + port + "  Max.: " + maxConnections);
        try {
            socket = new ServerSocket(port, maxConnections);
            while (!socket.isClosed()) {
                Socket client = socket.accept();
                System.out.println("[ SERVER ]: Nueva conexión registrada");
                new ClientConnection(client).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
