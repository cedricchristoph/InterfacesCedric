/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgv_multihilos13;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Cedric Christoph
 */
public class Menu {
    
    public Menu() {
        
    }
    
    public void iniciar() {
        showOptions("main");
        switch (validar()) {
            case 1:
                crearCarrera();
                break;
            default:
                System.exit(0);
        }
    }
    
    private void showOptions(String menu) {
        System.out.println("             MENU");
        switch(menu) {
            case "main":
                System.out.println(" (1) -- Crear una nueva carrera");
                System.out.println(" (0) -- Salir");
                break;
            case "racecreator":
                System.out.println(" (1) -- Añadir moto");
                System.out.println(" (2) -- Añadir coche");
                System.out.println(" (3) -- Añadir guagua");
                System.out.println(" (4) -- Editar preferencias de carrera");
                System.out.println(" (5) -- Iniciar carrera");
                System.out.println(" (0) -- Voler");
                break;
        }
    }
    
    private Carrera crearCarrera() {
        int distancia;
        int curvas;
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Carrera carrera = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Nueva carrera:");
        try {
            System.out.println("Introduce la distancia en metros a recorrer:");
            distancia = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduce cantidad de curvas:");
            curvas = Integer.parseInt(scanner.nextLine());
            System.out.println("✔ Ruta establecida\n");
        } catch (Exception e) {
            return null;
        }
        while (true) {
            showOptions("racecreator");
            switch (validar()) {
                case 1:
                    vehiculos.add(crearVehiculo("moto"));
                    break;
                case 2:
                    vehiculos.add(crearVehiculo("coche"));
                    break;
                case 3:
                    vehiculos.add(crearVehiculo("guagua"));
                    break;
                case 4:
                    System.out.println("Introduce la distancia en metros a recorrer:");
                    distancia = Integer.parseInt(scanner.nextLine());
                    System.out.println("Introduce cantidad de curvas:");
                    curvas = Integer.parseInt(scanner.nextLine());
                    System.out.println("✔ Ruta establecida\n");
                    break;
                case 5:
                    Recorrido recorrido = new Recorrido(distancia, curvas);
                    new Carrera(recorrido, vehiculos).start();
                    return null;
                default:
                    return null;
            }
        }
    }
    
    private int validar() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    private Vehiculo crearVehiculo(String tipo) {
        Scanner scanner = new Scanner(System.in);
        String matricula = "";
        String marca = "";
        double potencia = 0.0;
        System.out.println("Introduzca matricula: ");
        matricula = scanner.nextLine();
        System.out.println("Introduzca marca: ");
        marca = scanner.nextLine();
        System.out.println("Introduzca potencia (1-Poco, 2-Normal, 3-Potente");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                potencia = Vehiculo.VEHICULO_POCO_POTENTE;
                break;
            case 2:
                potencia = Vehiculo.VEHICULO_POTENTE;
                break;
            case 3:
                potencia = Vehiculo.VEHICULO_MUY_POTENTE;
        }
        System.out.println("✔ Vehiculo añadido\n");
        switch (tipo) {
            case "moto":
                return new Moto(matricula, marca, potencia);
            case "coche":
                return new Coche(matricula, marca, potencia);
            case "guagua":
                return new Guagua(matricula, marca, potencia);
        }
        return null;
    }
}
