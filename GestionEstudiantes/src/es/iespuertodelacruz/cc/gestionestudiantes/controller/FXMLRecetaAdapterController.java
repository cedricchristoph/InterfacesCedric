/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLRecetaAdapterController implements Initializable {

    @FXML
    private AnchorPane recetaAdapter;
    @FXML
    private ImageView img;
    @FXML
    private Label labelTitle;
    @FXML
    private Label labelAutor;

    private Receta receta;
    
    public void setReceta(Receta receta) {
        this.receta = receta;

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelTitle.setText(receta.getTitulo());
        labelAutor.setText(receta.getAutor().getUsername());
    }    

    @FXML
    private void clicked(MouseEvent event) {
    }
    
}
