/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgv_tarea6cedric;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cedric Christoph
 */
public class PGV_Tarea6Cedric {

    static final Logger logger = Logger.getLogger(PGV_Tarea6Cedric.class.getName());
    Scanner scanner = new Scanner(System.in);
    String user;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PGV_Tarea6Cedric instance = new PGV_Tarea6Cedric();
        instance.login();
        instance.abrirFichero();
    }
    
    public void login() {
        boolean logged = false;
        while (!logged) {
            System.out.println("============== LOGIN ==============");
            System.out.print("Usuario: ");
            user = scanner.nextLine();
            System.out.println("Contraseña: ");
            String pwd = scanner.nextLine();
            // código de validación
            logged = true;
            System.out.println("Has iniciado sesión como " + user);
            System.out.println("===================================");
            logger.log(Level.INFO, "El usuario " + user + " ha iniciado sesión");
        }
    }
    
    public void abrirFichero() {
        System.out.println("Introduce ruta del fichero a abrir: ");
        String ruta = scanner.nextLine();
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(ruta))) {
            logger.log(Level.INFO, "Leyendo fichero " + ruta);
            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);
            logger.log(Level.INFO, "Lectura del fichero " + ruta + " completado");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        if (lines.isEmpty()) return;
        logger.log(Level.INFO, "Mostrando información del fichero al usuario");
        System.out.println("\nContenido del fichero:");
        lines.forEach(l -> System.out.println(l));
    }
    
}
