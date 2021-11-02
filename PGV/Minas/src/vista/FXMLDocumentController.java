/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import modelo.*;

/**
 * FXML Controller class
 *
 * @author Cedric Christoph
 */
public class FXMLDocumentController implements Initializable {

    private Game game;
    private Map map;
    
    @FXML
    private Button btnNuevaPartida;
    @FXML
    private ComboBox<?> cbxDificultad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void nuevaPartida(ActionEvent event) {
        
    }
    
}
