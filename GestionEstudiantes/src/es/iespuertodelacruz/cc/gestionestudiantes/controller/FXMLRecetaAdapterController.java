/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.ImageLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private boolean selected = false;
    
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
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
            select();
        } else if (event.getButton() == MouseButton.SECONDARY  && event.getClickCount() == 1) {
            unselect();
        } else if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
            openReceta();
        }
    }
    
    private void openReceta() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.RECETA_FULL));
        FXMLFullRecetaController controller = new FXMLFullRecetaController();
        controller.setReceta(receta);
        loader.setController(controller);
        try {
            Stage stage = new Stage(StageStyle.UNDECORATED);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void select() {
        if (selected) return;
        selected = true;
        SelectedRecetas.selectReceta(receta, this);
        recetaAdapter.getStyleClass().remove(0);
        recetaAdapter.getStyleClass().add("receta-adapter-selected");      
        
    }
    
    public void unselect() {
        if (!selected) return;
        selected = false;
        SelectedRecetas.unselectReceta(receta);
        recetaAdapter.getStyleClass().remove(0);
        recetaAdapter.getStyleClass().add("receta-adapter");
    }
    
}
