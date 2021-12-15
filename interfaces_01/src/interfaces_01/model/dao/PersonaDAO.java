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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cedric Christoph
 */
public class PersonaDAO implements CRUD<Persona, Integer>{

    FileManager manager;
    
    public PersonaDAO() {
        manager = new FileManager(FileManager.PERSONAS_FILE, FileManager.INDEX_FILE);
    }
    
    @Override
    public void insert(Persona entity) throws Exception {
        if (entity.getId() == null) {
            Integer index = manager.getIndex();
            if (index == null)
                throw new Exception("Indexing Exception. The application could not retrieve the index value and therefore could not save the entity\nPlease repair the index file");
            else {
                entity.setId(index);
                manager.insert(entity.toString());
            }
        }
    }

    @Override
    public void delete(Persona entity) throws Exception {
        manager.delete(entity.getId());
    }

    @Override
    public void update(Persona entity) throws Exception {
        try {
            manager.update(entity.toString(), entity.getId());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
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
