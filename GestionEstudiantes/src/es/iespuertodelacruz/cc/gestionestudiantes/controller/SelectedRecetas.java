/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.RecetaDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import java.util.HashMap;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author cedric
 */
public class SelectedRecetas {
    
    
    /* STATIC */
    
    private static SelectedRecetas instance;
    
    public static void clear() {
        instance = null;
    }
    
    public static SelectedRecetas getInstance() {
        if (instance == null) instance = new SelectedRecetas();
        return instance;
    }
    
    public static void selectReceta(Receta receta, FXMLRecetaAdapterController adapter) {
        getInstance().select(receta, adapter);
    }
    
    public static void unselectReceta(Receta receta) {
        getInstance().unselect(receta);
    }
    
    public static void unselectAllRecetas() {
        getInstance().unselectAll();
    }
    
    public static void deleteAllSelected() {
        getInstance().delete();
    }
    
    /* NON-STATIC */
    
    private HashMap<Receta, FXMLRecetaAdapterController> selected;
    public SimpleIntegerProperty amount;
    
    public SelectedRecetas() {
        selected = new HashMap<Receta, FXMLRecetaAdapterController>();
        amount = new SimpleIntegerProperty(0);
    }
    
    public void select(Receta receta, FXMLRecetaAdapterController adapter) {
        if (selected.containsKey(receta)) return;
        selected.put(receta, adapter);
        refreshAmount();
    }
    
    public void unselect(Receta receta) {
        if (!selected.containsKey(receta)) return;
        selected.remove(receta);
        refreshAmount();
    }
    
    // TODO
    public void selectAll() {
        
    }
    
    public void unselectAll() {
        selected.forEach((k,v) -> v.unselect());
        refreshAmount();
    }
    
    private void refreshAmount() {
       amount.set(selected.size());
    }
    
    public HashMap<Receta, FXMLRecetaAdapterController> getMap() {
        return selected;
    }
    
    public void delete() {
        RecetaDAO dao = new RecetaDAO();
        selected.forEach((k, v) -> dao.delete(k));
        selected = new HashMap<Receta, FXMLRecetaAdapterController>();
        refreshAmount();
    }
}
