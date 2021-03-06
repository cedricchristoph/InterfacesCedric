/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.controller;

import interfaces_01.model.entity.Persona;
import interfaces_01.model.utils.Images;
import interfaces_01.model.utils.Personas;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Cedric Christoph
 */
public class FXML_PersonasController implements Initializable {

    @FXML
    private Button btnMenuAgregarPersona;
    @FXML
    private Button btnMenuModificarPersona;
    @FXML
    private Button btnMenuEliminarPersona;
    @FXML
    private TextField txtFiltrarNombre;
    @FXML
    private TableView<Persona> table;
    @FXML
    private TableColumn<Persona, String> colNombre;
    @FXML
    private TableColumn<Persona, String> colApellidos;
    @FXML
    private TableColumn<Persona, Integer> colEdad;

    private Persona selected;
    @FXML
    private Button btnLogout;
    
    private boolean collapsed = false;
    @FXML
    private VBox sidebar;
    @FXML
    private Label labelApplicationMenu;
    @FXML
    private Button btnShowMenu;
    @FXML
    private BorderPane root;
    @FXML
    private ImageView iconShowMenu;
    @FXML
    private HBox menuContainer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNombre.setCellValueFactory(
            new PropertyValueFactory<Persona,String>("nombre")
        );
        colApellidos.setCellValueFactory(
            new PropertyValueFactory<Persona,String>("apellidos")
        );
        colEdad.setCellValueFactory(
            new PropertyValueFactory<Persona,Integer>("edad")
        );
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            
            selected = newSelection;
            
        });
        
        Personas.loadPersonasFromFile();
        reloadTable(Personas.getAllPersona());
        
    }    
    
    /**
     * Metodo que recarga el contenido de la tabla
     * @param data 
     */
    public void reloadTable(ArrayList<Persona> data) {
        table.setItems(FXCollections.observableList(data));
    }

    /**
     * Metodo que abre la ventana de creacion de persona
     * @param event 
     */
    @FXML
    private void onAgregarPersonaClick(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces_01/view/FXML_AgregarEditarPersona.fxml"));
            Parent root = loader.load();
            FXML_AgregarModificarPersona controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
            reloadTable(Personas.getAllPersona());
        } catch (IOException ex) {
        }
        
    }

    /**
     * Metodo que inicia la modificacion de una persona seleccionada
     * @param event 
     */
    @FXML
    private void onModificarPersonaClick(ActionEvent event) {
        if (selected == null) return;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces_01/view/FXML_AgregarEditarPersona.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException ex) {
        }
        if (root == null) return;
        FXML_AgregarModificarPersona controller = loader.getController();
        controller.setPersonaToEdit(selected);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
        reloadTable(Personas.getAllPersona());
    }

    /**
     * Metodo que elimina una persona seleccionada
     * @param event 
     */
    @FXML
    private void onEliminarPersonaClick(ActionEvent event) {
        if (selected == null) return;
        try {
            Personas.removePersona(selected);
            selected = null;
            reloadTable(Personas.getAllPersona());
            new Alert(Alert.AlertType.CONFIRMATION, "Persona eliminada correctamente", ButtonType.OK).showAndWait(); 
        } catch (Exception ex) {
            selected = null;
            new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK).showAndWait();
        }       
    }

    /**
     * Metodo que reacciona a un cambio de busqueda y realiza la busqueda
     * @param event 
     */
    @FXML
    private void search(KeyEvent event) {
        
        reloadTable(Personas.find(txtFiltrarNombre.getText()));
        
    }

    /**
     * Metodo para cerrar sesion
     * @param event 
     */
    @FXML
    private void onLogoutClick(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces_01/view/FXML_Login.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException ex) {
        }
        if (root == null) return;
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Stage)btnLogout.getScene().getWindow()).close();
    }

    /**
     * Boton para abrir y cerrar el menu
     * @param event 
     */
    @FXML
    private void onCollapseClick(ActionEvent event) {
        double expandedWidth = 315;
        Animation menuAnimation = null;
        if (!collapsed) {
            // create an animation to hide sidebar.
            menuAnimation = new Transition() {
                { setCycleDuration(Duration.millis(150)); }
                @Override
                protected void interpolate(double frac) {
                  final double curWidth = expandedWidth * (1.0 - frac);
                  sidebar.setPrefWidth(curWidth);
                  sidebar.setTranslateX(-expandedWidth + curWidth);
                }
            };
            
            menuAnimation.onFinishedProperty().set((EventHandler<ActionEvent>) (ActionEvent actionEvent) -> {
                collapsed = true;
                menuContainer.setPrefWidth(50);
                menuContainer.getChildren().remove(0);
                iconShowMenu.setImage(new Image(Images.ARROW_RIGHT));
            });
            
        } else {
            menuContainer.setPrefWidth(360);  
            menuContainer.getChildren().add(0, sidebar);
            menuAnimation = new Transition() {
            { setCycleDuration(Duration.millis(150)); }
            @Override
            protected void interpolate(double frac) {
              final double curWidth = expandedWidth * frac;
              sidebar.setPrefWidth(curWidth);
              sidebar.setTranslateX(-expandedWidth + curWidth);
            }
          };
          menuAnimation.onFinishedProperty().set((EventHandler<ActionEvent>) (ActionEvent actionEvent) -> {
              collapsed = false;
              iconShowMenu.setImage(new Image(Images.ARROW_LEFT));
            });
        }
        
        if (menuAnimation == null) return;
        menuAnimation.play();
    }
    
}
