/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.model.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cedric Christoph
 */
public class FileManager {
    
    public static final String PERSONAS_FILE = "personas.csv";
    private Path file;
    
    public FileManager(String file) {
        this.file = Paths.get(file);
    }
    
    public List<String> readAllLines() {
        try {
            return Files.readAllLines(file, Charset.forName("UTF-8"));
        } catch (IOException ex) {
        }
        return new ArrayList<String>();
    }
    
    public void insert(String line) {
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            writer.write(line);
            writer.close();
        } catch (Exception e) {
            try {
                writer.close();
            } catch (Exception ex) {
                
            }
        }
    }
}
