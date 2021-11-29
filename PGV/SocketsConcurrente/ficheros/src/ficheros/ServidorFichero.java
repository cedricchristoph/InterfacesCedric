/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Cedric Christoph
 */
public class ServidorFichero {

    ServerSocket ss;

    /* */
    ServidorFichero(int port) throws IOException {
        ss = new ServerSocket(port);
    }

    /* */
    void acceptConnections() throws IOException {
        while (true) {
            new FileTransfer(ss.accept()).start();
            System.out.println("Un cliente está recibiendo datos");
        }
    }

    /* */
    public static void main(String[] args) throws IOException {
        new ServidorFichero(1500).acceptConnections();
    }

}
