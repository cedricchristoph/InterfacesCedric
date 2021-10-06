/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgv_multihilos13;

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
    protected int distanciaRecorrida;
    
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

    public int getDistanciaRecorrida() {
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

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }
    
    public void printVelocidad() {
        System.out.println(velocidad + " km/h");
    }
    /**
     * Metodo para acelerar el vehiculo
     */
    protected void acelerar() {
        velocidad += velocidadMaxima/6;
    }
    
    private void cojerCurva() {
        int distanciaInicial = getDistanciaRecorrida();
        while(getDistanciaRecorrida() < (distanciaInicial+100)) {
            avanzar();
            tick();
        }
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
}
