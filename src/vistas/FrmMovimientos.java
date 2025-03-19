package vistas;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.Movimientos;
import modelo.MovimientosDao;

/**
 *
 * @author ramir
 */
public class FrmMovimientos extends javax.swing.JFrame {

    Movimientos mov = new Movimientos();
    MovimientosDao mDao = new MovimientosDao();
    private PanelMovimientos panelMovimientos;

    public FrmMovimientos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMovimiento = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtIdMovimiento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Movimientos:");

        txtMovimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMovimientoKeyPressed(evt);
            }
        });

        btnGuardar.setText("Gardar");
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(txtIdMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarMovimiento();
        limpiarMovimiento();
        if (panelMovimientos != null) {
            this.panelMovimientos.listarMovimientos();
        }
        this.dispose();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        movimientos();
        limpiarMovimiento();
        if (panelMovimientos != null) {
            this.panelMovimientos.listarMovimientos();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtMovimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovimientoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            movimientos();
            limpiarMovimiento();
            if (panelMovimientos != null) {
                panelMovimientos.listarMovimientos();// Actualiza la tabla con los nuevos datos
            }
        }
    }//GEN-LAST:event_txtMovimientoKeyPressed

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
            java.util.logging.Logger.getLogger(FrmMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMovimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtIdMovimiento;
    private javax.swing.JTextField txtMovimiento;
    // End of variables declaration//GEN-END:variables

    private void movimientos() {

        String movimiento = txtMovimiento.getText().toUpperCase();

        mov.setMovimiento(movimiento);
        mDao.movimiento(mov);
    }

    private void limpiarMovimiento() {
        txtIdMovimiento.setText("");
        txtMovimiento.setText("");

        txtMovimiento.requestFocus();
    }

    public FrmMovimientos(PanelMovimientos panelMovimientos) {
        initComponents();
        this.panelMovimientos = panelMovimientos;
        setLocationRelativeTo(null);
        txtIdMovimiento.setVisible(false);
    }

    void setMovimiento(Movimientos mov) {
        int id_movimiento = mov.getId_movimiento();
        String movimiento = mov.getMovimiento();

        // Configurar los valores en los campos de texto del formulario
        txtIdMovimiento.setText(String.valueOf(id_movimiento));
        txtMovimiento.setText(String.valueOf(movimiento));
    }

    private void actualizarMovimiento() {
        if (txtMovimiento.getText().trim().isEmpty()
                || txtIdMovimiento.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        mov.setMovimiento(txtMovimiento.getText().toUpperCase());
        mov.setId_movimiento(Integer.parseInt(txtIdMovimiento.getText()));

        boolean actualizado = mDao.ModificarMovimientos(mov);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Movimiento actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar turno.");
        }
    }
}
