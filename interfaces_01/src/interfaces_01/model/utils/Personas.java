/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.model.utils;

import interfaces_01.model.entity.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Cedric Christoph
 */
public class Personas {
    
    
    // Static
    
    private static Personas instance;
    
    private static Personas getInstance() {
        if (instance == null)
            instance = new Personas();
        return instance;
    }
    
    public static void addPersona(Persona persona) {
        getInstance().add(persona);
    }
    
    public static void removePersona(Persona persona) {
        getInstance().remove(persona);
    }
    
    public static ArrayList<Persona> getAllPersona() {
        return getInstance().getAll();
    }
    
    public static ArrayList<Persona> find(String contains) {
        List<Persona> personas = getInstance().getAll().stream().filter(p -> p.getNombre().contains(contains)).collect(Collectors.toList());
        ArrayList<Persona> results = new ArrayList<>();
        results.addAll(personas);
        return results;
    }
    
    // Non-Static
    
    private ArrayList<Persona> personas;
    
    public Personas() {
        personas = new ArrayList<Persona>();
    }
    
    public void add(Persona persona) {
        personas.add(persona);
    }
    
    public void remove(Persona persona) {
        personas.remove(persona);
    }
    
    public ArrayList<Persona> getAll() {
        return personas;
    }
}
