package vistas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Medidas;
import modelo.MedidasDao;

/**
 *
 * @author ramir
 */
public class PanelMedidas extends javax.swing.JPanel {

    MedidasDao mdsDao = new MedidasDao();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public PanelMedidas() {
        initComponents();
        listarMedidas();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedidas = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        tblMedidas.setModel(new javax.swing.table.DefaultTableModel(
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
                "IdMedida", "Medida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMedidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMedidas);
        if (tblMedidas.getColumnModel().getColumnCount() > 0) {
            tblMedidas.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblMedidas.getColumnModel().getColumn(1).setPreferredWidth(100);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo)))
                .addContainerGap(505, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
        if (pregunta == JOptionPane.YES_OPTION) {
            int filaSeleccionada = tblMedidas.getSelectedRow();
            if (filaSeleccionada != -1) {
                int id = (int) tblMedidas.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID está en la primera columna
                modelo.removeRow(filaSeleccionada); // Eliminar la fila de la tabla
                mdsDao.EliminarMedida(id); // Llamar al método para eliminar la entrada de la base de datos
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona un turno para eliminar.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        FrmMedidas fMedida = new FrmMedidas(this);
        fMedida.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tblMedidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedidasMouseClicked
        if (evt.getClickCount() == 2) { // Verificar si fue un doble clic
            FrmMedidas fMedida = new FrmMedidas(this); // Crear instancia del formulario

            // Obtener la fila seleccionada
            int fila = tblMedidas.rowAtPoint(evt.getPoint());

            // Verificar que la fila seleccionada sea válida
            if (fila >= 0 && fila < tblMedidas.getRowCount()) {
                // Obtener valores de las celdas
                int id_medida = Integer.parseInt(String.valueOf(tblMedidas.getValueAt(fila, 0)));

                String medida = String.valueOf(tblMedidas.getValueAt(fila, 1));

                // Crear instancia de Horometros y configurar los valores
                Medidas mds = new Medidas();
                mds.setId_medida(id_medida);
                mds.setMedida(medida);

                // Configurar los valores en el formulario
                fMedida.setMedida(mds);

                // Mostrar el formulario (si ya estaba abierto, lo trae al frente)
                fMedida.setVisible(true);
                fMedida.toFront();
            }
        }
    }//GEN-LAST:event_tblMedidasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedidas;
    // End of variables declaration//GEN-END:variables

public void listarMedidas() {
        List<Medidas> listarMds = mdsDao.listarMedidas();
        Collections.sort(listarMds, Comparator.comparing(Medidas::getId_medida).reversed());
        modelo = (DefaultTableModel) tblMedidas.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblMedidas.setRowSorter(sorter);
        modelo.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas
        for (int i = 0; i < listarMds.size(); i++) {
            Object[] obj = new Object[2];
            obj[0] = listarMds.get(i).getId_medida();
            obj[1] = listarMds.get(i).getMedida();
            modelo.addRow(obj);
        }
        tblMedidas.setModel(modelo); // Establecer el modelo después de agregar todas las filas
    }
}
