/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.UserDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLUserSettingsController implements Initializable {

    @FXML
    private Label labelUsername;
    @FXML
    private Button btnChangePass;
    @FXML
    private HBox changePass;
    @FXML
    private PasswordField txtNewPass;
    @FXML
    private PasswordField txtRepeat;
    @FXML
    private Button btnSave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelUsername.setText(User.logged.getUsername());
    }    

    @FXML
    private void changePass(ActionEvent event) {
        changePass.setVisible(true);
    }

    @FXML
    private void save(ActionEvent event) {
        if (!txtNewPass.getText().equals(txtRepeat.getText())) {
            new Alert(Alert.AlertType.WARNING, "Las contrasenñas no coinciden", ButtonType.OK).show();
            return;
        }
        if (txtNewPass.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "La contraseña no puede ser vacía", ButtonType.OK).show();
            return;
        }
        if (txtNewPass.getText().length() < 4) {
            new Alert(Alert.AlertType.WARNING, "La contraseña debe ser de mínimo 4 caracteres", ButtonType.OK).show();
            return;
        }
        if (txtNewPass.getText().equals(User.logged.getPassword())) {
            new Alert(Alert.AlertType.WARNING, "La contraseña debe ser distinta de la actual", ButtonType.OK).show();
            return;
        }
        User.logged.setPassword(txtNewPass.getText());
        UserDAO dao = new UserDAO();
        dao.update(User.logged);
        new Alert(Alert.AlertType.INFORMATION, "Contraseña actualizada con éxito", ButtonType.OK).show();
        txtNewPass.setText("");
        txtRepeat.setText("");
        changePass.setVisible(false);
    }
    
}
