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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FXMLFullRecetaController implements Initializable {

   
    @FXML
    private AnchorPane recetaAdapter;

    @FXML
    private HBox windowControlPanel;

    @FXML
    private HBox img;

    @FXML
    private Button btnExit;

    @FXML
    private ImageView imagenReceta;

    @FXML
    private Label labelTitle;

    @FXML
    private Label labelAutor;

    @FXML
    private Label labelTime;

    @FXML
    private Label labelPax;

    @FXML
    private Label labelCal;

    @FXML
    private ImageView imagenTipo;

    @FXML
    private Label labelTipo;

    @FXML
    private Label labelAutor1;

    @FXML
    private TextArea txtIngredientes;

    @FXML
    private Label labelAutor11;

    @FXML
    private TextArea txtPasos;

    @FXML
    void clicked(MouseEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {
        ((Stage) btnExit.getScene().getWindow()).close();
    }
    
    private Receta receta;
    
    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelTitle.setText(receta.getTitulo());
        labelAutor.setText(receta.getAutor().getUsername());
        labelTipo.setText(receta.getTipo().getTipo());
        labelPax.setText(receta.getComensales() + " pax");
        labelTime.setText(receta.getTiempoPreparacion() + " min");
        labelCal.setText(receta.getCalorias() + " kcal");
        txtPasos.setText(receta.getPasos());
        txtIngredientes.setText(receta.getIngredientes());
        try {
            imagenReceta.setImage(ImageLoader.load(receta.getImageURL()));
        } catch (NullPointerException ex){}
        imagenTipo.setImage(ImageLoader.load(receta.getTipo().getImageURL()));
    }    

}

