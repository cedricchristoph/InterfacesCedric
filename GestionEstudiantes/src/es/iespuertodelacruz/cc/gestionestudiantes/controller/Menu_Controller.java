/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Authorization;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.Globals;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

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
        btnDashboard.setVisible(false);
        btnNutricion.setVisible(false);
        btnBuscar.setVisible(false);
        btnEstadisticas.setVisible(false);
        btnUsuarios.setVisible(false);
        btnNotas.setVisible(false);
        // Check user authorization
        try {
            List<Authorization> authorizations = User.logged.getLevel().getAuthorizations();
            authorizations.forEach(a -> {
                switch(a.getSection()) {
                    case DASHBOARD:
                        btnDashboard.setVisible(true);
                        break;
                    case NUTRICION:
                        btnNutricion.setVisible(true);
                        break;
                    case BUSCAR_RECETAS:
                        btnBuscar.setVisible(true);
                        break;
                    case ESTADISTICAS:
                        btnEstadisticas.setVisible(true);
                        break;
                    case GESTION_NOTAS:
                        btnNotas.setVisible(true);
                        break;
                    case GESTION_USUARIOS:
                        btnUsuarios.setVisible(true);
                        break;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "No se pudo verificar las autorizaciones.", ButtonType.OK).show();
        }
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
        controller.showBuscadorRecetas();
    }

    @FXML
    private void estadisticas(ActionEvent event) {
        controller.showEstadisticas();
    }

    @FXML
    private void usuarios(ActionEvent event) {
        controller.showGestionUsuarios();
    }

    @FXML
    private void notas(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
}
