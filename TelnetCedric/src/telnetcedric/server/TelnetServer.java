package telnetcedric.server;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cedric Christoph
 */
public class TelnetServer {

    static Scanner scanner = new Scanner(System.in);
    static boolean arrancado = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Introduce puerto para servidor");
        int port = scanner.nextInt();
        System.out.println("Introduce max conexiones");
        int max = scanner.nextInt();
        
        Server server = new Server(port, max);
        
        System.out.println("\nIntroduce 'start' para arrancar el servidor, 'stop' para pararlo\n");
        
        String input = "";
        do {
            input = scanner.nextLine();
            if (input.equals("start") && !arrancado) {
                server.start();
                arrancado = true;
            } else if (input.equals("start") && arrancado) {
                System.out.println("El servidor ya esta arrancado");
            } else if (input.equals("stop")) {
                return;
            }
        } while (true);
    }
    
    
    
}
