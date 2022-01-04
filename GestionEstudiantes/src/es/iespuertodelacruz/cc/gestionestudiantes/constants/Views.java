/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.constants;

import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.Globals;

/**
 * Clase Views.
 * Contiene los directorios a los que se puede acceder a las distintas vistas de la aplicacion
 * @author Cedric Christoph
 */
public class Views {
 
    private static final String DIR = Globals.VIEWS;
    private static final String WINDOWS = "/windows/";
    private static final String PAGES = "/pages/";
    private static final String OTHER = "/other/";
    
    /*WINDOWS*/
    public static final String LOGIN = DIR + WINDOWS + "FXMLLogin.fxml";
    public static final String MAIN_WINDOW = DIR + WINDOWS + "FXMLMainWindow.fxml";
    
    /*PAGES*/
    public static final String DASHBOARD = DIR + PAGES + "FXMLDashboard.fxml";
    public static final String BUSCADOR_RECETAS = DIR + PAGES + "FXMLBuscadorRecetas.fxml";
    public static final String ESTADISTICAS = DIR + PAGES + "FXMLEstadisticas.fxml";
    
    /*OTHER*/
    public static final String MENU_COLLAPSED = DIR + OTHER + "menu_collapsed.fxml";
    public static final String MENU_FULL = DIR + OTHER + "menu_full.fxml";
    public static final String RECETA_ADAPTER = DIR + OTHER + "FXMLRecetaAdapter.fxml";
    public static final String CREAR_RECETA = DIR + OTHER + "FXMLCrearReceta.fxml";
}
