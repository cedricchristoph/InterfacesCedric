/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Cedric Christoph
 */
public class FXMLDashboardController implements Initializable {
    
    @FXML
    private Button btnDashboard;
    @FXML
    private Pane btnManageStudents;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashboardClicked(ActionEvent event) {
    }

    @FXML
    private void manageStudentsClicked(MouseEvent event) {
    }

    
}
