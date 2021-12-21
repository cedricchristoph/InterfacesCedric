/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.constants;

/**
 * Clase Views.
 * Contiene los directorios a los que se puede acceder a las distintas vistas de la aplicacion
 * @author Cedric Christoph
 */
public class Views {
 
    private static final String DIR = "/es/iespuertodelacruz/cc/gestionestudiantes/view/";
    private static final String WINDOWS = "windows/";
    private static final String PAGES = "pages/";
    private static final String OTHER = "other/";
    
    /*WINDOWS*/
    public static final String MAIN_WINDOW = DIR + WINDOWS + "FXMLMainWindow.fxml";
    
    /*PAGES*/
    public static final String DASHBOARD = DIR + PAGES + "FXMLDashboard.fxml";
    public static final String BUSCADOR_RECETAS = DIR + PAGES + "FXMLBuscadorRecetas.fxml";
    
    /*OTHER*/
    public static final String MENU_COLLAPSED = DIR + OTHER + "menu_collapsed.fxml";
    public static final String MENU_FULL = DIR + OTHER + "menu_full.fxml";
    public static final String RECETA_ADAPTER = DIR + OTHER + "FXMLRecetaAdapter.fxml";
}
