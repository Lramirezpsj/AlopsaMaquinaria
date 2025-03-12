package vistas;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import modelo.Horometros;
import modelo.HorometrosDao;
import modelo.Horometros;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ramir
 */
public class FrmHorometro extends javax.swing.JFrame {

    Horometros hrs = new Horometros();
    HorometrosDao hDao = new HorometrosDao();
    private PanelHorometros panelHorometro;
    Calendar fecha_actual = new GregorianCalendar();

    public FrmHorometro() {
        initComponents();
        this.panelHorometro = panelHorometro;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFechaHorometro = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHoraInicioHorometro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoraFinalHorometro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtComentariosHorometro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BtnGuardarHorometro = new javax.swing.JButton();
        btnActualizarHorometro = new javax.swing.JButton();
        txtIdHorometro = new javax.swing.JTextField();
        txtMaquinaHorometro = new javax.swing.JComboBox<>();
        txtClienteHorometro = new javax.swing.JComboBox<>();
        txtTurnoHorometro = new javax.swing.JComboBox<>();
        txtOperadorHorometro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Fecha:");

        txtFechaHorometro.setBackground(new java.awt.Color(222, 222, 222));
        txtFechaHorometro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtFechaHorometro.setDateFormatString("yyyy/MM/d HH:mm:ss");

        jLabel2.setText("Máquina:");

        jLabel5.setText("Cliente:");

        jLabel3.setText("H-Inicio:");

        txtHoraInicioHorometro.setBackground(new java.awt.Color(222, 222, 222));
        txtHoraInicioHorometro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setText("H-Final:");

        txtHoraFinalHorometro.setBackground(new java.awt.Color(222, 222, 222));
        txtHoraFinalHorometro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtHoraFinalHorometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraFinalHorometroActionPerformed(evt);
            }
        });

        jLabel6.setText("Turno:");

        jLabel7.setText("Comentarios:");

        txtComentariosHorometro.setBackground(new java.awt.Color(222, 222, 222));
        txtComentariosHorometro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Operador:");

        BtnGuardarHorometro.setText("Guardar");
        BtnGuardarHorometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarHorometroActionPerformed(evt);
            }
        });

        btnActualizarHorometro.setText("Actualizar");
        btnActualizarHorometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarHorometroActionPerformed(evt);
            }
        });

        txtMaquinaHorometro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DRT1", "DRT2", "FERRARI", "CONTMASTER", "SISU-31", "VACIOS-2", "CONTCHAMP", "MONTACARGAS-CLARCK", "MONTACARGAS-TOYOTA" }));
        txtMaquinaHorometro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtClienteHorometro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALOPSA", "MAGDALENA", "APM", "BIT" }));
        txtClienteHorometro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtTurnoHorometro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        txtTurnoHorometro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtOperadorHorometro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LRAMIREZ", "ASOLORZANO", "KFLORES" }));
        txtOperadorHorometro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnGuardarHorometro)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarHorometro)
                        .addGap(45, 45, 45)
                        .addComponent(txtIdHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaHorometro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(txtMaquinaHorometro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtHoraFinalHorometro)
                                .addComponent(txtComentariosHorometro)
                                .addComponent(txtTurnoHorometro, 0, 187, Short.MAX_VALUE)
                                .addComponent(txtHoraInicioHorometro, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(txtOperadorHorometro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtClienteHorometro, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtFechaHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtMaquinaHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtClienteHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraInicioHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraFinalHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTurnoHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtComentariosHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtOperadorHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardarHorometro)
                    .addComponent(btnActualizarHorometro)
                    .addComponent(txtIdHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarHorometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarHorometroActionPerformed

        horometro();
        limpiarHorometro();
        if (panelHorometro != null) {
            panelHorometro.listarHorometros();// Actualiza la tabla con los nuevos datos
        }
    }//GEN-LAST:event_BtnGuardarHorometroActionPerformed

    private void btnActualizarHorometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarHorometroActionPerformed
        ActualizarHorometro();
        limpiarHorometro();
        if (panelHorometro != null) {
            panelHorometro.listarHorometros(); // Actualiza la tabla con los nuevos datos
        }
        this.dispose();
    }//GEN-LAST:event_btnActualizarHorometroActionPerformed

    private void txtHoraFinalHorometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraFinalHorometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraFinalHorometroActionPerformed

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
            java.util.logging.Logger.getLogger(FrmHorometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHorometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHorometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHorometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHorometro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardarHorometro;
    private javax.swing.JButton btnActualizarHorometro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> txtClienteHorometro;
    private javax.swing.JTextField txtComentariosHorometro;
    private com.toedter.calendar.JDateChooser txtFechaHorometro;
    private javax.swing.JTextField txtHoraFinalHorometro;
    private javax.swing.JTextField txtHoraInicioHorometro;
    private javax.swing.JTextField txtIdHorometro;
    private javax.swing.JComboBox<String> txtMaquinaHorometro;
    private javax.swing.JComboBox<String> txtOperadorHorometro;
    private javax.swing.JComboBox<String> txtTurnoHorometro;
    // End of variables declaration//GEN-END:variables

    private void horometro() {

        Date fechaUtil = txtFechaHorometro.getDate(); // Obtiene la fecha como java.util.Date
        Timestamp fecha = new Timestamp(fechaUtil.getTime()); // Convierte a java.sql.Timestamp
        String maquina = txtMaquinaHorometro.getSelectedItem().toString();
        String cliente = txtClienteHorometro.getSelectedItem().toString();
        double h_inicio = Double.parseDouble(txtHoraInicioHorometro.getText().trim());
        double h_final = Double.parseDouble(txtHoraFinalHorometro.getText().trim());
        int turno = Integer.parseInt(txtTurnoHorometro.getSelectedItem().toString());
        String comentarios = txtComentariosHorometro.getText().toUpperCase();
        String operador = txtOperadorHorometro.getSelectedItem().toString();

        hrs.setFecha(fecha);
        hrs.setMaquina(maquina);
        hrs.setCliente(cliente);
        hrs.setH_inicio(h_inicio);
        hrs.setH_final(h_final);
        hrs.setTurno(turno);
        hrs.setComentarios(comentarios);
        hrs.setOperador(operador);
        hDao.horometros(hrs);
    }

    private void limpiarHorometro() {
        txtIdHorometro.setText("");
        txtFechaHorometro.setDateFormatString("");
        txtMaquinaHorometro.setSelectedItem("");
        txtClienteHorometro.setSelectedItem("");
        txtHoraInicioHorometro.setText("");
        txtHoraFinalHorometro.setText("");
        txtTurnoHorometro.setSelectedItem("");
        txtComentariosHorometro.setText("");
        txtOperadorHorometro.setSelectedItem("");

        txtFechaHorometro.requestFocus();
    }

//private PanelHorometros panelHorometros;
    public FrmHorometro(PanelHorometros panelHorometros) {
        initComponents();
        this.panelHorometro = panelHorometros;
        setLocationRelativeTo(null);
        txtIdHorometro.setVisible(false);
        txtFechaHorometro.setCalendar(fecha_actual);
        txtMaquinaHorometro.requestFocus();
    }

    void setHorometro(Horometros hrs) {
        int id_horometro = hrs.getId_horometro();
        Timestamp fecha = hrs.getFecha();
        String maquina = hrs.getMaquina();
        String cliente = hrs.getCliente();
        double h_inicio = hrs.getH_inicio();
        double h_final = hrs.getH_final();
        int turno = hrs.getTurno();
        String comentarios = hrs.getComentarios();
        String operador = hrs.getOperador();

        // Configurar los valores en los campos de texto del formulario
        txtIdHorometro.setText(String.valueOf(id_horometro));
        txtFechaHorometro.setDate(fecha);
        txtMaquinaHorometro.setSelectedItem(maquina);
        txtClienteHorometro.setSelectedItem(cliente);
        txtHoraInicioHorometro.setText(String.valueOf(h_inicio));
        txtHoraFinalHorometro.setText(String.valueOf(h_final));
        txtTurnoHorometro.setSelectedItem(turno);
        txtComentariosHorometro.setText(comentarios);
        txtOperadorHorometro.setSelectedItem(operador);
    }

    private void ActualizarHorometro() {
        if (txtFechaHorometro.getDateFormatString().trim().isEmpty()
                || txtMaquinaHorometro.getSelectedItem() == null
                || txtClienteHorometro.getSelectedItem() == null
                || txtHoraInicioHorometro.getText().trim().isEmpty()
                || txtHoraFinalHorometro.getText().trim().isEmpty()
                || txtTurnoHorometro.getSelectedItem() == null
                || txtComentariosHorometro.getText().trim().isEmpty()
                || txtOperadorHorometro.getSelectedItem() == null
                || txtIdHorometro.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        hrs.setFecha(new Timestamp(txtFechaHorometro.getDate().getTime()));
        hrs.setMaquina(txtMaquinaHorometro.getSelectedItem().toString());
        hrs.setCliente(txtClienteHorometro.getSelectedItem().toString());
        hrs.setH_inicio(Double.parseDouble(txtHoraInicioHorometro.getText().trim()));
        hrs.setH_final(Double.parseDouble(txtHoraFinalHorometro.getText().trim()));
        hrs.setTurno(Integer.parseInt(txtTurnoHorometro.getSelectedItem().toString()));
        hrs.setComentarios(txtComentariosHorometro.getText().toUpperCase());
        hrs.setOperador(txtOperadorHorometro.getSelectedItem().toString());
        hrs.setId_horometro(Integer.parseInt(txtIdHorometro.getText()));

        boolean actualizado = hDao.ModificarUsuario(hrs);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario.");
        }
    }
}
