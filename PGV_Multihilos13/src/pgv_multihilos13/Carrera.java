/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgv_multihilos13;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cedric Christoph
 */
public class Carrera extends Thread {
    
    Recorrido recorrido;
    Vehiculo[] vehiculos;
    ArrayList<Vehiculo> llegadas;
    boolean carreraFinalizada = false;
    
    public Carrera(Recorrido recorrido, Vehiculo... participantes) {
        this.recorrido = recorrido;
        vehiculos = participantes;
        llegadas = new ArrayList();
    }
    
    @Override
    public void run() {
        for (int i = 1; i < 4; i++) {
            System.out.println(i + "...");
            try {
                sleep(1000);
            } catch (Exception e) {
            }
        }
        iniciarCarrera();
    }
    
    private void iniciarCarrera() {
        for (Vehiculo v : vehiculos) {
            v.setCarrera(this);
            v.start();
        }
        while (carreraFinalizada == false) {
            try {
                sleep(1500);
            } catch (InterruptedException ex) {
                
            }
        } 
        for (int i = 0; i < llegadas.size(); i++) {
            System.out.println((i+1) + "º PUESTO: " + llegadas.get(i).getMatricula());
        }
    }
    
    public synchronized void addLlegada(Vehiculo v) {
        llegadas.add(v);
        carreraFinalizada = llegadas.size() == vehiculos.length;
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Vehiculo> getLlegadas() {
        return llegadas;
    }

    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setLlegadas(ArrayList<Vehiculo> llegadas) {
        this.llegadas = llegadas;
    }
    
    
    
}
