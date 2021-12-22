/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.ImageLoader;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLCrearRecetaController implements Initializable {

    @FXML
    private AnchorPane recetaAdapter;
    @FXML
    private ImageView img;
    @FXML
    private TextField txtTitle;
    @FXML
    private Label labelAutor;
    @FXML
    private TextField txtTiempo;
    @FXML
    private TextField txtPersonas;
    @FXML
    private TextField txtCalorias;
    @FXML
    private Label labelTime;
    @FXML
    private ComboBox<?> cbxTipo;
    @FXML
    private Label labelAutor1;
    @FXML
    private TextArea txtIngredientes;
    @FXML
    private Label labelAutor11;
    @FXML
    private TextArea txtPasos;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCrear;

    private Receta receta;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        receta = new Receta();
        receta.setAutor(User.logged);
    }    

    @FXML
    private void selectImage(MouseEvent event) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(btnCrear.getScene().getWindow());
        try {
            img.setImage(ImageLoader.load(file.getAbsolutePath()));
            receta.setImageURL(file.getAbsolutePath());
        } catch (NullPointerException ex) {
            new Alert(Alert.AlertType.ERROR, "No se pudo abrir la imagen", ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        
    }

    @FXML
    private void crear(ActionEvent event) {
    }

    @FXML
    private void clicked(MouseEvent event) {
    }
    
}
