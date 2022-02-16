/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgv_tarea7cedric;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cedric Christoph
 */
public class FileManager {
    
    private Path path;
    
    public FileManager() {
        
    }
    
    public FileManager(String url) {
        useFile(url);
    }
    
    /**
     * Selecciona un fichero y devuelve si este existe o no
     * @param url
     * @return devuelve si este existe o no
     */
    public boolean useFile(String url) {
        path = Paths.get(url);
        return path.toFile().exists();
    }
    
    /**
     * Sobreescribe un fichero o crea uno nuevo si no existe
     * @param data 
     */
    public boolean write(String data) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {
            writer.write(data);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Añade a un fichero o crea uno nuevo si no existe
     * @param data 
     */
    public boolean append(String data) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(data + "\n");
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<String> readAllLines() {
        ArrayList<String> lines = new ArrayList<String>();
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String line = "";
            while ((line = reader.readLine()) != null) 
                lines.add(line);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    }
    
    public boolean deleteFile() {
        return path.toFile().delete();
    }
}
