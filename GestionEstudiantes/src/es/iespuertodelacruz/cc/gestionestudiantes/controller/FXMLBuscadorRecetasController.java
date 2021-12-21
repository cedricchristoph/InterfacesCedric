/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.RecetaDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.TipoReceta;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLBuscadorRecetasController implements Initializable {

    @FXML
    private TextField txtTitulo;
    @FXML
    private ComboBox<TipoReceta> cbxTipos;
    @FXML
    private Button btnFiltrar;
    @FXML
    private VBox itemList;
    @FXML
    private ScrollPane scrollPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actualizarLista();
    }    

    @FXML
    private void filtrar(ActionEvent event) {
        actualizarLista();
    }
    
    private void actualizarLista() {
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
    
}
