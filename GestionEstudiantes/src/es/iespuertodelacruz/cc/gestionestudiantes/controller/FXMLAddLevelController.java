/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;
import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.LevelDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Level;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXMLAddLevelController implements Initializable {

    @FXML
    private AnchorPane component;

    @FXML
    private TextField txtLevel;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGuardar;

    private Level level;
    
    private FXMLGestionUsuariosController parent;
    
    public void setParent(FXMLGestionUsuariosController controller) {
        parent = controller;
    }
    
    public void setLevel(Level level) {
        this.level = level;
    }
    
    @FXML
    void cancelar(ActionEvent event) {
        close();
    }

    private void close() {
        parent.closeAddLevelWindow();
    }
    
    @FXML
    void guardar(ActionEvent event) {
        if (level == null)
            crear();
        else
            actualizar();
    }
    
    private void crear() {
        LevelDAO dao = new LevelDAO();
        Level level = new Level();
        level.setName(txtLevel.getText());
        if (!dao.insert(level))
            new Alert(Alert.AlertType.ERROR, "No se pudo crear el grupo", ButtonType.OK).show();
        close();
        
    }
    
    private void actualizar() {
        LevelDAO dao = new LevelDAO();
        level.setName(txtLevel.getText());
        if (!dao.update(level))
            new Alert(Alert.AlertType.ERROR, "No se pudo actualizar el grupo", ButtonType.OK).show();
        close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (level == null) return;
        txtLevel.setText(level.getName());
    }

}

