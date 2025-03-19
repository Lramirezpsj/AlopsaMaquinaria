package vistas;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDao;

/**
 *
 * @author ramir
 */
public class FrmSistema extends javax.swing.JFrame {

    FrmUsuario fUsuario = new FrmUsuario();
    UsuarioDao uDao = new UsuarioDao();
    DefaultTableModel modelo = new DefaultTableModel();

    public FrmSistema() {
        initComponents();     
        setLocationRelativeTo(null);
        PanelHorometros p2 = new PanelHorometros();
        p2.setSize(790, 560);
        p2.setLocation(0, 0);
        Content.removeAll();
        Content.add(p2, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnUsuarios = new javax.swing.JButton();
        btnMaquinas = new javax.swing.JButton();
        btnHorometros = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnContenedores = new javax.swing.JButton();
        btnSuministros = new javax.swing.JButton();
        btnTurnos = new javax.swing.JButton();
        btnMedidas = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        Content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alopsa PortaContenedores");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnMaquinas.setText("Máquinas");
        btnMaquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaquinasActionPerformed(evt);
            }
        });

        btnHorometros.setText("Horometros");
        btnHorometros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorometrosActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnContenedores.setText("Contenedores");
        btnContenedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContenedoresActionPerformed(evt);
            }
        });

        btnSuministros.setText("Suministros");
        btnSuministros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuministrosActionPerformed(evt);
            }
        });

        btnTurnos.setText("Turnos");
        btnTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnosActionPerformed(evt);
            }
        });

        btnMedidas.setText("Medidas");
        btnMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedidasActionPerformed(evt);
            }
        });

        btnMovimientos.setText("Movimientos");
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(btnMaquinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHorometros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContenedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuministros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnUsuarios)
                .addGap(18, 18, 18)
                .addComponent(btnHorometros)
                .addGap(18, 18, 18)
                .addComponent(btnMaquinas)
                .addGap(18, 18, 18)
                .addComponent(btnClientes)
                .addGap(18, 18, 18)
                .addComponent(btnContenedores)
                .addGap(18, 18, 18)
                .addComponent(btnSuministros)
                .addGap(18, 18, 18)
                .addComponent(btnTurnos)
                .addGap(18, 18, 18)
                .addComponent(btnMedidas)
                .addGap(18, 18, 18)
                .addComponent(btnMovimientos)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 570));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel1.add(Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 790, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

        PanelUsuarios p1 = new PanelUsuarios();
        p1.setSize(790, 560);
        p1.setLocation(0, 0);
        Content.removeAll();
        Content.add(p1, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnMaquinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaquinasActionPerformed
         PanelMaquinas p3 = new PanelMaquinas();
        p3.setSize(790, 560);
        p3.setLocation(0, 0);
        Content.removeAll();
        Content.add(p3, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_btnMaquinasActionPerformed

    private void btnHorometrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorometrosActionPerformed
        PanelHorometros p2 = new PanelHorometros();
        p2.setSize(790, 560);
        p2.setLocation(0, 0);
        Content.removeAll();
        Content.add(p2, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_btnHorometrosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        PanelClientes p4 = new PanelClientes();
        p4.setSize(790, 560);
        p4.setLocation(0, 0);
        Content.removeAll();
        Content.add(p4, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnContenedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContenedoresActionPerformed
        PanelContenedores p5 = new PanelContenedores();
        p5.setSize(790, 560);
        p5.setLocation(0, 0);
        Content.removeAll();
        Content.add(p5, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_btnContenedoresActionPerformed

    private void btnSuministrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuministrosActionPerformed
        PanelSuministros p6 = new PanelSuministros();
        p6.setSize(790, 560);
        p6.setLocation(0, 0);
        Content.removeAll();
        Content.add(p6, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_btnSuministrosActionPerformed

    private void btnTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnosActionPerformed
        PanelTurnos p7 = new PanelTurnos();
        p7.setSize(790, 560);
        p7.setLocation(0, 0);
        Content.removeAll();
        Content.add(p7, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_btnTurnosActionPerformed

    private void btnMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedidasActionPerformed
        PanelMedidas p8 = new PanelMedidas();
        p8.setSize(790, 560);
        p8.setLocation(0, 0);
        Content.removeAll();
        Content.add(p8, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_btnMedidasActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        PanelMovimientos p9 = new PanelMovimientos();
        p9.setSize(790, 560);
        p9.setLocation(0, 0);
        Content.removeAll();
        Content.add(p9, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_btnMovimientosActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnContenedores;
    private javax.swing.JButton btnHorometros;
    private javax.swing.JButton btnMaquinas;
    private javax.swing.JButton btnMedidas;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnSuministros;
    private javax.swing.JButton btnTurnos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    

    
}
