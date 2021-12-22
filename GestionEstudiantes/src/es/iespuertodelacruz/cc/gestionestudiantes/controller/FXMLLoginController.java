/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.UserDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
import java.awt.event.WindowStateListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private HBox windowControlPanel;
    @FXML
    private Button btnMinimize;
    @FXML
    private Button btnMaximize;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnLogin;
    @FXML
    private ImageView iconSection;
    @FXML
    private Label labelSection;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void minimizeClicked(ActionEvent event) {
    }

    @FXML
    private void maximizeClicked(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void loginClicked(ActionEvent event) {
        String username = txtUser.getText();
        String pwd = txtPassword.getText();
        try {
            UserDAO dao = new UserDAO();
            User user = dao.selectById(username);
            if (user == null) throw new Exception("Usuario no encontrado");
            if (!user.checkPwd(pwd)) throw new Exception("Contraseña erronea");
            User.logged = user;
            Parent root = FXMLLoader.load(getClass().getResource(Views.MAIN_WINDOW));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            ((Stage)btnLogin.getScene().getWindow()).close();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Usuario y/o contraseña erronea", ButtonType.OK).show();
        }
    }
    
}
