package vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import modelo.MaquinaDao;
import modelo.Suministros;
import modelo.SuministrosDao;
import modelo.UsuarioDao;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ramir
 */
public class FrmSuministros extends javax.swing.JFrame {
    
    Suministros sum = new Suministros();
    SuministrosDao sDao= new SuministrosDao();
    private PanelSuministros panelSuministros;
    MaquinaDao mDao = new MaquinaDao();
    UsuarioDao uDao = new UsuarioDao();
    Calendar fecha_actual = new GregorianCalendar();
    
    public FrmSuministros() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        cmbMaquina = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtHorometro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtComentarios = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbOperador = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtIdSuministros = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Fecha:");

        jLabel2.setText("Máquina:");

        cmbMaquina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Horometro:");

        jLabel4.setText("Total:");

        jLabel5.setText("Comentarios:");

        jLabel6.setText("Operador:");

        cmbOperador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(cmbMaquina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHorometro)
                            .addComponent(txtTotal)
                            .addComponent(txtComentarios)
                            .addComponent(cmbOperador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdSuministros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHorometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(txtIdSuministros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        suministro();
        limpiarSuministros();
        if (panelSuministros != null) {
            panelSuministros.listarSuministros();// Actualiza la tabla con los nuevos datos
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ActualizarSuministro();
        limpiarSuministros();
        if (panelSuministros != null) {
            panelSuministros.listarSuministros(); // Actualiza la tabla con los nuevos datos
        }
        this.dispose();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSuministros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSuministros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSuministros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSuministros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSuministros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbMaquina;
    private javax.swing.JComboBox<String> cmbOperador;
    private com.toedter.calendar.JDateChooser jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtComentarios;
    private javax.swing.JTextField txtHorometro;
    private javax.swing.JTextField txtIdSuministros;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void suministro() {
        // Obtener la fecha como java.util.Date y convertirla a LocalDate
        Date fechaUtil = jFecha.getDate(); // Obtiene la fecha como java.util.Date
        LocalDate fecha = fechaUtil.toInstant() // Convierte java.util.Date a Instant
                .atZone(ZoneId.systemDefault()) // Aplica la zona horaria del sistema
                .toLocalDate(); // Convierte a LocalDate

        // Obtener los demás valores
        String maquina = cmbMaquina.getSelectedItem().toString();
        double horometro = Double.parseDouble(txtHorometro.getText().trim());
        double total = Double.parseDouble(txtTotal.getText().trim());
        String comentarios = txtComentarios.getText().toUpperCase();
        String operador = cmbOperador.getSelectedItem().toString();

        // Asignar los valores al objeto hrs
        sum.setFecha(fecha); // Ahora setFecha() espera un LocalDate
        sum.setMaquina(maquina);
        sum.setHorometro(horometro);
        sum.setTotal(total);
        sum.setComentarios(comentarios);
        sum.setOperador(operador);

        // Llamar al DAO para guardar los datos
        sDao.horometros(sum);
    }

    private void limpiarSuministros() {
        txtIdSuministros.setText("");
        jFecha.setDateFormatString("");
        cmbMaquina.setSelectedItem("");
        txtHorometro.setText("");
        txtTotal.setText("");
        txtComentarios.setText("");
        cmbOperador.setSelectedItem("");

        jFecha.requestFocus();
    }

//private PanelHorometros panelHorometros;
    public FrmSuministros(PanelSuministros panelSuministros) {
        initComponents();
        this.panelSuministros = panelSuministros;
        mDao.ConsultarMaquina(cmbMaquina);
        AutoCompleteDecorator.decorate(cmbMaquina);
        uDao.ConsultarUsuario(cmbOperador);
        AutoCompleteDecorator.decorate(cmbOperador);
        setLocationRelativeTo(null);
        txtIdSuministros.setVisible(false);
        jFecha.setCalendar(fecha_actual);
        cmbMaquina.requestFocus();
    }

    void setSuministro(Suministros sum) {
        int id_suministro = sum.getId_suministro();
        LocalDate fecha = sum.getFecha(); // Obtener la fecha como LocalDate
        String maquina = sum.getMaquina();
        double horometro = sum.getHorometro();
        double total = sum.getTotal();
        String comentarios = sum.getComentarios();
        String operador = sum.getOperador();

        // Configurar los valores en los campos de texto del formulario
        txtIdSuministros.setText(String.valueOf(id_suministro));

        // Convertir LocalDate a java.util.Date para el campo de fecha
        if (fecha != null) {
            Date fechaUtil = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
            jFecha.setDate(fechaUtil); // Asignar la fecha al campo de fecha
        } else {
            jFecha.setDate(null); // Si la fecha es nula, limpiar el campo
        }

        cmbMaquina.setSelectedItem(maquina);
        txtHorometro.setText(String.valueOf(horometro));
        txtTotal.setText(String.valueOf(total));
        txtComentarios.setText(comentarios);
        cmbOperador.setSelectedItem(operador);
    }

    private void ActualizarSuministro() {
        // Validar que todos los campos estén llenos
        if (jFecha.getDate() == null // Verificar si la fecha es nula
                || cmbMaquina.getSelectedItem() == null
                || txtHorometro.getText().trim().isEmpty()
                || txtTotal.getText().trim().isEmpty()
                || txtComentarios.getText().trim().isEmpty()
                || cmbOperador.getSelectedItem() == null
                || txtIdSuministros.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        // Convertir la fecha de java.util.Date a LocalDate
        Date fechaUtil = jFecha.getDate(); // Obtener la fecha como java.util.Date
        LocalDate fecha = fechaUtil.toInstant() // Convertir a Instant
                .atZone(ZoneId.systemDefault()) // Aplicar la zona horaria del sistema
                .toLocalDate(); // Convertir a LocalDate

        // Asignar los valores al objeto hrs
        sum.setFecha(fecha); // Ahora setFecha() espera un LocalDate
        sum.setMaquina(cmbMaquina.getSelectedItem().toString());
        sum.setHorometro(Double.parseDouble(txtHorometro.getText().trim()));
        sum.setTotal(Double.parseDouble(txtTotal.getText().trim()));
        sum.setComentarios(txtComentarios.getText().toUpperCase());
        sum.setOperador(cmbOperador.getSelectedItem().toString());
        sum.setId_suministro(Integer.parseInt(txtIdSuministros.getText()));

        // Llamar al DAO para actualizar el horómetro
        boolean actualizado = sDao.ModificarSuministro(sum);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Suministro actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el suministro.");
        }
    }
}
