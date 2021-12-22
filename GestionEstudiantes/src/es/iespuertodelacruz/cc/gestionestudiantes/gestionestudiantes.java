/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Views;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.MyDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Cedric Christoph
 */
public class gestionestudiantes extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        MyDatabase.cargarDriverMysql();
        Parent root = FXMLLoader.load(getClass().getResource(Views.LOGIN));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
