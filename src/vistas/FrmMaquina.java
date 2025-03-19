package vistas;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.Maquina;
import modelo.MaquinaDao;

/**
 *
 * @author ramir
 */
public class FrmMaquina extends javax.swing.JFrame {

    private PanelMaquinas panelMaquina;
    Maquina mqn = new Maquina();
    MaquinaDao mDao = new MaquinaDao();
    

    public FrmMaquina() {
        initComponents();
        this.panelMaquina = panelMaquina;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtIdMaquina = new javax.swing.JTextField();
        txtMaquina = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtMaquina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaquinaKeyPressed(evt);
            }
        });

        jLabel1.setText("Máquina:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIdMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtIdMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        maquina();
        limpiarMaquina();
        if (panelMaquina != null) {
            panelMaquina.listarMaquinas(); // Actualiza la tabla con los nuevos datos
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ActualizarMaquina();
        limpiarMaquina();
        if (panelMaquina != null) {
            panelMaquina.listarMaquinas();// Actualiza la tabla con los nuevos datos
        }
        this.dispose();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtMaquinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaquinaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            maquina();
            limpiarMaquina();
            if (panelMaquina != null) {
                panelMaquina.listarMaquinas();// Actualiza la tabla con los nuevos datos
            }
        }
    }//GEN-LAST:event_txtMaquinaKeyPressed

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
            java.util.logging.Logger.getLogger(FrmMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMaquina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtIdMaquina;
    private javax.swing.JTextField txtMaquina;
    // End of variables declaration//GEN-END:variables

    private void maquina() {

        String maquina = txtMaquina.getText().toUpperCase();

        mqn.setMaquina(maquina);
        mDao.maquina(mqn);
    }

    private void limpiarMaquina() {
        txtIdMaquina.setText("");
        txtMaquina.setText("");

        txtMaquina.requestFocus();
    }

    public FrmMaquina(PanelMaquinas panelMaquina) {
        initComponents();
        this.panelMaquina = panelMaquina;
        setLocationRelativeTo(null);
        txtIdMaquina.setVisible(false);
    }

    void setMaquina(Maquina mqn) {
        int id_maquina = mqn.getId_maquina();
        String maquina = mqn.getMaquina();

        // Configurar los valores en los campos de texto del formulario
        txtIdMaquina.setText(String.valueOf(id_maquina));
        txtMaquina.setText(maquina);
    }

    private void ActualizarMaquina() {
        if (txtMaquina.getText().trim().isEmpty()
                || txtIdMaquina.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        mqn.setMaquina(txtMaquina.getText().toUpperCase());
        mqn.setId_maquina(Integer.parseInt(txtIdMaquina.getText()));

        boolean actualizado = mDao.ModificarMaquina(mqn);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Máquina actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar maquina.");
        }
    }
}
