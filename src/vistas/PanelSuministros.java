
package vistas;

import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Horometros;
import modelo.Suministros;
import modelo.SuministrosDao;
import reportes.ExcelSuministros;

/**
 *
 * @author ramir
 */
public class PanelSuministros extends javax.swing.JPanel {

    SuministrosDao sDao= new SuministrosDao();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public PanelSuministros() {
        initComponents();
        listarSuministros();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuministros = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        BtnExcel = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        tblSuministros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "IdSuministro", "Fecha", "Máquina", "Hormetro", "Total", "Comentarios", "Operador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSuministros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSuministrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSuministros);
        if (tblSuministros.getColumnModel().getColumnCount() > 0) {
            tblSuministros.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblSuministros.getColumnModel().getColumn(1).setPreferredWidth(175);
            tblSuministros.getColumnModel().getColumn(2).setPreferredWidth(175);
            tblSuministros.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblSuministros.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblSuministros.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblSuministros.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        BtnExcel.setText("Excel");
        BtnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcelActionPerformed(evt);
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
                        .addGap(116, 116, 116)
                        .addComponent(btnFiltrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnExcel)
                        .addGap(57, 57, 57)
                        .addComponent(btnNuevo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrar)
                    .addComponent(btnEliminar)
                    .addComponent(BtnExcel)
                    .addComponent(btnNuevo))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
        if (pregunta == JOptionPane.YES_OPTION) {
            int filaSeleccionada = tblSuministros.getSelectedRow();
            if (filaSeleccionada != -1) {
                int id = (int) tblSuministros.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID está en la primera columna
                modelo.removeRow(filaSeleccionada); // Eliminar la fila de la tabla
                sDao.EliminarSuministro(id); // Llamar al método para eliminar la entrada de la base de datos
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una entrada para eliminar.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        buscarFechaSuministros();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void BtnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcelActionPerformed
        ExcelSuministros.reporte(tblSuministros);
    }//GEN-LAST:event_BtnExcelActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        FrmSuministros fSuministros = new FrmSuministros(this); // Pasar la referencia de FrmSistema
        fSuministros.setVisible(true);
        fSuministros.pack();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tblSuministrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuministrosMouseClicked
        if (evt.getClickCount() == 2) { // Verificar si fue un doble clic
            FrmSuministros fSuministros = new FrmSuministros(this); // Crear instancia del formulario

            // Obtener la fila seleccionada
            int fila = tblSuministros.rowAtPoint(evt.getPoint());

            // Verificar que la fila seleccionada sea válida
            if (fila >= 0 && fila < tblSuministros.getRowCount()) {
                // Obtener valores de las celdas
                int id_suministro = Integer.parseInt(String.valueOf(tblSuministros.getValueAt(fila, 0)));

                // Obtener la fecha como LocalDate directamente
                LocalDate fecha = (LocalDate) tblSuministros.getValueAt(fila, 1); // No es necesario convertir

                String maquina = String.valueOf(tblSuministros.getValueAt(fila, 2));
                double horometro = Double.parseDouble(String.valueOf(tblSuministros.getValueAt(fila, 3)));
                double total = Double.parseDouble(String.valueOf(tblSuministros.getValueAt(fila, 4)));
                String comentarios = String.valueOf(tblSuministros.getValueAt(fila, 5));
                String operador = String.valueOf(tblSuministros.getValueAt(fila, 6));

                // Crear instancia de Horometros y configurar los valores
                Suministros sum = new Suministros();
                sum.setId_suministro(id_suministro);
                sum.setFecha(fecha); // Asignar LocalDate directamente
                sum.setMaquina(maquina);
                sum.setHorometro(horometro);
                sum.setTotal(total);
                sum.setComentarios(comentarios);
                sum.setOperador(operador);

                // Configurar los valores en el formulario
                fSuministros.setSuministro(sum);

                // Mostrar el formulario (si ya estaba abierto, lo trae al frente)
                fSuministros.setVisible(true);
                fSuministros.toFront();
            }
        }
    }//GEN-LAST:event_tblSuministrosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExcel;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSuministros;
    // End of variables declaration//GEN-END:variables

public void listarSuministros() {
        List<Suministros> listarSum = sDao.listarSumistros();
        Collections.sort(listarSum, Comparator.comparing(Suministros::getId_suministro).reversed());
        modelo = (DefaultTableModel) tblSuministros.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblSuministros.setRowSorter(sorter);
        modelo.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas
        for (int i = 0; i < listarSum.size(); i++) {
            Object[] obj = new Object[7];
            obj[0] = listarSum.get(i).getId_suministro();
            obj[1] = listarSum.get(i).getFecha();
            obj[2] = listarSum.get(i).getMaquina();
            obj[3] = listarSum.get(i).getHorometro();
            obj[4] = listarSum.get(i).getTotal();
            obj[5] = listarSum.get(i).getComentarios();
            obj[6] = listarSum.get(i).getOperador();
            modelo.addRow(obj);
        }
        tblSuministros.setModel(modelo); // Establecer el modelo después de agregar todas las filas
    }

    // Método para crear y configurar JDateChooser
    private JDateChooser createJDateChooser() {
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy/MM/d HH:mm"); // Formato completo
        return dateChooser;
    }

    public void buscarFechaSuministros() {
        // Crear y configurar JDateChooser para la fecha de inicio
        JDateChooser fechaInicioChooser = createJDateChooser();
        // Crear y configurar JDateChooser para la fecha de fin
        JDateChooser fechaFinChooser = createJDateChooser();

        // Mostrar cuadro de diálogo para seleccionar la fecha de inicio
        int resultadoInicio = JOptionPane.showConfirmDialog(null, fechaInicioChooser, "Seleccione la fecha de inicio", JOptionPane.OK_CANCEL_OPTION);
        // Mostrar cuadro de diálogo para seleccionar la fecha de fin
        int resultadoFin = JOptionPane.showConfirmDialog(null, fechaFinChooser, "Seleccione la fecha de fin", JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se seleccionaron ambas fechas
        if (resultadoInicio == JOptionPane.OK_OPTION && resultadoFin == JOptionPane.OK_OPTION) {
            // Obtener la fecha seleccionada de los JDateChooser y convertir a LocalDate
            LocalDate fechaInicio = fechaInicioChooser.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate fechaFin = fechaFinChooser.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            // Validar que la fecha de inicio no sea posterior a la fecha de fin
            if (fechaInicio.isAfter(fechaFin)) {
                JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser anterior o igual a la fecha de fin", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Realizar la búsqueda utilizando las fechas seleccionadas
            SuministrosDao sDao = new SuministrosDao();
            List<Suministros> listaSuministros = sDao.buscarFecha(fechaInicio, fechaFin);

            // Obtener el modelo de la tabla y limpiarlo
            DefaultTableModel modelo = (DefaultTableModel) tblSuministros.getModel();
            modelo.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas

            // Agregar las filas correspondientes a la tabla
            for (Suministros suministros : listaSuministros) {
                modelo.addRow(new Object[]{
                    suministros.getId_suministro(),
                    suministros.getFecha(), // LocalDate
                    suministros.getMaquina(),
                    suministros.getHorometro(),
                    suministros.getTotal(),
                    suministros.getComentarios(),
                    suministros.getOperador()
                });
            }

            // Establecer el nuevo modelo después de agregar todas las filas
            tblSuministros.setModel(modelo);
        }
    }
}
