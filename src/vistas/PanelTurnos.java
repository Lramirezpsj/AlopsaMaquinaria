package vistas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Turno;
import modelo.TurnoDao;

/**
 *
 * @author ramir
 */
public class PanelTurnos extends javax.swing.JPanel {

    Turno trn = new Turno();
    TurnoDao tDao = new TurnoDao();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public PanelTurnos() {
        initComponents();
        listarTurnos();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTurnos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        tblTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdTurno", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTurnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTurnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTurnos);
        if (tblTurnos.getColumnModel().getColumnCount() > 0) {
            tblTurnos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblTurnos.getColumnModel().getColumn(1).setPreferredWidth(75);
        }

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo)))
                .addContainerGap(518, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
        if (pregunta == JOptionPane.YES_OPTION) {
            int filaSeleccionada = tblTurnos.getSelectedRow();
            if (filaSeleccionada != -1) {
                int id = (int) tblTurnos.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID está en la primera columna
                modelo.removeRow(filaSeleccionada); // Eliminar la fila de la tabla
                tDao.EliminarTurno(id); // Llamar al método para eliminar la entrada de la base de datos
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona un turno para eliminar.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurnosMouseClicked
         if (evt.getClickCount() == 2) { // Verificar si fue un doble clic
            FrmTurnos fTurno = new FrmTurnos(this); // Crear instancia del formulario

            // Obtener la fila seleccionada
            int fila = tblTurnos.rowAtPoint(evt.getPoint());

            // Verificar que la fila seleccionada sea válida
            if (fila >= 0 && fila < tblTurnos.getRowCount()) {
                // Obtener valores de las celdas
                int id_turno = Integer.parseInt(String.valueOf(tblTurnos.getValueAt(fila, 0)));

                int turno = Integer.parseInt(String.valueOf(tblTurnos.getValueAt(fila, 1)));

                // Crear instancia de Horometros y configurar los valores
                Turno trn = new Turno();
                trn.setId_turno(id_turno);
                trn.setTurno(turno);

                // Configurar los valores en el formulario
                fTurno.setTurno(trn);

                // Mostrar el formulario (si ya estaba abierto, lo trae al frente)
                fTurno.setVisible(true);
                fTurno.toFront();
            }
        }
    }//GEN-LAST:event_tblTurnosMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        FrmTurnos fTurno = new FrmTurnos(this);
        fTurno.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTurnos;
    // End of variables declaration//GEN-END:variables

public void listarTurnos() {
        List<Turno> listarTrn = tDao.listarTurno();
        Collections.sort(listarTrn, Comparator.comparing(Turno::getId_turno).reversed());
        modelo = (DefaultTableModel) tblTurnos.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblTurnos.setRowSorter(sorter);
        modelo.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas
        for (int i = 0; i < listarTrn.size(); i++) {
            Object[] obj = new Object[2];
            obj[0] = listarTrn.get(i).getId_turno();
            obj[1] = listarTrn.get(i).getTurno();
            modelo.addRow(obj);
        }
        tblTurnos.setModel(modelo); // Establecer el modelo después de agregar todas las filas
    }
}
