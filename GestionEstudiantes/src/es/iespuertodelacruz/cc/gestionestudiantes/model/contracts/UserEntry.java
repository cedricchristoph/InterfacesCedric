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
public class UserEntry {
    
    public static final String TABLE = "users";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "pass";
    public static final String LEVEL = "userLevel";
    
    public static final String SELECT_ALL = "SELECT * FROM " + TABLE;
}
