/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.controller;

import interfaces_01.model.entity.Persona;
import interfaces_01.model.utils.Personas;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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
        
        reloadTable(Personas.getAllPersona());
        
    }    
    
    public void reloadTable(ArrayList<Persona> data) {
        table.setItems(FXCollections.observableList(data));
    }

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

    @FXML
    private void onEliminarPersonaClick(ActionEvent event) {
        if (selected == null) return;
        Personas.removePersona(selected);
        selected = null;
        reloadTable(Personas.getAllPersona());
        new Alert(Alert.AlertType.CONFIRMATION, "Persona eliminada correctamente", ButtonType.OK).showAndWait();        
    }

    @FXML
    private void search(KeyEvent event) {
        
        reloadTable(Personas.find(txtFiltrarNombre.getText()));
        
    }
    
    

    
}
