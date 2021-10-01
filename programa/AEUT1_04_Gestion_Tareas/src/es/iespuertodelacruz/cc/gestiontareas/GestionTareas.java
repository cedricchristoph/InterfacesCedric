/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestiontareas;

import es.iespuertodelacruz.cc.controlador.MainEventController;
import es.iespuertodelacruz.cc.modelo.FileManager;
import es.iespuertodelacruz.cc.modelo.Gestor;
import es.iespuertodelacruz.cc.vista.VentanaPrincipal;

/**
 *
 * @author Cedric Christoph
 */
public class GestionTareas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        Gestor gestor = new Gestor();
        FileManager manager = new FileManager(gestor);
        manager.cargarTareas();
        MainEventController eventController = new MainEventController(ventana, gestor, manager);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
}
