/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgv_tarea7cedric;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Cedric Christoph
 */
public class PGV_Tarea7Cedric {

    
    static Scanner scanner = new Scanner(System.in);
    
    static String user;
    static String password;
    
    public static void main(String[] args) {
        login();        
        menu();
    }
    
    public static void login() {
        while (true) {
            System.out.println("************  LOGIN  ************");
            System.out.print("  Usuario: ");
            user = scanner.nextLine();
            System.out.print("  Contraseña: ");
            password = scanner.nextLine();
            // Validación
             System.out.println("*********************************\n\n");
             break;
        }
    }
    
    public static void menu() {
        while(true) {
            System.out.println("(1) Cifrar un texto");
            System.out.println("(2) Decifrar un texto");
            System.out.println("(0) Salir\n");
            String input = scanner.nextLine();
            switch(input) {
                case "1":
                    encrypt();
                    break;
                case "2":
                    decrypt();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Orden no encontrada\n");
            }            
        }
    }
    
    public static void encrypt() {
        FileManager manager = new FileManager();
        String data = "";
        String line = "";
        while (!(line = scanner.nextLine()).equals("commit")) {
            data += line + "\n";
        }
        System.out.println("\n Introduce una ruta y/o nombre de fichero: ");
        String file = scanner.nextLine();
        String textoEncriptado = CryptoUtils.encrypt(data, user + password);
        if (textoEncriptado == null) {
            System.out.println("No se pudo encriptar el texto");
            System.exit(1);
        }
        if (manager.useFile(file)) {
            System.out.println("El fichero ya existe. ¿Quiere sobreescribirlo? (si/no)");
            if (scanner.nextLine().equals("si"))
                if (manager.write(textoEncriptado))
                    System.out.println("Texto encriptado y guardado en " + file + "\n");
                else
                    System.out.println("No se pudo guardar" + "\n");
            else
                if (manager.append(textoEncriptado))
                    System.out.println("Texto encriptado y guardado en " + file + "\n");
                else
                    System.out.println("No se pudo guardar" + "\n");
        } else {
            if (manager.write(textoEncriptado))
                System.out.println("Texto encriptado y guardado en " + file + "\n");            
        }
    }
    
    public static void decrypt() {
        System.out.println("Introduce una ruta al fichero:");
        String file = scanner.nextLine();
        FileManager manager = new FileManager();
        if (!manager.useFile(file)) {
            System.out.println("El fichero que has introducido no existe");
            return;
        }
        System.out.println("\n\n");
        ArrayList<String> lines = manager.readAllLines();
        try {
            String decrypted = CryptoUtils.decrypt(lines.get(0), user + password);
            System.out.println(decrypted + "\n\n");
        } catch (Exception e) {
            System.out.println("No se pudo decifrar. Probablemente su usuario y/o contraseña son erróneos");
        }
    }
    
}
