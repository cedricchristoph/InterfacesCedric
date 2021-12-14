/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.model.dao;

import interfaces_01.model.entity.Persona;
import interfaces_01.model.utils.FileManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cedric Christoph
 */
public class PersonaDAO implements CRUD<Persona, Integer>{

    FileManager manager;
    
    public PersonaDAO() {
        manager = new FileManager(FileManager.PERSONAS_FILE);
    }
    
    @Override
    public void insert(Persona entity) {
        manager.insert(entity.toString());
    }

    @Override
    public void delete(Persona entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Persona entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> selectAll() {
        List<String> lines = manager.readAllLines();
        if (lines == null || (lines != null && lines.isEmpty())) return null;
        List<Persona> personas = new ArrayList<Persona>();
        for (String line : lines) {
            Persona p = Persona.toPersona(line);
            if (p != null)
                personas.add(p);
        }
        return personas;
    }

    @Override
    public Persona selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
