/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

import java.text.DecimalFormat;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Cedric Christoph
 */
public abstract class Vehiculo extends Thread {
    
    public final static double VEHICULO_POCO_POTENTE = 90;
    public final static double VEHICULO_POTENTE = 150;
    public final static double VEHICULO_MUY_POTENTE = 200;
   
    protected String matricula;
    protected String marca;
    protected double velocidadMaxima;
    protected double velocidad;    
    protected Carrera carrera;
    protected int curvasCogidas;
    protected double distanciaRecorrida;
    protected String estado;
    
    private Label label;
    private ProgressBar progress;
    
    public Vehiculo(String matricula, String marca, double potencia) {
        this.marca = marca;
        this.matricula = matricula;
        this.velocidadMaxima = potencia;
        curvasCogidas = 0;
        estado = "En calentamiento...";
        label = new Label();
        progress = new ProgressBar();
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public int getCurvasCogidas() {
        return curvasCogidas;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void setCurvasCogidas(int curvasCogidas) {
        this.curvasCogidas = curvasCogidas;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }
    
    protected boolean nextIsCurva() {
        int siguientePosicion = (int) ((getDistanciaRecorrida() / 100)) + 1;
        try {
            return carrera.getRecorrido().getRuta()[siguientePosicion];
        } catch (Exception e) {
            return false;
        }
    }
    
    public void printData() {
        System.out.println(matricula + "  " + getFormattedVelocity() + " km/h   " + getFormattedDistance() + " metros");
    }
    
    private String getFormattedVelocity() {
        return new DecimalFormat("##.##").format(this.velocidad);
    
    }
    
    private String getFormattedDistance() {
        return new DecimalFormat("##.##").format(this.distanciaRecorrida);
    }
    /**
     * Metodo para acelerar el vehiculo
     */
    protected void acelerar() {
        velocidad += convertToMps(velocidadMaxima/2)*(Math.random() + 1);
        recorrer();
    }
        
    @Override
    public void run() {
        while (distanciaRecorrida < carrera.getRecorrido().getDistanciaTotal()) {
            avanzar();
            tick();
        }
        int puesto = carrera.addLlegada(this);
        estado = puesto + "º PUESTO";
        actualizarValores(false);        
    }
    
    protected void avanzar() {
        if (nextIsCurva()) {
            //System.out.println("Cogiendo curva...");
            int siguientePosicion = (int) ((getDistanciaRecorrida() / 100)) + 1;
            avanzar(carrera.getRecorrido().getCurva(siguientePosicion));
        } else {
            if (velocidad < velocidadMaxima) {
                estado = "Acelerando en recta...";
                //System.out.println("Acelerando...");
                acelerar();
                printData();
            } else {
                estado = "Manteniedno velocidad en recta...";
                //System.out.println("Manteniendo velocidad...");
                recorrer();
                printData();
            }
        }
    }
    
    protected abstract void avanzar(Curva curva);
    
    protected void tick() {
        try {
            actualizarValores(true);
            sleep(1000);
        } catch (Exception e) {
        }
    }
    
    protected double convertToMps(double velocidad) {
        return velocidad/(3.6);
    }
    
    protected void recorrer() {
        distanciaRecorrida += convertToMps(velocidad);
    }
    
    private void actualizarValores(boolean withVelocity) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                double porcentaje = distanciaRecorrida / carrera.getRecorrido().getDistanciaTotal();
                progress.setProgress(porcentaje);
                label.setText(getStringEstado(withVelocity));
            }
        });
    }
    
    private String getStringEstado(boolean withVelocity) {
        if (withVelocity)
            return getMarca().toUpperCase() + " " + getMatricula().toUpperCase() + "  " + getFormattedVelocity() + "km/h  (" + estado + ")";
        else
            return getMarca().toUpperCase() + " " + getMatricula().toUpperCase() + "  (" + estado + ")";
    }
    
    public VBox getVehicleBox() {
        VBox box = new VBox();
        box.setPrefHeight(70d);
        box.setPrefWidth(692d);
        VBox.setMargin(box, new Insets(5, 0, 0, 0));
        
        label.setText(getStringEstado(false));
        label.setFont(Font.font("Ubuntu", 19));
        progress.prefHeight(23d);
        progress.setPrefWidth(692d);
        
        box.getChildren().addAll(label, progress);
        return box;
    }
    
//    protected int random(int min, int max) {
//        return (int) (Math.random() * max - min) + min;
//    }
}
