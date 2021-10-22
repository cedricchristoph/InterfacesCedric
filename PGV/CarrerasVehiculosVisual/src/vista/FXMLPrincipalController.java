/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import es.iespuertodelacruz.cc.modelo.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Cedric Christoph
 */
public class FXMLPrincipalController implements Initializable {

    private String vehiculo = "";

    private Carrera carrera;
    private Recorrido recorrido;
    private ArrayList<Vehiculo> vehiculos;
    
    @FXML
    private Button btnNuevaCarrera;
    @FXML
    private Button btnNuevaMoto;
    @FXML
    private Button btnNuevoCoche;
    @FXML
    private Button btnNuevaGuagua;
    @FXML
    private Button btnIniciarCarrera;
    @FXML
    private VBox vboxVehiculos;
    @FXML
    private VBox vboxAddVehiculo;
    @FXML
    private Label labelAdd;
    @FXML
    private ComboBox<String> txtMarca;
    @FXML
    private TextField txtMatricula;
    @FXML
    private RadioButton radioPoco;
    @FXML
    private ToggleGroup groupPotencia;
    @FXML
    private RadioButton radioNormal;
    @FXML
    private RadioButton radioMuy;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnCancel;
    @FXML
    private BorderPane content;
    @FXML
    private Label labelCarrera;
    @FXML
    private Button btnFinalizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        content.setRight(null);
    }    

    @FXML
    private void nuevaCarrera(ActionEvent event) {
        recorrido = new Recorrido(2000, 5);
        vehiculos = new ArrayList();
        carrera = new Carrera(recorrido, vehiculos);
        btnNuevaCarrera.setDisable(true);
        labelCarrera.setText("¡Carrera creada! Introduzca participantes");
        changeState(true, btnNuevaMoto, btnNuevoCoche, btnNuevaGuagua);
//        btnNuevaMoto.setDisable(false);
//        btnNuevoCoche.setDisable(false);
//        btnNuevaGuagua.setDisable(false);
    }

    @FXML
    private void nuevaMoto(ActionEvent event) {
        showCreationWindow("moto", "Honda", "Kawasaki", "KTM", "BMW", "Ducati", "Yamaha");
    }

    @FXML
    private void nuevoCoche(ActionEvent event) {
        showCreationWindow("coche", "Nissan", "Toyota", "Volvo", "Renault", "Mercedes", "Porsche", "Ferrari");
    }

    @FXML
    private void nuevaGuagua(ActionEvent event) {
        showCreationWindow("guagua", "BMW", "MAN", "Volvo");
    }

    @FXML
    private void iniciarCarrera(ActionEvent event) {
        changeState(false, btnIniciarCarrera, btnNuevaCarrera, btnNuevaGuagua, btnNuevaMoto, btnNuevoCoche);
        changeState(true, btnFinalizar);
        carrera.setVehiculos(vehiculos);
        labelCarrera.setText("Carrera en curso...");
        carrera.start();
    }

    @FXML
    private void addVehiculo(ActionEvent event) {
        Vehiculo v;
        switch (vehiculo) {
            case "coche":
                v = new Coche(
                        txtMatricula.getText(),
                        txtMarca.getSelectionModel().getSelectedItem(),
                        getPotenciaSeleccionada()
                );
                break;
            case "guagua":
                v = new Guagua(
                        txtMatricula.getText(),
                        txtMarca.getSelectionModel().getSelectedItem(),
                        getPotenciaSeleccionada()
                );
                break;
            default:
                v = new Moto(
                        txtMatricula.getText(),
                        txtMarca.getSelectionModel().getSelectedItem(),
                        getPotenciaSeleccionada()
                );
                break;
        }
        vehiculos.add(v);
        vboxVehiculos.getChildren().add(v.getVehicleBox());
        changeState(true, btnIniciarCarrera);
        resetCreationWindow();
    }
    
    private void changeState(boolean state, Node... componentes) {
        for (Node n : componentes) {
            n.setDisable(!state);
        }
    }
    
    private double getPotenciaSeleccionada() {
        if (radioPoco.isSelected())
            return Vehiculo.VEHICULO_POCO_POTENTE;
        if (radioNormal.isSelected())
            return Vehiculo.VEHICULO_POTENTE;
        return Vehiculo.VEHICULO_MUY_POTENTE;
    }
    
    private void resetCreationWindow() {
        vboxAddVehiculo.setVisible(false);
        content.setRight(null);
        for (int i = txtMarca.getItems().size()-1; i > 0; i--) {
            txtMarca.getItems().remove(i);
        }
        txtMatricula.setText("");
        radioNormal.setSelected(true);
    }

    @FXML
    private void cancelarCreacion(ActionEvent event) {
        resetCreationWindow();
    }

    
    private void showCreationWindow(String vehicleType, String... marcas) {
        vehiculo = vehicleType;
        labelAdd.setText("Añadir " + vehicleType);
        txtMarca.getItems().addAll(marcas);
        content.setRight(vboxAddVehiculo);
        vboxAddVehiculo.setVisible(true);
    }

    @FXML
    private void finalizarCarrera(ActionEvent event) {
        carrera = null;
        vehiculos = null;
        vboxVehiculos.getChildren().removeAll(vboxVehiculos.getChildren());
        labelCarrera.setText("No existe ninguna carrera");
        changeState(false, btnFinalizar);
        changeState(true, btnNuevaCarrera);
    }

}
