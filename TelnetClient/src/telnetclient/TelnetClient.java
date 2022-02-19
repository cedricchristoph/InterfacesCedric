package telnetclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Cedric Christoph
 */
public class TelnetClient {

    static Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Introduce IP y puerto al que quieres conctarte");
        System.out.println("IP:");
        String ip = scanner.nextLine();
        System.out.println("Puerto:");
        String puerto = scanner.nextLine();
        Integer port = null;
        try {
            port = Integer.parseInt(puerto);
        } catch (Exception e) {
            System.out.println("Puerto incorrecto!");
            System.exit(1);
        }
        
        try (Socket socket = new Socket(ip, port)) {
            DataInputStream entrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String text = "";
            do { 
                System.out.println(entrada.readUTF());
                text = scanner.nextLine();
                salida.writeUTF(text);
                salida.flush();
            } while (!text.equals("exit"));
            socket.close();
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
        
    }
    
}
