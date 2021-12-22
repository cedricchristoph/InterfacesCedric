/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.contracts;

/**
 *
 * @author cedric
 */
public class RecetaEntry {
    
    public static final String TABLE = "recetas";
    public static final String ID = "id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String TIPO = "tipo";
    public static final String INGREDIENTES = "ingredientes";
    public static final String PASOS = "pasos";
    public static final String COMENSALES = "comensales";
    public static final String TIEMPO_PREPARACION = "tiempoPreparacion";
    public static final String CALORIAS = "calorias";
    public static final String IMAGEN = "imagen";
    
    public static final String SELECT_ALL = "SELECT * FROM " + TABLE;
    
    public static class RecetaTipoEntry {
        public static final String TABLE = "receta_tipos";
        public static final String ID = "id";
        public static final String TIPO = "tipo";
        public static final String IMAGEN = "imagen";
        public static final String SELECT_ALL = "SELECT * FROM " + TABLE;
    }
    
}
