/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Cedric Christoph
 */
public class ClienteFichero {

    	public static void main(String[] args) throws UnknownHostException, IOException {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce fichero a descargar: ");
            String fileToGet = scanner.nextLine();
            System.out.println("Introduce fichero a guardar: ");
            File fileToSave = new File(scanner.nextLine());
            
            long size;
            int len;
            Socket server = new Socket(InetAddress.getLocalHost(), 1500);
            DataOutputStream os = new DataOutputStream(server.getOutputStream());
            DataInputStream is = new DataInputStream(server.getInputStream());
            os.writeUTF(fileToGet);
            if ((size = is.readLong()) >= 0) {
                FileOutputStream fos = new FileOutputStream(fileToSave);
                byte buffer[] = new byte[1024];
                while (((len = is.read(buffer)) >= 0) && (len > 0)) {
                    size -= len;
                    fos.write(buffer, 0, len);
                }
                fos.close();
                System.out.printf("Recibido '%s' of %d bytes\n", fileToSave.getName(), fileToSave.length());
            } else {
                System.err.printf("El fichero '%s' no está disponible en el servidor", fileToGet);
            }
            server.close();
	}
}
