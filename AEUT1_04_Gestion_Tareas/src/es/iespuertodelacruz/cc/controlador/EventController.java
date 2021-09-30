/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.controlador;

import es.iespuertodelacruz.cc.modelo.FileManager;
import es.iespuertodelacruz.cc.modelo.Gestor;
import es.iespuertodelacruz.cc.modelo.Materia;
import es.iespuertodelacruz.cc.modelo.Tarea;
import es.iespuertodelacruz.cc.vistacontrolador.MostrarTarea;
import es.iespuertodelacruz.cc.vistacontrolador.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cedric Christoph
 */
public class EventController implements ActionListener {

    private final VentanaPrincipal ventana;
    private MostrarTarea ventanaMostrarTarea;
    private final Gestor gestor;
    private final FileManager manager;
    boolean modoHistorial = false;  
    
    public EventController(VentanaPrincipal ventana, Gestor gestor, FileManager manager) {
        this.ventana = ventana;
        this.gestor = gestor;
        this.manager = manager;
        loadTareaList();
        loadJDialogMaterias();
        addActionListeners();
    }
    
    private void addActionListeners() {
        ventana.btnCrear.addActionListener(this);
        ventana.btnEliminar.addActionListener(this);
        ventana.btnHecha.addActionListener(this);
        ventana.btnHistorial.addActionListener(this);
        ventana.btnVerTareas.addActionListener(this);
        ventana.buttonAdd.addActionListener(this);
        ventana.lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    mostrarTarea(gestor.getTarea(getSelectedId()));
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.btnEliminar)
            eliminar();
        if (e.getSource() == ventana.buttonAdd)
            ventana.jdialogAdd.setVisible(true);
        if (e.getSource() == ventana.btnHecha)
            hecha();
        if (e.getSource() == ventana.btnHistorial)
            historial();
        if (e.getSource() == ventana.btnVerTareas)
            pendientes();
        if (e.getSource() == ventana.btnCrear)
            crear();
    }
    
    private void crear() {
        gestor.add(
                new Tarea(
                        Materia.getMateria(ventana.cbxMaterias.getSelectedItem().toString()),
                        ventana.txtTitulo.getText(),
                        ventana.txtDescripcion.getText(), 
                        (Date) ventana.spinnerDate.getModel().getValue())
        );
        ventana.jdialogAdd.setVisible(false);
        modoHistorial = false;
        loadTareaList();
    }
    
    private void eliminar() {
        gestor.remove(getSelectedId());
        loadTareaList();
    }
    
    private void hecha() {
        gestor.marcarHecha(getSelectedId());
        loadTareaList();
    }
    
    private void pendientes() {
        modoHistorial = false;
        loadTareaList();
        ventana.labelVista.setText("Vista: Viendo tareas pendientes");
    }
    
    private void historial() {
        modoHistorial = true;
        loadTareaList();
        ventana.labelVista.setText("Vista: Viendo historial");
    }
    
    private void loadJDialogMaterias() {
        for (Materia materia : Materia.getMaterias())
            ventana.cbxMaterias.addItem(materia.getNombre());
    }
    
    private void mostrarTarea(Tarea tarea) {
        ventanaMostrarTarea = new MostrarTarea();
        ventanaMostrarTarea.txtTitulo.setText(tarea.getTitulo());
        ventanaMostrarTarea.txtDescripcion.setText(tarea.getDescripcion());
        
    }
    
    /**
     * Metodo para cargar la lista de tareas
     */
    private void loadTareaList() {
        DefaultTableModel model = (DefaultTableModel) ventana.lista.getModel();
        model.setRowCount(0);
        if (modoHistorial) {
            gestor.getHistorial().forEach((tarea) -> addRow(tarea));
        } else {
            gestor.getTareas().forEach((tarea) -> addRow(tarea));
        }
    }

    private void addRow(Tarea tarea) {
        DefaultTableModel model = (DefaultTableModel) ventana.lista.getModel();
        String estado = "";
        if (tarea.estaHecha()) {
            estado = "✔HECHA✔";
        } else {
            estado = "✗PENDIENTE✗";
        }
        model.addRow(new Object[]{tarea.getId(), estado, tarea.getMateria(), tarea.getTitulo(), tarea.getBasicFechaEntrega()});
    }
    
    private Integer getSelectedId() {
        try {
            return (Integer) ventana.lista.getValueAt(ventana.lista.getSelectedRow(), 0);
        } catch (Exception e) {
            return null;
        }
    }
    
    private void removeAllRows(DefaultTableModel model) {
        try {
            for (int i = model.getRowCount(); i >= 0; i--) {
                model.removeRow(i);
            }
        } catch (Exception e) {

        }
    }

   
    
}
