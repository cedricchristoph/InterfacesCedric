/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.LevelDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.UserDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Level;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLAddUserController implements Initializable {
    
    @FXML
    private AnchorPane component;
    @FXML
    private TextField txtUsuario;
    @FXML
    private ComboBox<Level> cbxLevels;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnGuardar;

    private User userEditing;
    
    FXMLGestionUsuariosController parent;
    
    public void setUserToEdit(User user) {
        userEditing = user;
    }
    
    public void setParent(FXMLGestionUsuariosController controller) {
        parent = controller;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LevelDAO dao = new LevelDAO();
        List<Level> levelList = null;
        levelList = dao.selectAll();
        if (levelList == null) {
            new Alert(Alert.AlertType.ERROR, "ERROR: No se pudieron cargar los grupos de usuarios", ButtonType.OK).showAndWait();
            hide();
            return;
        }
        cbxLevels.setItems(FXCollections.observableList(levelList));
        if (userEditing == null) return;
        txtUsuario.setText(userEditing.getUsername());
        cbxLevels.getSelectionModel().select(userEditing.getLevel());
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        hide();
    }

    @FXML
    private void guardar(ActionEvent event) {
        if (userEditing == null)
            crear();
        else
            actualizar();
    }
    
    private boolean valid(String user, Level level) {
        return user != null && !user.isEmpty() && level != null;
    }
    
    private void crear() {
        UserDAO dao = new UserDAO();
        String usuario = txtUsuario.getText();
        Level level = cbxLevels.getSelectionModel().getSelectedItem();
        if (!valid(usuario, level)) {
            new Alert(Alert.AlertType.ERROR, "Datos incompletos", ButtonType.OK).show();
            return;
        }
        User user = new User();
        user.setUsername(usuario);
        user.setPassword(usuario);
        if (level == null) return;
        user.setLevel(level);
        if (dao.insert(user)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Usuario creado correctamente\nLa contraseña es idéntica al nombre de usuario", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.ERROR, "No se pudo crear el usuario", ButtonType.OK).show();
        }
        hide();
    }
    
    private void actualizar() {
        UserDAO dao = new UserDAO();
        String usuario = txtUsuario.getText();
        Level level = cbxLevels.getSelectionModel().getSelectedItem();
        if (!valid(usuario, level)) {
            new Alert(Alert.AlertType.ERROR, "Datos incompletos", ButtonType.OK).show();
            return;
        }
        userEditing.setUsername(usuario);
        userEditing.setLevel(level);
        if (dao.update(userEditing)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Usuario actualizado correctamente", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.ERROR, "No se pudo actualizar el usuario", ButtonType.OK).show();
        }
        hide();
    }
    
    private void hide() {
        parent.closeAddUserWindow();
    }
}
