/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import java.awt.event.WindowStateListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private HBox windowControlPanel;
    @FXML
    private Button btnMinimize;
    @FXML
    private Button btnMaximize;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnLogin;
    @FXML
    private ImageView iconSection;
    @FXML
    private Label labelSection;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void minimizeClicked(ActionEvent event) {
    }

    @FXML
    private void maximizeClicked(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void loginClicked(ActionEvent event) {
    }
    
}
