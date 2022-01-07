/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.AuthorizedSection;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.Globals;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private Label labelSection;

    private boolean menuCollapsed = true;
    @FXML
    private Button btnAccount;
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
        showBuscadorRecetas();
    }    

    @FXML
    private void minimizeClicked(ActionEvent event) {

    }

    @FXML
    private void maximizeClicked(ActionEvent event) {
        Stage window = (Stage) btnMaximize.getScene().getWindow();
        if (window.isMaximized())
            window.setMaximized(false);
        else
            window.setMaximized(true);
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Cambia a la página indicada
     * @param location Se debe enviar la ruta del archivo fxml
     */
    public void changePage(String location) {
        try {
            Node node = (Node)FXMLLoader.load(getClass().getResource(location));
            if (node == null) return;
            root.setCenter(node);
        } catch (IOException ex) {
        }
    }
    
    /**
     * Muestra el buscador de recetas
     */
    public void showBuscadorRecetas() {
        if (!Globals.chkAccess(AuthorizedSection.BUSCAR_RECETAS)) return;
        FXMLBuscadorRecetasController controller = new FXMLBuscadorRecetasController();
        controller.setMainWindowController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.BUSCADOR_RECETAS));
        loader.setController(controller);
        Node before = root.getCenter();
        try {
            root.setCenter(loader.load());
            labelSection.setText("Buscador de Recetas");
        } catch (IOException ex) {
            ex.printStackTrace();
            root.setCenter(before);
        }
    }
    
    /**
     * Muestra la ventana de crear una nueva receta
     */
    public void showCrearReceta() {
        if (!Globals.chkAccess(AuthorizedSection.MODIFICAR_RECETAS)) return;
        FXMLCrearRecetaController controller = new FXMLCrearRecetaController();
        controller.setMainWindowController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.CREAR_RECETA));
        loader.setController(controller);
        Node before = root.getCenter();
        try {
            root.setCenter(loader.load());
            labelSection.setText("Crear Receta");
        } catch (IOException e) {
            root.setCenter(before);
        }
    }

    /**
     * Muestra la ventana de editar receta
     * @param receta Receta que se editara
     */
    public void showActualizarReceta(Receta receta) {
        if (!Globals.chkAccess(AuthorizedSection.MODIFICAR_RECETAS)) return;
        FXMLCrearRecetaController controller = new FXMLCrearRecetaController();
        controller.setMainWindowController(this);
        controller.setReceta(receta);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.CREAR_RECETA));
        loader.setController(controller);
        Node before = root.getCenter();
        try {
            root.setCenter(loader.load());
            labelSection.setText("Editar Receta");
        } catch (IOException e) {
            root.setCenter(before);
        }
    }
    
    /**
     * Muestra la ventana de las estadisticas
     */
    public void showEstadisticas() {
        if (!Globals.chkAccess(AuthorizedSection.ESTADISTICAS)) return;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.ESTADISTICAS));
        Node before = root.getCenter();
        try {
            root.setCenter(loader.load());
            labelSection.setText("Estadisticas");
        } catch (IOException ex) {
            root.setCenter(before);
        }
    }
    
    /**
     * Muestra la ventana de gestion de usuarios y permisos
     */
    public void showGestionUsuarios() {
        if (!Globals.chkAccess(AuthorizedSection.GESTION_USUARIOS)) return;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.GESTION_USUARIOS));
        Node before = root.getCenter();
        try {
            root.setCenter(loader.load());
            labelSection.setText("Gestión de Usuarios");
        } catch (IOException ex) {
            ex.printStackTrace();
            root.setCenter(before);
        }
    }
    
    /**
     * Cambia entre un menu mas amplio y otro mas pequeño
     */
    public void changeMenuCollapse() {
        Node node = null;
        Menu_Controller controller = new Menu_Controller();
        controller.setMainWindowController(this);
        if (menuCollapsed) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.MENU_FULL));
                loader.setController(controller);
                node = (Node) loader.load();
                menuCollapsed = false;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.MENU_COLLAPSED));
                loader.setController(controller);
                node = (Node) loader.load();
                menuCollapsed = true;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (node == null) return;
        root.setLeft(node);
    }

    @FXML
    private void accountSettings(ActionEvent event) {
        Node before = root.getCenter();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.ACCOUNT_SETTINGS));
        try {
            root.setCenter(loader.load());
            labelSection.setText("Ajustes de usuario");
        } catch (IOException ex) {
            ex.printStackTrace();
            root.setCenter(before);
        }
    }
    
    /**
     * Realiza el logout
     */
    public void logout() {
        try {
            User.logged = null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.LOGIN));
            Stage stage = new Stage(StageStyle.UNDECORATED);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            ((Stage) btnAccount.getScene().getWindow()).close();
            stage.show();
        } catch (IOException ex) {
            System.exit(1);
        }
        
    }
}
