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
public class AuthorizationEntry {
    public static final String TABLE = "authorization";
    public static final String ID = "id";
    public static final String LEVEL = "levelid";
    public static final String AUTHORIZED = "authorized";
    
    public static final String SELECT_ALL = "SELECT * FROM " + TABLE;
}
