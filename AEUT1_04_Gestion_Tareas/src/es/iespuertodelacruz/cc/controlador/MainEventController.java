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
import es.iespuertodelacruz.cc.vista.MostrarTarea;
import es.iespuertodelacruz.cc.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cedric Christoph
 */
public class MainEventController implements ActionListener {

    /**
     * Constantes y variables de Clases
     */
    private final VentanaPrincipal ventana;
    private final Gestor gestor;
    private final FileManager manager;
    private MostrarTarea ventanaMostrarTarea;
    
    /**
     * Variables
     */
    boolean modoHistorial = false;  
    boolean soloPendientes = false;
    
    public MainEventController(VentanaPrincipal ventana, Gestor gestor, FileManager manager) {
        this.ventana = ventana;
        this.gestor = gestor;
        this.manager = manager;
        loadTareaList();
        loadComboBoxMaterias(ventana.cbxMaterias);
        addActionListeners();
    }
    
    /**
     * Metodo para implementar los ActionListeners en los objetos de la ventana
     */
    private void addActionListeners() {
        ventana.btnCrear.addActionListener(this);
        ventana.btnEliminar.addActionListener(this);
        ventana.btnHecha.addActionListener(this);
        ventana.btnHistorial.addActionListener(this);
        ventana.btnVerTareas.addActionListener(this);
        ventana.buttonAdd.addActionListener(this);
        ventana.chkPendientes.addActionListener(this);
        ventana.lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    mostrarTarea(gestor.getTarea(getSelectedId()));
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.btnEliminar)
            eliminar();
        if (e.getSource() == ventana.buttonAdd) {
            ventana.jdialogAdd.setLocationRelativeTo(null);
            ventana.jdialogAdd.setVisible(true);
        }
        if (e.getSource() == ventana.btnHecha)
            hecha();
        if (e.getSource() == ventana.btnHistorial)
            historial();
        if (e.getSource() == ventana.btnVerTareas)
            pendientes();
        if (e.getSource() == ventana.btnCrear)
            crear();
        if (e.getSource() == ventana.chkPendientes) {
            soloPendientes = ventana.chkPendientes.isSelected();
            loadTareaList();
        }
    }
    
    /**
     * Metodo para crear una nueva tarea a partir de los datos introducidos en el JDialog correspondiente.
     */
    private void crear() {
        gestor.add(
                new Tarea(
                        Materia.getMateria(ventana.cbxMaterias.getSelectedItem().toString()),
                        ventana.txtTitulo.getText(),
                        ventana.txtDescripcion.getText(), 
                        (Date) ventana.spinnerDate.getModel().getValue())
        );
        ventana.jdialogAdd.setVisible(false);
        loadTareaList();
    }
    
    /**
     * Metodo para eliminar la tarea seleccionada en el JTable.
     */
    private void eliminar() {
        gestor.remove(getSelectedId());
        loadTareaList();
    }
    
    /**
     * Metodo para marcar como hecha la tarea seleccionada en el JTable.
     */
    private void hecha() {
        gestor.marcarHecha(getSelectedId());
        loadTareaList();
    }
    
    /**
     * Metodo para cambiar la vista a tareas pendientes (futuras).
     */
    private void pendientes() {
        modoHistorial = false;
        loadTareaList();
        ventana.labelVista.setText("Vista: Viendo tareas pendientes");
    }
    
    /**
     * Metodo para cambiar la vista a tareas pasadas.
     */
    private void historial() {
        modoHistorial = true;
        loadTareaList();
        ventana.labelVista.setText("Vista: Viendo historial");
    }
    
    /**
     * Metodo para cargar la lista de Materias en un objeto JComboBox indicado.
     * @param cbx Objeto a rellenar con la lista de materias.
     */
    private void loadComboBoxMaterias(JComboBox cbx) {
        for (Materia materia : Materia.getMaterias())
            cbx.addItem(materia.getNombre());
    }
    
    /**
     * Metodo para mostrar en una nueva ventana los detalles acerca de una tarea indicada.
     * @param tarea Tarea que se quiere inspeccionar
     */
    private void mostrarTarea(Tarea tarea) {
        ventanaMostrarTarea = new MostrarTarea();
        ventanaMostrarTarea.txtId.setText(tarea.getId() + "");
        ventanaMostrarTarea.txtTitulo.setText(tarea.getTitulo());
        ventanaMostrarTarea.txtDescripcion.setText(tarea.getDescripcion());
        loadComboBoxMaterias(ventanaMostrarTarea.cbxMaterias);
        ventanaMostrarTarea.cbxMaterias.setSelectedItem(tarea.getMateria().getNombre());
        ventanaMostrarTarea.spinnerFecha.getModel().setValue(tarea.getFechaEntrega());
        MostrarEventController mec = new MostrarEventController(this, ventanaMostrarTarea, gestor);
        mec.changeToggleButtonValue(tarea.estaHecha());
        ventanaMostrarTarea.setDefaultCloseOperation(1);
        ventanaMostrarTarea.setLocationRelativeTo(null);
        ventanaMostrarTarea.setVisible(true);
    }
    
    /**
     * Metodo para cargar el JTable con las tareas encontradas en el gestor siguiendo las normas de filtrado indicadas por el usuario.
     * modoHistorial false Muestra tareas en el pasado
     * modoHistorial true Muestra tareas en el futuro
     * soloPendientes false Muestra tareas que aun no han sido marcadas como hechas
     * soloPendientes false Muestra tareas marcadas y no marcadas como hechas
     */
    protected void loadTareaList() {
        DefaultTableModel model = (DefaultTableModel) ventana.lista.getModel();
        model.setRowCount(0);
        if (modoHistorial) {
            if (soloPendientes)
                gestor.getHistorial().stream().filter(t -> t.estaHecha() == false).forEach(tarea -> addRow(tarea));
            else
                gestor.getHistorial().forEach((tarea) -> addRow(tarea));
        } else {
            if (soloPendientes)
                gestor.getTareas().stream().filter(t -> t.estaHecha() == false).forEach(tarea -> addRow(tarea));
            else
                gestor.getTareas().forEach((tarea) -> addRow(tarea));
        }
    }

    /**
     * Metodo para añadir una tarea como una nueva fila en el JTable
     * @param tarea Tarea a añadir
     */
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
    
    /**
     * Funcion que determina el id de la tarea de la fila seleccionada en el JTable
     * @return Devuelve ID de la Tarea seleccionada
     */
    private Integer getSelectedId() {
        try {
            return (Integer) ventana.lista.getValueAt(ventana.lista.getSelectedRow(), 0);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Metodo para eliminar todas las filas del JTable
     * @param model Modelo del JTable a eliminar sus filas
     */
    private void removeAllRows(DefaultTableModel model) {
        try {
            for (int i = model.getRowCount(); i >= 0; i--) {
                model.removeRow(i);
            }
        } catch (Exception e) {

        }
    }

   
    
}
