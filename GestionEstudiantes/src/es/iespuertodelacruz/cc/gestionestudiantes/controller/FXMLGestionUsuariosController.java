/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.LevelDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.UserDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Authorization;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Level;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.AuthorizedSection;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.Globals;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLGestionUsuariosController implements Initializable {

    @FXML
    private Button btnAddUsuario;
    @FXML
    private Button btnEditUsuario;
    @FXML
    private TableView<User> usuarios;
    @FXML
    private Button btnAddLevel;
    @FXML
    private Button btnEditLevel;
    @FXML
    private ListView<Level> listViewLevels;
    @FXML
    private ToggleButton btnAccessDashboard;
    @FXML
    private ToggleButton btnAccessNutricion;
    @FXML
    private ToggleButton btnAccessBuscar;
    @FXML
    private ToggleButton btnAccessModifyRecetas;
    @FXML
    private ToggleButton btnAccessEstadisticas;
    @FXML
    private ToggleButton btnAccessUsuarios;
    @FXML
    private ToggleButton btnAccessNotas;

    private List<User> users;
    private List<Level> levels;
    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, String> levelColumn;
    private User selectedUser;
    private Level selectedLevel;
    @FXML
    private VBox sections;
    @FXML
    private Button btnDeleteUser;
    @FXML
    private Button btnDeleteLevel;
    @FXML
    private VBox permissionSections;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameColumn.setCellValueFactory(
                new PropertyValueFactory<User, String>("username")
        );
        levelColumn.setCellValueFactory(
                new PropertyValueFactory<User, String>("level")
        );
        usuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedUser = newSelection;
            btnEditUsuario.setDisable(selectedUser == null);
            btnDeleteUser.setDisable(selectedUser == null);
        });
    
        loadUserList();
        loadLevelList();
    }   
    
    /**
     * Carga los usuarios de BBDD a la tabla
     */
    private void loadUserList() {
        UserDAO dao = new UserDAO();
        users = dao.selectAll();
        if (users == null) return;
        usuarios.setItems(FXCollections.observableList(users));
        
    }
    
    /**
     * Carga la lista de grupos de usuarios
     */
    private void loadLevelList() {
        LevelDAO dao = new LevelDAO();
        levels = dao.selectAll();
        if (levels == null) return;
        listViewLevels.setItems(FXCollections.observableList(levels));
    }
    
    /**
     * Recarga el estado de los botones de permisos segun el grupo que se ha seleccionado
     */
    private void reloadLevelPermissions() {
        btnAccessDashboard.setSelected(false);
        btnAccessNutricion.setSelected(false);
        btnAccessBuscar.setSelected(false);
        btnAccessModifyRecetas.setSelected(false);
        btnAccessEstadisticas.setSelected(false);
        btnAccessNotas.setSelected(false);
        btnAccessUsuarios.setSelected(false);
        ArrayList<Authorization> authorizations = selectedLevel.getAuthorizations();
        for (Authorization a : authorizations) {
            switch (a.getSection()) {
                case DASHBOARD:
                    btnAccessDashboard.setSelected(true);
                    break;
                case NUTRICION:
                    btnAccessNutricion.setSelected(true);
                    break;
                case BUSCAR_RECETAS:
                    btnAccessBuscar.setSelected(true);
                    break;
                case MODIFICAR_RECETAS:
                    btnAccessModifyRecetas.setSelected(true);
                    break;
                case ESTADISTICAS:
                    btnAccessEstadisticas.setSelected(true);
                    break;
                case GESTION_NOTAS:
                    btnAccessNotas.setSelected(true);
                    break;
                case GESTION_USUARIOS:
                    btnAccessUsuarios.setSelected(true);
                    break;
            }
        }
    }

    /**
     * Cambia el estado de los botones al indicado
     * @param state Nuevo estado de los botones
     */
    private void enableButtons(boolean state) {
        btnAccessDashboard.setDisable(!state);
        btnAccessNutricion.setDisable(!state);
        btnAccessBuscar.setDisable(!state);
        btnAccessModifyRecetas.setDisable(!state);
        btnAccessEstadisticas.setDisable(!state);
        btnAccessNotas.setDisable(!state);
        btnAccessUsuarios.setDisable(!state);
        btnEditLevel.setDisable(!state);
        btnDeleteLevel.setDisable(!state);
    }
    
    
    @FXML
    private void addUser(ActionEvent event) {
        if (!Globals.chkAccess(AuthorizedSection.GESTION_USUARIOS)) return;
        FXMLAddUserController controller = new FXMLAddUserController();
        controller.setParent(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.ADD_USER));
        loader.setController(controller);
        try {
            sections.getChildren().add(1, loader.load());
        } catch (IOException e) {
            
        }
    }
    
    public void closeAddUserWindow() {
        sections.getChildren().remove(1);
        loadUserList();
    }
    
    public void closeAddLevelWindow() {
        permissionSections.getChildren().remove(1);
        loadLevelList();
    }

    @FXML
    private void editUser(ActionEvent event) {
        if (!Globals.chkAccess(AuthorizedSection.GESTION_USUARIOS)) return;
        FXMLAddUserController controller = new FXMLAddUserController();
        controller.setParent(this);
        controller.setUserToEdit(selectedUser);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.ADD_USER));
        loader.setController(controller);
        try {
            sections.getChildren().add(1, loader.load());
        } catch (IOException e) {
            
        }
    }

    @FXML
    private void addLevel(ActionEvent event) {
        if (!Globals.chkAccess(AuthorizedSection.GESTION_USUARIOS)) return;
        FXMLAddLevelController controller = new FXMLAddLevelController();
        controller.setParent(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.ADD_LEVEL));
        loader.setController(controller);
        try {
            permissionSections.getChildren().add(1, loader.load());
        } catch (IOException e) {
            
        }
    }

    @FXML
    private void editLevel(ActionEvent event) {
        if (!Globals.chkAccess(AuthorizedSection.GESTION_USUARIOS)) return;
        FXMLAddLevelController controller = new FXMLAddLevelController();
        controller.setParent(this);
        controller.setLevel(selectedLevel);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.ADD_LEVEL));
        loader.setController(controller);
        try {
            permissionSections.getChildren().add(1, loader.load());
        } catch (IOException e) {
            
        }
    }

    @FXML
    private void listViewClicked(MouseEvent event) {
        selectedLevel = listViewLevels.getSelectionModel().getSelectedItem();
        if (selectedLevel == null) 
            enableButtons(false);
        else
            enableButtons(true);
        reloadLevelPermissions();
    }

    @FXML
    private void switchDashboard(ActionEvent event) {
        if (btnAccessDashboard.isSelected())
            selectedLevel.authorize(AuthorizedSection.DASHBOARD);
        else
            selectedLevel.forbid(AuthorizedSection.DASHBOARD);
    }

    @FXML
    private void switchNutricion(ActionEvent event) {
        if (btnAccessNutricion.isSelected())
            selectedLevel.authorize(AuthorizedSection.NUTRICION);
        else
            selectedLevel.forbid(AuthorizedSection.NUTRICION);
    }

    @FXML
    private void switchBuscador(ActionEvent event) {
        if (btnAccessBuscar.isSelected())
            selectedLevel.authorize(AuthorizedSection.BUSCAR_RECETAS);
        else
            selectedLevel.forbid(AuthorizedSection.BUSCAR_RECETAS);
    }

    @FXML
    private void switchModificar(ActionEvent event) {
        if (btnAccessModifyRecetas.isSelected())
            selectedLevel.authorize(AuthorizedSection.MODIFICAR_RECETAS);
        else
            selectedLevel.forbid(AuthorizedSection.MODIFICAR_RECETAS);
    }

    @FXML
    private void switchEstadisticas(ActionEvent event) {
        if (btnAccessEstadisticas.isSelected())
            selectedLevel.authorize(AuthorizedSection.ESTADISTICAS);
        else
            selectedLevel.forbid(AuthorizedSection.ESTADISTICAS);
    }

    @FXML
    private void switchGestionUsuarios(ActionEvent event) {
        if (btnAccessUsuarios.isSelected())
            selectedLevel.authorize(AuthorizedSection.GESTION_USUARIOS);
        else
            selectedLevel.forbid(AuthorizedSection.GESTION_USUARIOS);
    }

    @FXML
    private void switchNotas(ActionEvent event) {
        if (btnAccessNotas.isSelected())
            selectedLevel.authorize(AuthorizedSection.GESTION_NOTAS);
        else
            selectedLevel.forbid(AuthorizedSection.GESTION_NOTAS);
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        if (!Globals.chkAccess(AuthorizedSection.GESTION_USUARIOS)) return;
        UserDAO dao = new UserDAO();
        dao.delete(selectedUser);
        btnEditUsuario.setDisable(true);
        btnDeleteUser.setDisable(true);
        loadUserList();
    }

    @FXML
    private void deleteLevel(ActionEvent event) {
        if (!Globals.chkAccess(AuthorizedSection.GESTION_USUARIOS)) return;
        LevelDAO dao = new LevelDAO();
        dao.delete(selectedLevel);
        listViewLevels.getItems().remove(selectedLevel);
        selectedLevel = null;
        enableButtons(false);
        loadLevelList();
        loadUserList();
    }
    
}
