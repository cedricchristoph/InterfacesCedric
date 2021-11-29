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
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**No se pudo crear la 
 *
 * @author dama
 */
public class Client {
 
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Conectando con servidor de juego...");
        Socket sCliente = null;
        try {
            sCliente = new Socket("localhost", 2000);
            System.out.println("✔️Conectado con servidor ✔️\n");
            System.out.println("El numero secreto se encuentra entre el 0 y 100. ¡Mucha suerte!\n");
            DataInputStream entrada = new DataInputStream(new BufferedInputStream(sCliente.getInputStream()));
            DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(sCliente.getOutputStream()));
            do {
                Integer num = null;
                do {
                    try {
                        System.out.print("\nIntroduce un número:\n");
                        num = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.print("\n¡Has introducido un valor no numérico!\n");
                    }
                } while (num == null);
 
                salida.writeInt(num);
                salida.flush();
               
                boolean adivinado = entrada.readBoolean();
                System.out.println(entrada.readUTF());
                //if (adivinado)
                //    break;
            } while (true);
            //sCliente.close();
        } catch (UnknownHostException e) {
            System.err.println("\n✘ No se pudo conectar al servidor ✘");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("\n ✘ ERROR: " + e.getMessage() + " ✘");
            System.exit(1);
        }
    }
    
}