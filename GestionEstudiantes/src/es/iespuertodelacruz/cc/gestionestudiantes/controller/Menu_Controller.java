/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.Globals;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class Menu_Controller implements Initializable {

    @FXML
    private Button btnCollapse;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnNutricion;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnEstadisticas;
    @FXML
    private Button btnUsuarios;
    @FXML
    private Button btnNotas;
    @FXML
    private Button btnLogout;
    
    private FXMLMainWindowController controller;
    
    public void setMainWindowController(FXMLMainWindowController controller) {
        this.controller = controller;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void collapse(ActionEvent event) {
        controller.changeMenuCollapse();
    }

    @FXML
    private void dashboard(ActionEvent event) {
    }

    @FXML
    private void nutricion(ActionEvent event) {
    }

    @FXML
    private void buscarRecetas(ActionEvent event) {
        controller.changePage(Views.BUSCADOR_RECETAS);
    }

    @FXML
    private void estadisticas(ActionEvent event) {
    }

    @FXML
    private void usuarios(ActionEvent event) {
    }

    @FXML
    private void notas(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
}
