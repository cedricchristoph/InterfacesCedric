/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertocruz.cc.componentes;

import java.util.Date;

/**
 *
 * @author dama
 */
public class ReservaVentana extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public ReservaVentana() {
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

        jLabel1 = new javax.swing.JLabel();
        panelDatosPersonales = new javax.swing.JPanel();
        txtNombreApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        panelDatosEvento = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        spinnerFechaEvento = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        cbxTipoEvento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        spinnerPersonas = new javax.swing.JSpinner();
        cbxTipoCocina = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        panelJornadas = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        spinnerJornadas = new javax.swing.JSpinner();
        chkHabitaciones = new javax.swing.JCheckBox();
        btnCrearReserva = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuReset = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Crear Reserva");

        panelDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N
        panelDatosPersonales.setToolTipText("Datos personales");
        panelDatosPersonales.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDatosPersonales.setName("panelDatosPersonales"); // NOI18N

        txtNombreApellidos.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel2.setText("Nombre y apellidos");
        jLabel2.setToolTipText("Nombre y apellidos");

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel3.setText("N??mero de tel??fono");
        jLabel3.setToolTipText("N??mero de tel??fono");

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        javax.swing.GroupLayout panelDatosPersonalesLayout = new javax.swing.GroupLayout(panelDatosPersonales);
        panelDatosPersonales.setLayout(panelDatosPersonalesLayout);
        panelDatosPersonalesLayout.setHorizontalGroup(
            panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombreApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDatosPersonalesLayout.setVerticalGroup(
            panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(txtNombreApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDatosEvento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del evento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N
        panelDatosEvento.setToolTipText("Datos del evento");
        panelDatosEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDatosEvento.setName("panelDatosPersonales"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel6.setText("Fecha del evento");
        jLabel6.setToolTipText("Fecha del evento");

        spinnerFechaEvento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spinnerFechaEvento.setModel(new javax.swing.SpinnerDateModel());

        jLabel7.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel7.setText("Tipo de evento");
        jLabel7.setToolTipText("Tipo de evento");

        cbxTipoEvento.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbxTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No seleccionado", "Banquete", "Jornada", "Congreso" }));
        cbxTipoEvento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoEventoItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel8.setText("N?? de personas que asisten");
        jLabel8.setToolTipText("N?? de personas que asisten");

        cbxTipoCocina.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbxTipoCocina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No seleccionado", "Buf??", "Carta", "Pedir cita con el chef", "No precisa" }));

        jLabel9.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel9.setText("Tipo de cocina");
        jLabel9.setToolTipText("Tipo de cocina");

        javax.swing.GroupLayout panelDatosEventoLayout = new javax.swing.GroupLayout(panelDatosEvento);
        panelDatosEvento.setLayout(panelDatosEventoLayout);
        panelDatosEventoLayout.setHorizontalGroup(
            panelDatosEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosEventoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerFechaEvento)
                    .addComponent(cbxTipoEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxTipoCocina, 0, 328, Short.MAX_VALUE)
                    .addGroup(panelDatosEventoLayout.createSequentialGroup()
                        .addGroup(panelDatosEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(spinnerPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDatosEventoLayout.setVerticalGroup(
            panelDatosEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosEventoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoCocina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelJornadas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jornadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel10.setText("N?? de jornadas");
        jLabel10.setToolTipText("N?? de personas que asisten");
        jLabel10.setEnabled(false);

        spinnerJornadas.setEnabled(false);

        chkHabitaciones.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        chkHabitaciones.setText("Se requieren habitaciones");
        chkHabitaciones.setEnabled(false);

        javax.swing.GroupLayout panelJornadasLayout = new javax.swing.GroupLayout(panelJornadas);
        panelJornadas.setLayout(panelJornadasLayout);
        panelJornadasLayout.setHorizontalGroup(
            panelJornadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJornadasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJornadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(spinnerJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkHabitaciones))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelJornadasLayout.setVerticalGroup(
            panelJornadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJornadasLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkHabitaciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCrearReserva.setText("Crear reserva");
        btnCrearReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearReservaActionPerformed(evt);
            }
        });

        menuReset.setText("Reset");
        jMenuBar1.add(menuReset);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelJornadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDatosEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCrearReserva)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelJornadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelDatosEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearReserva)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoEventoActionPerformed
       
    }//GEN-LAST:event_cbxTipoEventoActionPerformed

    private void cbxTipoEventoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoEventoItemStateChanged
        if (cbxTipoEvento.getSelectedIndex() == 3) {
            switchPanelJornadas(true);
        } else {
            switchPanelJornadas(false);
        }
    }//GEN-LAST:event_cbxTipoEventoItemStateChanged

    private void btnCrearReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearReservaActionPerformed
        crearReserva();
    }//GEN-LAST:event_btnCrearReservaActionPerformed

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
            java.util.logging.Logger.getLogger(ReservaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservaVentana().setVisible(true);
            }
        });
    }
    
    private void switchPanelJornadas(boolean valor) {
        panelJornadas.setEnabled(valor);
        spinnerJornadas.setEnabled(valor);
        chkHabitaciones.setEnabled(valor);
    }

    private void crearReserva() {
        if (formIsFulfilled()) {
            Reserva nuevaReserva = new Reserva(
                    txtNombreApellidos.getText(),
                    txtTelefono.getText(),
                    (Date) spinnerFechaEvento.getModel().getValue(),
                    TipoEvento.getTipo(cbxTipoEvento.getSelectedItem().toString()),
                    TipoCocina.getTipo(cbxTipoCocina.getSelectedItem().toString()),
                    (Integer) spinnerPersonas.getModel().getValue()
            );

            if (nuevaReserva.getTipoEvento() == TipoEvento.CONGRESO) {
                nuevaReserva.setNumJornadas((Integer) spinnerJornadas.getModel().getValue());
                nuevaReserva.setNecesitaHabitaciones(chkHabitaciones.isSelected());
            }

            System.out.println(nuevaReserva.toString());
        } else {
            System.out.println("Formulario no completado");
        }
    }
    
    private boolean formIsFulfilled() {
        if (!(txtNombreApellidos.getText().equals("")) && !(txtTelefono.getText().equals("") &&
                !(spinnerFechaEvento.getModel().getValue().equals("")) && !(cbxTipoEvento.getSelectedItem().toString().equals("No seleccionado")) 
                && !(cbxTipoCocina.getSelectedItem().toString().equals("No seleccionado")) 
                && !(Integer.parseInt((String) spinnerPersonas.getModel().getValue()) >= 0)))
            return true;
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearReserva;
    private javax.swing.JComboBox<String> cbxTipoCocina;
    private javax.swing.JComboBox<String> cbxTipoEvento;
    private javax.swing.JCheckBox chkHabitaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuReset;
    private javax.swing.JPanel panelDatosEvento;
    private javax.swing.JPanel panelDatosPersonales;
    private javax.swing.JPanel panelJornadas;
    private javax.swing.JSpinner spinnerFechaEvento;
    private javax.swing.JSpinner spinnerJornadas;
    private javax.swing.JSpinner spinnerPersonas;
    private javax.swing.JTextField txtNombreApellidos;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
