/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.utils;

import es.iespuertodelacruz.cc.gestionestudiantes.constants.Images;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author cedric
 */
public class ImageLoader {
    
    public static Image load(String url) throws NullPointerException {
        try (FileInputStream stream = new FileInputStream(url)) {
            return new Image(stream);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
