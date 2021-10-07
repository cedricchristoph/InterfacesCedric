/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgv_multihilos13;

import java.text.DecimalFormat;

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
    
    public Vehiculo(String matricula, String marca, double potencia) {
        this.marca = marca;
        this.matricula = matricula;
        this.velocidadMaxima = potencia;
        curvasCogidas = 0;
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
    
    public void printData() {
        String velocidad = new DecimalFormat("##.##").format(this.velocidad);
        String distancia = new DecimalFormat("##.##").format(this.distanciaRecorrida);
        System.out.println(matricula + "  " + velocidad + " km/h   " + distancia + " metros");
    }
    /**
     * Metodo para acelerar el vehiculo
     */
    protected void acelerar() {
        velocidad += convertToMps(velocidadMaxima/2);
        recorrer();
    }
        
    @Override
    public abstract void run();
    
    protected abstract void avanzar();
    
    protected abstract void avanzar(Curva curva);
    
    protected void tick() {
        try {
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
}
