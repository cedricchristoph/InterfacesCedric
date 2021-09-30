/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

/**
 *
 * @author Cedric Christoph
 */
public class FileManager {
    
    final Path fichero = Paths.get("tareas.gt");
    Gestor parent;
    BufferedReader lector;
    BufferedWriter writer;
    Integer idCounter;
    
    /**
     * Constructor por defecto
     */
    public FileManager(Gestor parent) {
        this.parent = parent;
        idCounter = 0;
    }

    /* Getters & Setters */
    public Path getFichero() {
        return fichero;
    }

    public BufferedReader getLector() {
        return lector;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public void setLector(BufferedReader lector) {
        this.lector = lector;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }
    
    /**
     * Funcion que devuelve un ArrayList de tipo Tarea con las tareas cargadas del fichero
     * @return ArrayList de tareas
     */
    public ArrayList<Tarea> cargarTareas() {
        ArrayList<Tarea> tareas = new ArrayList<>();
        try {
            lector = Files.newBufferedReader(fichero);
            String line;
            while ((line = lector.readLine()) != null) {
                String[] data = line.split(";");
                tareas.add(new Tarea(
                        Integer.parseInt(data[0]),
                        Materia.getMateria(data[1]),
                        data[2],
                        data[3],
                        Long.parseLong(data[4]),
                        Boolean.parseBoolean(data[5])
                ));
                idCounter = Integer.parseInt(data[0]);
            }
            idCounter += 1;
        } catch (IOException e) {
            System.out.println("No se encontro el archivo");
        } finally {
            parent.setIdCounter(idCounter);
            try {
                lector.close();
            } catch (Exception e) {
            }
            return tareas;
        }
    }
    
    /**
     * Metodo para guardar un arraylist de tarea a un fichero
     * @param tareas ArrayList a guardar
     */
    public void guardarTareas(ArrayList<Tarea> tareas) {

        try {
            writer = Files.newBufferedWriter(fichero);
            tareas.stream().forEach(tarea -> {
                try {
                    writer.write(tarea.getTareaAsDataRow());
                } catch (IOException ex) {
                    
                }
            });
        } catch (IOException ex) {
            
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }

    }
    
}
