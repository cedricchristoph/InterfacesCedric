/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author Cedric Christoph
 */
public class FXML_LoginController implements Initializable {
    
    private Label label;
    int i = 1;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPwd;
    @FXML
    private Button btnCrearCuenta;
    @FXML
    private Button btnAcceder;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crearCuenta(ActionEvent event) {
        
    }     

    @FXML
    private void acceder(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces_01/view/FXML_Personas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Stage) btnAcceder.getScene().getWindow()).close();
        } catch (IOException ex) {
            Logger.getLogger(FXML_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
