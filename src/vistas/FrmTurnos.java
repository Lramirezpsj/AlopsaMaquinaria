package vistas;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.Turno;
import modelo.TurnoDao;

/**
 *
 * @author ramir
 */
public class FrmTurnos extends javax.swing.JFrame {

    Turno trn = new Turno();
    TurnoDao tDao = new TurnoDao();
    private PanelTurnos panelTurnos;

    public FrmTurnos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtIdTurno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Turno:");

        txtTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTurnoKeyPressed(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTurno)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtIdTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        turno();
        limpiarTurno();
        if (panelTurnos != null) {
            panelTurnos.listarTurnos();// Actualiza la tabla con los nuevos datos
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        actualizarTurno();
        limpiarTurno();
        if (panelTurnos != null) {
            panelTurnos.listarTurnos();// Actualiza la tabla con los nuevos datos
        }
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTurnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTurnoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            turno();
            limpiarTurno();
            if (panelTurnos != null) {
                panelTurnos.listarTurnos();// Actualiza la tabla con los nuevos datos
            }
        }
    }//GEN-LAST:event_txtTurnoKeyPressed

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
            java.util.logging.Logger.getLogger(FrmTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTurnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtIdTurno;
    private javax.swing.JTextField txtTurno;
    // End of variables declaration//GEN-END:variables

    private void turno() {

        int turno = Integer.parseInt(txtTurno.getText());

        trn.setTurno(turno);
        tDao.turno(trn);
    }

    private void limpiarTurno() {
        txtIdTurno.setText("");
        txtTurno.setText("");

        txtTurno.requestFocus();
    }

    public FrmTurnos(PanelTurnos panelTurnos) {
        initComponents();
        this.panelTurnos = panelTurnos;
        setLocationRelativeTo(null);
        txtIdTurno.setVisible(false);
    }

    void setTurno(Turno trn) {
        int id_turno = trn.getId_turno();
        int turno = trn.getTurno();

        // Configurar los valores en los campos de texto del formulario
        txtIdTurno.setText(String.valueOf(id_turno));
        txtTurno.setText(String.valueOf(turno));
    }

    private void actualizarTurno() {
        if (txtTurno.getText().trim().isEmpty()
                || txtIdTurno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        trn.setTurno(Integer.parseInt(txtTurno.getText()));
        trn.setId_turno(Integer.parseInt(txtIdTurno.getText()));

        boolean actualizado = tDao.ModificarTurno(trn);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Turno actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar turno.");
        }
    }
}
