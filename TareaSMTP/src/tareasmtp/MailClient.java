/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasmtp;

import java.util.Arrays;
import java.util.Scanner;
import tareasmtp.model.entity.Mail;
import tareasmtp.model.entity.MailSender;

/**
 * Clase principal que interactua con el usuario
 * @author Cedric Christoph
 */
public class MailClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new MailClient().run();
    }
    
    
    private Scanner scanner;
    
    public MailClient() {
        scanner = new Scanner(System.in);
        
    }
    
    /**
     * Metodo para arrancar el funcionamiento del programa
     */
    public void run() {
        while (true) {
            printMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    escribirEmail();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
    
    /**
     * Imprime el menú
     */
    public void printMenu() {
        System.out.println("============= MAIL CLIENT =============");
        System.out.println(" (1) -- Escribir un email");
        System.out.println(" (0) -- Salir");
        System.out.print(" : ");
    }
    
    /**
     * Metodo para iniciar una creación de un email
     */
    public void escribirEmail() {
        // Pedimos email de origen, destinatarios y concepto
        System.out.println("Introduce tu email:");
        String sender = scanner.nextLine();
        System.out.println("Introducir destinatario(s) separado por coma: ");
        String destinatario = scanner.nextLine();
        System.out.println("Introducir concepto: ");
        String concepto = scanner.nextLine();
        System.out.println("Introducir cuerpo (finalizar con /commit): ");
        
        // Pedimos que introduzco el cuerpo del email
        String message = "";
        String line;
        while (!(line = scanner.nextLine()).equals("/commit")) {
            message += line + "\n";
        }
        
        // Creamos el objeto Mail y asignamos los datos proporcionado anteriormente
        String[] recipients = destinatario.split(",");
        Mail mail = new Mail();
        mail.setSender(sender);
        Arrays.stream(recipients).forEach(r -> mail.addRecipient(r.trim()));
        mail.setSubject(concepto);
        mail.setBody(message);
        
        // Preguntamos si queremos ver el borrador
        System.out.println("\n Borrador de email creado. ¿Quieres ver el email final antes de enviar? (si/no)");
        String mostrar = scanner.nextLine().toLowerCase();
        if (mostrar.equals("si")) {
            System.out.println("\n" + mail.toString() + "\n");
        } 
        
        // Preguntamos si queremos enviar el email y lo hacemos en caso afirmativo
        System.out.println("¿Enviar email ahora? (si/no)");
        String enviarAhora = scanner.nextLine().toLowerCase();
        if (enviarAhora.equals("no")) return;
        if (new MailSender().send(mail) == true) {
            System.out.println("\n✔ E-Mail enviado correctamente\n");
        } else {
            
            System.out.println("\n✘ E-Mail no se pudo enviar\n");
        }
    }
    
}
