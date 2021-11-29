/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinarnumerocedric;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 *
 * @author dama
 */
public class Player extends Thread {
 
    static Integer secret;
    static ServerSocket socket;
    static Integer port = 2000;
    static boolean acertado = false;
    
    Socket cliente;
    
    public Player(Socket cliente) {
        this.cliente = cliente;
    }
    
    public static void main(String[] args) throws IOException {

        try {
            reloadSecret();
            socket = new ServerSocket(port);
            System.out.println("¡Servidor arrancado!");
            
            while (true) {
                new Player(socket.accept()).start();
            }
            
        } catch (Exception e) {
            
        }


    }
    
    private static void reloadSecret() {
        secret = getRandomNum();
        System.out.println("El nuevo numero secreto es " + secret);
    }

    @Override
    public void run() {
        try {
            DataInputStream is = new DataInputStream(new BufferedInputStream(cliente.getInputStream()));
            DataOutputStream os = new DataOutputStream(new BufferedOutputStream(cliente.getOutputStream()));
            System.out.println("Nuevo jugador conectado");
            while (true) {
                boolean averiguado = false;
                Integer tmpSecret = secret;
                while (!averiguado) {
                    int clientNum = is.readInt();

                    if (tmpSecret != secret) {
                        os.writeBoolean(false);
                        os.writeUTF("El número secreto ha sido averiguado por otro jugador :(\nSe ha generado un nuevo número secreto. Intenta averiguarlo ahora:\n");
                        os.flush();
                        break;
                    }

                    if (clientNum > secret) {
                        os.writeBoolean(false);
                        os.writeUTF("SECRETO < " + clientNum);
                    } else if (clientNum < secret) {
                        os.writeBoolean(false);
                        os.writeUTF("SECRETO > " + clientNum);
                    } else {
                        os.writeBoolean(true);
                        os.writeUTF("¡Enhorabuena! Has acertado el numero secreto");
                        averiguado = true;
                        reloadSecret();
                    }
                    os.flush();
                }
                System.out.println("Cliente averiguó el número secreto");
            }
        } catch (IOException e) {
            System.out.println("Error de conexión");
        }
    }
    
    private static int getRandomNum() {
        int random =(int) (Math.random() * 100 + 0);
        return random;
    }
}
