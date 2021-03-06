/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.vistacontrolador;

/**
 *
 * @author cedric
 */
public class ComponentesVentana extends javax.swing.JFrame {

    /**
     * Creates new form ComponentesVentana
     */
    public ComponentesVentana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogReservar = new javax.swing.JDialog();
        labelTitulo = new javax.swing.JLabel();
        panelInformacionPersonal = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelDatosEvento = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        spinnerFecha = new javax.swing.JSpinner();
        cbxTipoEvento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spinnerPersonas = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        cbxTipoCocina = new javax.swing.JComboBox<>();
        panelJornadas = new javax.swing.JPanel();
        spinnerJornadas = new javax.swing.JSpinner();
        labelJornadas = new javax.swing.JLabel();
        chkHabitaciones = new javax.swing.JCheckBox();
        btnConfirmar = new javax.swing.JButton();
        btnReservar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuEncuesta = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JMenu();

        labelTitulo.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelTitulo.setText("Reservar");
        labelTitulo.setToolTipText("");

        panelInformacionPersonal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N
        panelInformacionPersonal.setToolTipText("Introduce los datos personales del cliente que realiza la reserva");

        txtNombre.setToolTipText("Introduce el nombre del cliente");

        txtApellidos.setToolTipText("Introduce los apellidos del cliente");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellidos");

        javax.swing.GroupLayout panelInformacionPersonalLayout = new javax.swing.GroupLayout(panelInformacionPersonal);
        panelInformacionPersonal.setLayout(panelInformacionPersonalLayout);
        panelInformacionPersonalLayout.setHorizontalGroup(
            panelInformacionPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacionPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addGroup(panelInformacionPersonalLayout.createSequentialGroup()
                        .addGroup(panelInformacionPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInformacionPersonalLayout.setVerticalGroup(
            panelInformacionPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionPersonalLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        panelDatosEvento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del evento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        jLabel4.setText("Fecha");
        jLabel4.setToolTipText("Fecha del evento");

        spinnerFecha.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        spinnerFecha.setModel(new javax.swing.SpinnerDateModel());
        spinnerFecha.setToolTipText("Seleccionar la fecha del evento");

        cbxTipoEvento.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        cbxTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Banquete", "Jornada", "Congreso" }));
        cbxTipoEvento.setToolTipText("Seleccionar el tipo de evento");
        cbxTipoEvento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoEventoItemStateChanged(evt);
            }
        });

        jLabel5.setText("Tipo de evento");
        jLabel5.setToolTipText("Seleccionar el tipo de evento");

        jLabel6.setText("N?? Personas");
        jLabel6.setToolTipText("");

        spinnerPersonas.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        spinnerPersonas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerPersonas.setToolTipText("Introducir el n?? de personas que asistiran al evento");

        jLabel7.setText("TIpo de cocina");
        jLabel7.setToolTipText("");

        cbxTipoCocina.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        cbxTipoCocina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Bufe", "Carta", "Pedir cita con chef", "No precisa" }));
        cbxTipoCocina.setToolTipText("Seleccionar el tipo de cocina");

        javax.swing.GroupLayout panelDatosEventoLayout = new javax.swing.GroupLayout(panelDatosEvento);
        panelDatosEvento.setLayout(panelDatosEventoLayout);
        panelDatosEventoLayout.setHorizontalGroup(
            panelDatosEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosEventoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxTipoCocina, javax.swing.GroupLayout.Alignment.TRAILING, 0, 283, Short.MAX_VALUE)
                    .addComponent(spinnerPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(cbxTipoEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinnerFecha)
                    .addGroup(panelDatosEventoLayout.createSequentialGroup()
                        .addGroup(panelDatosEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDatosEventoLayout.setVerticalGroup(
            panelDatosEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosEventoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoCocina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        panelJornadas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N?? Jornadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N
        panelJornadas.setToolTipText("");
        panelJornadas.setEnabled(false);

        spinnerJornadas.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        spinnerJornadas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerJornadas.setToolTipText("Introducir n?? de jornadas");
        spinnerJornadas.setEnabled(false);

        labelJornadas.setText("N?? Jornadas");
        labelJornadas.setToolTipText("");
        labelJornadas.setEnabled(false);

        chkHabitaciones.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        chkHabitaciones.setText("Se requieren habitaciones");
        chkHabitaciones.setEnabled(false);

        javax.swing.GroupLayout panelJornadasLayout = new javax.swing.GroupLayout(panelJornadas);
        panelJornadas.setLayout(panelJornadasLayout);
        panelJornadasLayout.setHorizontalGroup(
            panelJornadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJornadasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJornadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerJornadas)
                    .addGroup(panelJornadasLayout.createSequentialGroup()
                        .addGroup(panelJornadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelJornadas)
                            .addComponent(chkHabitaciones))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelJornadasLayout.setVerticalGroup(
            panelJornadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJornadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelJornadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkHabitaciones)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btnConfirmar.setText("Reservar");

        javax.swing.GroupLayout dialogReservarLayout = new javax.swing.GroupLayout(dialogReservar.getContentPane());
        dialogReservar.getContentPane().setLayout(dialogReservarLayout);
        dialogReservarLayout.setHorizontalGroup(
            dialogReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogReservarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(dialogReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dialogReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialogReservarLayout.createSequentialGroup()
                            .addGroup(dialogReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelInformacionPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelJornadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panelDatosEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelTitulo)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        dialogReservarLayout.setVerticalGroup(
            dialogReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogReservarLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addGroup(dialogReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dialogReservarLayout.createSequentialGroup()
                        .addComponent(panelInformacionPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDatosEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        menuArchivo.setText("File");
        menuBar.add(menuArchivo);

        menuEncuesta.setText("Encuesta");
        menuBar.add(menuEncuesta);

        menuAyuda.setText("Ayuda");
        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        abrirEncuesta();
    }//GEN-LAST:event_btnReservarActionPerformed

    private void cbxTipoEventoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoEventoItemStateChanged
        if (cbxTipoEvento.getSelectedIndex() == 3)
            visiblePanelJornadas(true);
        else
            visiblePanelJornadas(false);
    }//GEN-LAST:event_cbxTipoEventoItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ComponentesVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComponentesVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComponentesVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComponentesVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComponentesVentana().setVisible(true);
            }
        });
    }
    
    public void visiblePanelJornadas(boolean valor) {
        panelJornadas.setEnabled(valor);
        labelJornadas.setEnabled(valor);
        spinnerJornadas.setEnabled(valor);
        chkHabitaciones.setEnabled(valor);
    }
    
    public void abrirEncuesta() {
        dialogReservar.setSize(679, 560);
        dialogReservar.setVisible(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox<String> cbxTipoCocina;
    private javax.swing.JComboBox<String> cbxTipoEvento;
    private javax.swing.JCheckBox chkHabitaciones;
    private javax.swing.JDialog dialogReservar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelJornadas;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEncuesta;
    private javax.swing.JPanel panelDatosEvento;
    private javax.swing.JPanel panelInformacionPersonal;
    private javax.swing.JPanel panelJornadas;
    private javax.swing.JSpinner spinnerFecha;
    private javax.swing.JSpinner spinnerJornadas;
    private javax.swing.JSpinner spinnerPersonas;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
