
package vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import modelo.ClientesDao;
import modelo.Contenedores;
import modelo.ContenedoresDao;
import modelo.MaquinaDao;
import modelo.MedidasDao;
import modelo.UsuarioDao;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ramir
 */
public class FrmContenedores extends javax.swing.JFrame {
    
    Contenedores cont = new Contenedores();
    ContenedoresDao contDao = new ContenedoresDao();
    private PanelContenedores panelContenedores;
    MaquinaDao mDao = new MaquinaDao();
    ClientesDao cDao = new ClientesDao();
    UsuarioDao uDao= new UsuarioDao();
    MedidasDao mdsDao = new MedidasDao();
    Calendar fecha_actual = new GregorianCalendar();

    public FrmContenedores() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jFechaContenedor = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        cmbMaquinaContenedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtContendor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbMedidaContenedor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtComentariosContenedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbOperadorContenedor = new javax.swing.JComboBox<>();
        cmbMovimientoContenedor = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtIdContenedor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Fecha:");

        jLabel2.setText("Máquina:");

        cmbMaquinaContenedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Contenedor:");

        jLabel4.setText("Medida:");

        cmbMedidaContenedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Movimiento:");

        jLabel6.setText("Comentarios:");

        jLabel8.setText("Operador:");

        cmbOperadorContenedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMovimientoContenedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbMaquinaContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFechaContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContendor)
                                    .addComponent(cmbMedidaContenedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbMovimientoContenedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtComentariosContenedor)
                                    .addComponent(cmbOperadorContenedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFechaContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMaquinaContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtContendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbMedidaContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbMovimientoContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtComentariosContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbOperadorContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnActualizar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtIdContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        contenedor();
        limpiarContenedor();
        if (panelContenedores != null) {
            panelContenedores.listarContenedores();// Actualiza la tabla con los nuevos datos
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ActualizarContenedor();
        limpiarContenedor();
        if (panelContenedores != null) {
            panelContenedores.listarContenedores();// Actualiza la tabla con los nuevos datos
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
            java.util.logging.Logger.getLogger(FrmContenedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmContenedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmContenedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmContenedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmContenedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbMaquinaContenedor;
    private javax.swing.JComboBox<String> cmbMedidaContenedor;
    private javax.swing.JComboBox<String> cmbMovimientoContenedor;
    private javax.swing.JComboBox<String> cmbOperadorContenedor;
    private com.toedter.calendar.JDateChooser jFechaContenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtComentariosContenedor;
    private javax.swing.JTextField txtContendor;
    private javax.swing.JTextField txtIdContenedor;
    // End of variables declaration//GEN-END:variables

private void contenedor() {
        // Obtener la fecha como java.util.Date y convertirla a LocalDate
        Date fechaUtil = jFechaContenedor.getDate(); // Obtiene la fecha como java.util.Date
        LocalDate fecha = fechaUtil.toInstant() // Convierte java.util.Date a Instant
                .atZone(ZoneId.systemDefault()) // Aplica la zona horaria del sistema
                .toLocalDate(); // Convierte a LocalDate

        // Obtener los demás valores
        String maquina = cmbMaquinaContenedor.getSelectedItem().toString();
        String contenedor = txtContendor.getText().toUpperCase();
        String medida = cmbMedidaContenedor.getSelectedItem().toString();
        String movimiento = cmbMovimientoContenedor.getSelectedItem().toString();
        String comentarios = txtComentariosContenedor.getText().toUpperCase();
        String operador = cmbOperadorContenedor.getSelectedItem().toString();

        // Asignar los valores al objeto hrs
        cont.setFecha(fecha); // Ahora setFecha() espera un LocalDate
        cont.setMaquina(maquina);
        cont.setContenedor(contenedor);
        cont.setMedida(medida);
        cont.setMovimiento(movimiento);
        cont.setComentarios(comentarios);
        cont.setOperador(operador);

        // Llamar al DAO para guardar los datos
        contDao.contenedores(cont);
    }

    private void limpiarContenedor() {
        txtIdContenedor.setText("");
        jFechaContenedor.setDateFormatString("");
        cmbMaquinaContenedor.setSelectedItem("");
        txtContendor.setText("");
        cmbMedidaContenedor.setSelectedItem("");
        cmbMovimientoContenedor.setSelectedItem("");
        txtComentariosContenedor.setText("");
        cmbOperadorContenedor.setSelectedItem("");

        jFechaContenedor.requestFocus();
    }

//private PanelHorometros panelHorometros;
    public FrmContenedores(PanelContenedores panelContenedores) {
        initComponents();
        this.panelContenedores = panelContenedores;
        mDao.ConsultarMaquina(cmbMaquinaContenedor);
        AutoCompleteDecorator.decorate(cmbMaquinaContenedor);
        uDao.ConsultarUsuario(cmbOperadorContenedor);
        AutoCompleteDecorator.decorate(cmbOperadorContenedor);
        mdsDao.ConsultarMedida(cmbMedidaContenedor);
        AutoCompleteDecorator.decorate(cmbMedidaContenedor);
        setLocationRelativeTo(null);
        txtIdContenedor.setVisible(false);
        jFechaContenedor.setCalendar(fecha_actual);
        cmbMaquinaContenedor.requestFocus();
    }

    void setContenedor(Contenedores cont) {
        int id_contenedor = cont.getId_contenedor();
        LocalDate fecha = cont.getFecha(); // Obtener la fecha como LocalDate
        String maquina = cont.getMaquina();
        String contenedor = cont.getContenedor();
        String medida = cont.getMedida();
        String movimiento = cont.getMovimiento();
        String comentarios = cont.getComentarios();
        String operador = cont.getOperador();

        // Configurar los valores en los campos de texto del formulario
        txtIdContenedor.setText(String.valueOf(id_contenedor));

        // Convertir LocalDate a java.util.Date para el campo de fecha
        if (fecha != null) {
            Date fechaUtil = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
            jFechaContenedor.setDate(fechaUtil); // Asignar la fecha al campo de fecha
        } else {
            jFechaContenedor.setDate(null); // Si la fecha es nula, limpiar el campo
        }

        cmbMaquinaContenedor.setSelectedItem(maquina);
        txtContendor.setText(contenedor);
        cmbMedidaContenedor.setSelectedItem(String.valueOf(medida));
        cmbMovimientoContenedor.setSelectedItem(String.valueOf(movimiento));
        txtComentariosContenedor.setText(comentarios);
        cmbOperadorContenedor.setSelectedItem(operador);
    }

    private void ActualizarContenedor() {
        // Validar que todos los campos estén llenos
        if (jFechaContenedor.getDate() == null // Verificar si la fecha es nula
                || cmbMaquinaContenedor.getSelectedItem() == null
                || txtContendor.getText() == null
                || cmbMedidaContenedor.getSelectedItem() == null
                || cmbMovimientoContenedor.getSelectedItem() == null
                || txtComentariosContenedor.getText().trim().isEmpty()
                || cmbOperadorContenedor.getSelectedItem() == null
                || txtIdContenedor.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        // Convertir la fecha de java.util.Date a LocalDate
        Date fechaUtil = jFechaContenedor.getDate(); // Obtener la fecha como java.util.Date
        LocalDate fecha = fechaUtil.toInstant() // Convertir a Instant
                .atZone(ZoneId.systemDefault()) // Aplicar la zona horaria del sistema
                .toLocalDate(); // Convertir a LocalDate

        // Asignar los valores al objeto hrs
        cont.setFecha(fecha); // Ahora setFecha() espera un LocalDate
        cont.setMaquina(cmbMaquinaContenedor.getSelectedItem().toString());
        cont.setContenedor(txtContendor.getText().toUpperCase());
        cont.setMedida(cmbMedidaContenedor.getSelectedItem().toString());
        cont.setMovimiento(cmbMovimientoContenedor.getSelectedItem().toString());
        cont.setComentarios(txtComentariosContenedor.getText().toUpperCase());
        cont.setOperador(cmbOperadorContenedor.getSelectedItem().toString());
        cont.setId_contenedor(Integer.parseInt(txtIdContenedor.getText()));

        // Llamar al DAO para actualizar el horómetro
        boolean actualizado = contDao.ModificarContenedor(cont);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Contenedor actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el contenedor.");
        }
    }
}
