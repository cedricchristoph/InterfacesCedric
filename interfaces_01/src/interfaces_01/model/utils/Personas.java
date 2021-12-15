/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.model.utils;

import interfaces_01.model.dao.PersonaDAO;
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
    
    public static void addPersona(Persona persona) throws Exception {
        getInstance().add(persona);
    }
    
    public static void removePersona(Persona persona) throws Exception {
        getInstance().remove(persona);
    }
    
    public static void updatePersona(Persona old, Persona replace) throws Exception {
        getInstance().update(old, replace);
    }
    
    public static ArrayList<Persona> getAllPersona() {
        return getInstance().getAll();
    }
    
    public static void loadPersonasFromFile() {
        getInstance().load();
    }
    
    public static ArrayList<Persona> find(String contains) {
        return getInstance().findByName(contains);
    }
    
    // Non-Static
    
    private ArrayList<Persona> personas;
    private PersonaDAO dao;
    
    public Personas() {
        personas = new ArrayList<Persona>();
        dao = new PersonaDAO();
    }
    
    public void load() {
        personas = (ArrayList<Persona>) dao.selectAll();
        if (personas != null) return;
        personas = new ArrayList<Persona>();
    }
    
    public void add(Persona persona) throws Exception {
        dao.insert(persona);
        personas.add(persona);
    }
    
    public void remove(Persona persona) throws Exception {
        dao.delete(persona);
        personas.remove(persona);
    }
    
    public void update(Persona old, Persona replace) throws Exception {
        dao.update(replace);
        personas.remove(old);
        personas.add(replace);
    }
    
    public ArrayList<Persona> getAll() {
        return personas;
    }
    
    public ArrayList<Persona> findByName(String name) {
        List<Persona> personas = getAll().stream().filter(p -> p.getNombre().contains(name)).collect(Collectors.toList());
        ArrayList<Persona> results = new ArrayList<>();
        results.addAll(personas);
        return results;
    }
}
