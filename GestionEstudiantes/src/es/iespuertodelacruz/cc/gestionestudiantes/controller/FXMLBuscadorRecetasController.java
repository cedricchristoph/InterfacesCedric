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
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.AuthorizedSection;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.Globals;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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
    private Button btnReset;
 
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
        actualizarLista(false);
        reloadSelectionControl();
        cargarTipoRecetas();
    }    
    
    @FXML
    void filtrarTipo(ActionEvent event) {
        actualizarLista(true);
    }

    @FXML
    void filtrarTitulo(KeyEvent event) {
        actualizarLista(true);
    }

    @FXML
    void reset(ActionEvent event) {
        txtTitulo.setText("");
        cbxTipos.getSelectionModel().select(null);
        actualizarLista(false);
    }
    
    private void cargarTipoRecetas() {
        RecetaTipoDAO dao = new RecetaTipoDAO();
        tiposDeRecetas = dao.selectAll();
        cbxTipos.setItems(FXCollections.observableList(tiposDeRecetas));
    }
    
    private void reloadSelectionControl() {
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
    }
    
    /**
     * Metodo para actualizar los items de recetas.
     * @param useFilter Indica si se deben usar los filtros para la busqueda
     */
    private void actualizarLista(boolean useFilter) {
        
        emptyList();
        SelectedRecetas.unselectAllRecetas();
        RecetaDAO dao = new RecetaDAO();
        
        // Comprobar si se debe usar filtro y si estos vienen rellenados
        if (useFilter) {
            if (txtTitulo.getText().isEmpty() && cbxTipos.getSelectionModel().getSelectedItem() == null) {
                // Se quiere filtrar pero no hay valores
                showResults(dao.selectAll());
                return;
            }
            // Se filtrara con los valore dados
            try {
                showResults(dao.filtrar(txtTitulo.getText(), cbxTipos.getSelectionModel().getSelectedItem()));
            } catch (Exception ex) {
                ex.printStackTrace();
                new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK).show();
            }
            return;
        }
        
        // No se ha activado el filtrado
        showResults(dao.selectAll());
    }
    
    private void showResults(List<Receta> recetas) {
        if (recetas == null) return;
        if (recetas.isEmpty()) {
            mostarNoResults();
            return;
        }
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
    
    private void mostarNoResults() {
        VBox box = new VBox();
        box.setStyle("-fx-background-color: #FFFFFF;");
        box.setPrefSize(1000, 60);
        box.setAlignment(Pos.CENTER);
        Label label = new Label("La búsqueda no obtuvo resultados");
        label.setFont(Font.font("System", 16));
        box.getChildren().add(label);
        itemList.getChildren().add(box);
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
        if (!Globals.chkAccess(AuthorizedSection.MODIFICAR_RECETAS)) return;
        Integer amount = SelectedRecetas.getInstance().amount.intValue();
        new Alert(Alert.AlertType.CONFIRMATION, "Estás a punto de eliminar " + amount + " recetas seleccionadas.\n¿Proceder?", 
            ButtonType.CANCEL, ButtonType.NO, ButtonType.YES)
            .showAndWait().ifPresent(response -> {
                 if (response == ButtonType.YES) {
                     SelectedRecetas.deleteAllSelected();
                     actualizarLista(true);
                 }
            });
    }

    @FXML
    private void edit(ActionEvent event) {
        if (!Globals.chkAccess(AuthorizedSection.MODIFICAR_RECETAS)) return;
    }
    
}
