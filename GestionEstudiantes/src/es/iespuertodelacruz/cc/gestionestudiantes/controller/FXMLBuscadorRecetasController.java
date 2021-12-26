/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.RecetaDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.RecetaTipoDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.TipoReceta;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLBuscadorRecetasController implements Initializable {

    @FXML
    private Label labelSelected;

    @FXML
    private Button btnSelectAll;

    @FXML
    private Button btnDeselectAll;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtTitulo;

    @FXML
    private ComboBox<TipoReceta> cbxTipos;

    @FXML
    private Button btnFiltrar;
 
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private FlowPane itemList;

    private FXMLMainWindowController controller;
    
    
    private List<TipoReceta> tiposDeRecetas;
    
    public void setMainWindowController(FXMLMainWindowController controller) {
        this.controller = controller;
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualizarLista();
        SelectedRecetas.getInstance().amount.addListener((observable, oldValue, newValue) -> {
            labelSelected.setText(newValue + " seleccionado");
            if (newValue.intValue() > 0) 
                btnDelete.setDisable(false);
            else
                btnDelete.setDisable(true);
            if (newValue.intValue() == 1) {
                btnEdit.setDisable(false);
            } else
                btnEdit.setDisable(true);
            
        });
        cargarTipoRecetas();
    }    
    
    @FXML
    private void filtrar(ActionEvent event) {
        actualizarLista();
    }
    
    private void cargarTipoRecetas() {
        RecetaTipoDAO dao = new RecetaTipoDAO();
        tiposDeRecetas = dao.selectAll();
        cbxTipos.setItems(FXCollections.observableList(tiposDeRecetas));
    }
    
    private void actualizarLista() {
        
        emptyList();
        
        RecetaDAO dao = new RecetaDAO();
        List<Receta> recetas = dao.selectAll();
        
        for (Receta receta : recetas) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.RECETA_ADAPTER));
            FXMLRecetaAdapterController controller = new FXMLRecetaAdapterController();
            controller.setReceta(receta);
            loader.setController(controller);
                try {
                    itemList.getChildren().add(
                            (Node) loader.load()
                    );
                } catch (IOException ex) {
                }
        }
    }
    
    private void emptyList() {
        while (itemList.getChildren().size() > 0)
            itemList.getChildren().remove(0);
    }

    @FXML
    private void add(ActionEvent event) {
        
        controller.showCrearReceta();
        
        
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.CREAR_RECETA));        
//        try {
//            itemList.getChildren().add(
//                    (Node) loader.load()
//            );
//        } catch (IOException ex) {
//        }
    }

    @FXML
    private void selectAll(ActionEvent event) {
        
    }
    
    @FXML
    private void deselectAll(ActionEvent event) {
        SelectedRecetas.unselectAllRecetas();
    }

    @FXML
    private void delete(ActionEvent event) {
        SelectedRecetas.deleteAllSelected();
        actualizarLista();
    }

    @FXML
    private void edit(ActionEvent event) {
    }
    
}
