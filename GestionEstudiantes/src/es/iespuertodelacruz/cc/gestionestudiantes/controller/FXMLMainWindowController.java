/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLMainWindowController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private HBox windowControlPanel;
    @FXML
    private Button btnMinimize;
    @FXML
    private Button btnMaximize;
    @FXML
    private Button btnExit;
    @FXML
    private ImageView iconSection;
    @FXML
    private Label labelSection;
    @FXML
    private Button btnSettings;

    private boolean menuCollapsed = true;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //changeMenuCollapse();
            Menu_Controller controller = new Menu_Controller();
            controller.setMainWindowController(this);
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.MENU_FULL));
            loader.setController(controller);
            root.setLeft(loader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        changePage(Views.DASHBOARD);
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
    private void settingsClicked(ActionEvent event) {
    }
    
    public void changePage(String location) {
        try {
            Node node = (Node)FXMLLoader.load(getClass().getResource(location));
            if (node == null) return;
            root.setCenter(node);
        } catch (IOException ex) {
        }
    }
    
    /**
     * TODO
     */
    public void changeMenuCollapse() {
        Node node = null;
        Menu_Controller controller = new Menu_Controller();
        controller.setMainWindowController(this);
        FXMLLoader loader = new FXMLLoader();
        loader.setController(controller);
        if (menuCollapsed) {
            try {
                loader.setLocation(getClass().getResource(Views.MENU_FULL));
                node = (Node) loader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                loader.setLocation(getClass().getResource(Views.MENU_COLLAPSED));
                node = (Node) loader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (node == null) return;
        root.setLeft(root);
    }
}
