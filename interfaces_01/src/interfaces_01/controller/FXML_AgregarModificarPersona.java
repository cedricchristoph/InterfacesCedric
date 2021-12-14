/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.controller;

import interfaces_01.model.entity.Persona;
import interfaces_01.model.utils.Personas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cedric Christoph
 */
public class FXML_AgregarModificarPersona implements Initializable {

    @FXML
    private Label labelTitle;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private Button btnGuardar;
    
    private Persona toEdit;

    public void setPersonaToEdit(Persona persona) {
        toEdit = persona;
        labelTitle.setText("Editar Persona");
        txtNombre.setText(toEdit.getNombre());
        txtApellidos.setText(toEdit.getApellidos());
        txtEdad.setText(toEdit.getEdad() + "");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void onGuardarClick(ActionEvent event) {
        if (toEdit == null)
            create();
        else
            update();
    }
    
    private void create() {
        Persona p = new Persona();
        p.setNombre(txtNombre.getText());
        p.setApellidos(txtApellidos.getText());
        Integer edad = null;
        try {
            edad = Integer.parseInt(txtEdad.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El valor del campo edad no es numérico", ButtonType.OK);
            alert.showAndWait();
        }
        if (edad!=null) {
            if (!p.setEdad(edad)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "La edad indicada no es válida", ButtonType.OK);
                alert.showAndWait();
            } else {
                Personas.addPersona(p);
                ((Stage)btnGuardar.getScene().getWindow()).close();
            }
        }
        
    }
    
    private void update() {
        Persona persona = new Persona();
        persona.setNombre(txtNombre.getText());
        persona.setApellidos(txtApellidos.getText());
        Integer edad = null;
        try {
            edad = Integer.parseInt(txtEdad.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El valor del campo edad no es numérico", ButtonType.OK);
            alert.showAndWait();
        }
        if (edad == null) return;
        if (!persona.setEdad(edad)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "La edad indicada no es válida", ButtonType.OK);
            alert.showAndWait();
        } else {
            Personas.removePersona(toEdit);
            Personas.addPersona(persona);
            ((Stage)btnGuardar.getScene().getWindow()).close();
        }
    }
    
    
}
