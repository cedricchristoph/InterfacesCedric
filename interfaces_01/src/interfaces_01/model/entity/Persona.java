/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.model.entity;

import java.util.ArrayList;

/**
 *
 * @author Cedric Christoph
 */
public class Persona {
    
    private Integer id;
    private String nombre;
    private String apellidos;
    private Integer edad;
    
    public Persona() {
        
    }

    public Persona(Integer id, String nombre, String apellidos, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public boolean setEdad(Integer edad) {
        if (edad < 1 || edad > 120)
            return false;
        this.edad = edad;
        return true;
    }
    
    @Override
    public String toString() {
        return id + ";" + nombre + ";" + apellidos + ";" + edad + "\n";
    }
    
    public static Persona toPersona(String value) {
        String[] split = value.split(";");
        Persona persona = new Persona();
        try {
            persona.setId(Integer.parseInt(split[0]));
            persona.setNombre(split[1]);
            persona.setApellidos(split[2]);
            persona.setEdad(Integer.parseInt(split[3]));
            return persona;
        } catch (Exception e) {
            return null;
        }
    }
}
