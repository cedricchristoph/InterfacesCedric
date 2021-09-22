/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertocruz.cc.componentes;

import java.util.Date;

/**
 *
 * @author dama
 */
public class Reserva {
    
    /* Variables obligatorias */
    private String nombre;
    private String tlf;
    private Date fecha;
    private TipoEvento tipoEvento;
    private TipoCocina tipoCocina;
    private Integer numPersonas;
    
    /* En caso de TipoEvento CONGRESO */
    private Integer numJornadas;
    private boolean necesitaHabitaciones;

    /**
     * Constructor normal
     * @param nombre Nombre del cliente completo
     * @param tlf Telefono del cliente
     * @param fecha Fecha del evento
     * @param tipoEvento Tipo de evento
     * @param tipoCocina Tipo de concina
     * @param numPersonas Numero de personas que asisten
     */
    public Reserva(String nombre, String tlf, Date fecha, TipoEvento tipoEvento, TipoCocina tipoCocina, Integer numPersonas) {
        this.nombre = nombre;
        this.tlf = tlf;
        this.fecha = fecha;
        this.tipoEvento = tipoEvento;
        this.tipoCocina = tipoCocina;
        this.numPersonas = numPersonas;
        this.numJornadas = 0;
        this.necesitaHabitaciones = false;
    }
    
    /* Constructor vacío */
    public Reserva() {
    }

    /* Getters & Setters */
    public String getNombre() {
        return nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public Date getFecha() {
        return fecha;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public TipoCocina getTipoCocina() {
        return tipoCocina;
    }

    public Integer getNumPersonas() {
        return numPersonas;
    }

    public Integer getNumJornadas() {
        return numJornadas;
    }

    public boolean seNecesitaHabitaciones() {
        return necesitaHabitaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setTipoCocina(TipoCocina tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    public void setNumJornadas(Integer numJornadas) {
        this.numJornadas = numJornadas;
    }

    public void setNecesitaHabitaciones(boolean necesitaHabitaciones) {
        this.necesitaHabitaciones = necesitaHabitaciones;
    }
    
    /**
     * Método para conseguir la información de una reserva
     */
    @Override
    public String toString() {
        String resultado = "DATOS DE LA RESERVA\n-----------------------------\n" + 
                "Nombre cliente: " + getNombre() + "\n" +
                "Tlf. cliente: " + getTlf() + "\n" +
                "Fecha del evento: " + getFecha() + "\n" +
                "Tipo de evento: " + getTipoEvento() + "\n" +
                "Tipo de concina: " + getTipoCocina().getNombre() + "\n" +
                "Nº personas: " + getNumPersonas() + "\n\n";
        if (getTipoEvento() == TipoEvento.CONGRESO) {
            resultado += "Nº jornadas: " + getNumJornadas() + "\n" +
                    "Se requieren habitaciones: " + seNecesitaHabitaciones() + "\n\n";
        }
        
        return resultado;
    }
    
    
}
