/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.controlador;

import es.iespuertodelacruz.cc.modelo.Gestor;
import es.iespuertodelacruz.cc.modelo.Materia;
import es.iespuertodelacruz.cc.modelo.Tarea;
import es.iespuertodelacruz.cc.vista.MostrarTarea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

/**
 *
 * @author cedric
 */
public class MostrarEventController implements ActionListener {

    /**
     * Constantes de clases
     */
    private final MainEventController parent;
    private final MostrarTarea ventana;
    private final Gestor gestor;
    
    public MostrarEventController(MainEventController parent, MostrarTarea ventana, Gestor gestor) {
        this.parent = parent;
        this.ventana = ventana;
        this.gestor = gestor;
        addActionListeners();
    }
    
    /**
     * Metodo para implementar los ActionListeners en los objetos de la ventana
     */
    private void addActionListeners() {
        ventana.btnGuardar.addActionListener(this);
        ventana.btnCancelar.addActionListener(this);
        ventana.toggleButton.addActionListener(this);
        ventana.txtTitulo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    ventana.txtTitulo.setEnabled(true);
                }
            }
        });
        ventana.txtDescripcion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    ventana.txtDescripcion.setEnabled(true);
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.btnGuardar)
            guardar();
        if (e.getSource() == ventana.btnCancelar)
            close();
        if (e.getSource() == ventana.toggleButton)
            changeToggleButtonValue(ventana.toggleButton.isSelected());
    }
    
    /**
     * Metodo para cambiar el texto del toggleButton segun cambia su seleccion
     * @param valor 
     */
    protected void changeToggleButtonValue(boolean valor) {
        ventana.toggleButton.setSelected(valor);
        if (valor == true) 
            ventana.toggleButton.setText("✔HECHA✔");
        else
            ventana.toggleButton.setText("✗PENDIENTE✗");
    }
    
    /**
     * Metodo para guardar los cambios realizados en una tarea.
     */
    private void guardar() {
        Tarea tarea = gestor.getTarea(Integer.parseInt(ventana.txtId.getText()));
        tarea.setTitulo(ventana.txtTitulo.getText());
        tarea.setDescripcion(ventana.txtDescripcion.getText());
        tarea.setHecha(ventana.toggleButton.isSelected());
        tarea.setMateria(Materia.getMateria(ventana.cbxMaterias.getSelectedItem().toString()));
        tarea.setFechaEntrega((Date) ventana.spinnerFecha.getModel().getValue());
        parent.loadTareaList();
        close();
    }
    
    /**
     * Metodo para cerrar la ventana.
     */
    private void close() {
        ventana.setVisible(false);
    }
    
    
}
