/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.RecetaDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.RecetaTipoDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.TipoReceta;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.ImageLoader;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    private ComboBox<TipoReceta> cbxTipo;
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

    private List<TipoReceta> tiposDeRecetas;
    private Receta receta;
    private FXMLMainWindowController controller;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        receta = new Receta();
        receta.setAutor(User.logged);
        labelAutor.setText(receta.getAutor().getUsername());
        cargarTipoRecetas();
    }    

    public void setMainWindowController(FXMLMainWindowController controller) {
        this.controller = controller;
    }
    
    private void cargarTipoRecetas() {
        RecetaTipoDAO dao = new RecetaTipoDAO();
        tiposDeRecetas = dao.selectAll();
        cbxTipo.setItems(FXCollections.observableList(tiposDeRecetas));
    }
    
    @FXML
    private void selectImage(MouseEvent event) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(btnCrear.getScene().getWindow());
        try {
            img.setImage(ImageLoader.load(file.getAbsolutePath()));
            receta.setImageURL(file.getAbsolutePath());
        } catch (NullPointerException ex) {
            receta.setImageURL(null);
            new Alert(Alert.AlertType.ERROR, "No se pudo abrir la imagen", ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        volverAlBuscador();
    }

    @FXML
    private void crear(ActionEvent event) {
        // Recibir y comprobar entradas
        try {
            receta.setTitulo(txtTitle.getText());
            try {
                receta.setTiempoPreparacion(Integer.parseInt(txtTiempo.getText()));
            } catch (NumberFormatException e) { throw new Exception("El valor de Tiempo de Preparacion es erróneo");}
            try {
                receta.setCalorias(Float.parseFloat(txtCalorias.getText()));
            } catch (NumberFormatException e) {throw new Exception("El valor del campo Calorías es erróneo");}
            try {
                receta.setComensales(Integer.parseInt(txtPersonas.getText()));
            } catch (Exception e) {throw new Exception("El valor del campo Comensales es erróneo");}
            receta.setIngredientes(txtIngredientes.getText());
            receta.setPasos(txtPasos.getText());
            try {
                receta.setTipo(cbxTipo.getSelectionModel().getSelectedItem());
            } catch (Exception e) {throw new Exception("No ha seleccionado el tipo de receta");}
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
            return;
        }
        
        // Guardar Receta
        try {
            RecetaDAO dao = new RecetaDAO();
            if (!dao.insert(receta))
                throw new Exception("No se pudo crear la receta");            
            volverAlBuscador();
            new Alert(Alert.AlertType.CONFIRMATION, "Receta creada correctamente", ButtonType.OK).show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    @FXML
    private void clicked(MouseEvent event) {
    }
    
    private void volverAlBuscador() {
        controller.showBuscadorRecetas();
    }
}
