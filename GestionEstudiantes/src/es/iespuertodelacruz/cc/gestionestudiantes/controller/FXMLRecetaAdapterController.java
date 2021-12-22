/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.ImageLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
    @FXML
    private Label labelTime;
    @FXML
    private Label labelPax;
    @FXML
    private ImageView tipoImage;
    @FXML
    private Label labelTipo;
    
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
        labelTipo.setText(receta.getTipo().getTipo());
        labelPax.setText(receta.getComensales() + " pax");
        labelTime.setText(receta.getTiempoPreparacion() + " min");
        try {
            img.setImage(ImageLoader.load(receta.getImageURL()));
        } catch (NullPointerException ex){}
        tipoImage.setImage(ImageLoader.load(receta.getTipo().getImageURL()));
    }    

    @FXML
    private void clicked(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            select();
        } else if (event.getButton() == MouseButton.SECONDARY) {
            unselect();
        }
    }
    
    public void select() {
        SelectedRecetas.selectReceta(receta, this);
        recetaAdapter.getStyleClass().remove(0);
        recetaAdapter.getStyleClass().add("receta-adapter-selected");
    }
    
    public void unselect() {
        SelectedRecetas.unselectReceta(receta);
        recetaAdapter.getStyleClass().remove(0);
        recetaAdapter.getStyleClass().add("receta-adapter");
    }
    
}
