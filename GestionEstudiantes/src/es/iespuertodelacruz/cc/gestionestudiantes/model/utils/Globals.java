package es.iespuertodelacruz.cc.gestionestudiantes.model.utils;

import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Authorization;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Globals {

    /* CREDENCIALES DE APLICACION PARA DDBB */
    public static final String CONST_APP_CONNECTOR = "jdbc:mysql://localhost:3307/";
    public static final String CONST_APP_DBLOCATION = "escuelacocina";
    public static final String CONST_APP_USER = "root";
    public static final String CONST_APP_PWD = "";

    /* RUTAS */
    public static final String VIEWS = "/es/iespuertodelacruz/cc/gestionestudiantes/view";

    /* FUNCTIONS */
    public static synchronized boolean chkAccess(AuthorizedSection section) {
        ArrayList<Authorization> authorizations = User.logged.getLevel().getAuthorizations();
        for (Authorization a : authorizations) {
            if (a.getSection() == section) {
                return true;
            }
        }
        new Alert(Alert.AlertType.WARNING, "No estás autorizado", ButtonType.OK).show();
        return false;
    }   
}