package vistas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Medidas;
import modelo.Movimientos;
import modelo.MovimientosDao;

/**
 *
 * @author ramir
 */
public class PanelMovimientos extends javax.swing.JPanel {
    
    MovimientosDao movDao = new MovimientosDao();
    DefaultTableModel modelo = new DefaultTableModel();

    
    public PanelMovimientos() {
        initComponents();
        listarMovimientos();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovimientos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(790, 560));

        tblMovimientos.setModel(new javax.swing.table.DefaultTableModel(
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
                "IdMovimiento", "Movimientos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMovimientosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMovimientos);
        if (tblMovimientos.getColumnModel().getColumnCount() > 0) {
            tblMovimientos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblMovimientos.getColumnModel().getColumn(1).setPreferredWidth(100);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo)))
                .addContainerGap(498, Short.MAX_VALUE))
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
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
        if (pregunta == JOptionPane.YES_OPTION) {
            int filaSeleccionada = tblMovimientos.getSelectedRow();
            if (filaSeleccionada != -1) {
                int id = (int) tblMovimientos.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID está en la primera columna
                modelo.removeRow(filaSeleccionada); // Eliminar la fila de la tabla
                movDao.EliminarMovimiento(id); // Llamar al método para eliminar la entrada de la base de datos
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una máquina para eliminar.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
       FrmMovimientos fMovimientos = new FrmMovimientos(this);
        fMovimientos.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tblMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovimientosMouseClicked
        if (evt.getClickCount() == 2) { // Verificar si fue un doble clic
            FrmMovimientos fMovimiento = new FrmMovimientos(this); // Crear instancia del formulario

            // Obtener la fila seleccionada
            int fila = tblMovimientos.rowAtPoint(evt.getPoint());

            // Verificar que la fila seleccionada sea válida
            if (fila >= 0 && fila < tblMovimientos.getRowCount()) {
                // Obtener valores de las celdas
                int id_movimiento = Integer.parseInt(String.valueOf(tblMovimientos.getValueAt(fila, 0)));

                String movimiento = String.valueOf(tblMovimientos.getValueAt(fila, 1));

                // Crear instancia de Horometros y configurar los valores
                Movimientos mov = new Movimientos();
                mov.setId_movimiento(id_movimiento);
                mov.setMovimiento(movimiento);

                // Configurar los valores en el formulario
                fMovimiento.setMovimiento(mov);

                // Mostrar el formulario (si ya estaba abierto, lo trae al frente)
                fMovimiento.setVisible(true);
                fMovimiento.toFront();
            }
        }
    }//GEN-LAST:event_tblMovimientosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMovimientos;
    // End of variables declaration//GEN-END:variables

public void listarMovimientos() {
        List<Movimientos> listarMov = movDao.listarMovimientos();
        Collections.sort(listarMov, Comparator.comparing(Movimientos::getId_movimiento).reversed());
        modelo = (DefaultTableModel) tblMovimientos.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblMovimientos.setRowSorter(sorter);
        modelo.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas
        for (int i = 0; i < listarMov.size(); i++) {
            Object[] obj = new Object[2];
            obj[0] = listarMov.get(i).getId_movimiento();
            obj[1] = listarMov.get(i).getMovimiento();
            modelo.addRow(obj);
        }
        tblMovimientos.setModel(modelo); // Establecer el modelo después de agregar todas las filas
    }
}
