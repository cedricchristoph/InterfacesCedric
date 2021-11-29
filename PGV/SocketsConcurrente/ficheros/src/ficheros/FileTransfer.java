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
import java.net.Socket;

/**
 *
 * @author cedric
 */
public class FileTransfer extends Thread {
    
    Socket cliente;
    
    public FileTransfer (Socket cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void run() {
        try {
            File fin;
            DataInputStream is = new DataInputStream(cliente.getInputStream());
            DataOutputStream os = new DataOutputStream(cliente.getOutputStream());
            String fname = is.readUTF();
            cliente.shutdownInput();
            fin = new File(fname);

            if (fin.canRead()) {
                FileInputStream fis = new FileInputStream(fin);
                byte buffer[] = new byte[1024];
                int len;
                os.writeLong(fin.length());
                System.out.printf("Enviando fichero '%s' de %d bytes\n", fname, fin.length());
                while ((len = fis.read(buffer)) > 0) {
                    os.write(buffer, 0, len);
                }
            } else {
                os.writeLong(-1);
            }
            cliente.shutdownOutput();
            cliente.close();
        } catch (Exception e) {

        }
        System.out.println("Cliente desconectado");
    }
    
}
