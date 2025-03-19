package vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Horometros;
import modelo.HorometrosDao;
import reportes.ExcelHorometros;
import reportes.PdfHorometros;

import com.toedter.calendar.JDateChooser;


/**
 *
 * @author ramir
 */
public class PanelHorometros extends javax.swing.JPanel {

    FrmHorometro fHorometro = new FrmHorometro();
    DefaultTableModel modelo = new DefaultTableModel();
    HorometrosDao hDao = new HorometrosDao();

    public PanelHorometros() {
        initComponents();
        listarHorometros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorometros = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnNuevoHorometro = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(790, 560));

        tblHorometros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id_Horrometro", "Fecha", "Máquina", "Cliente", "H-Inicio", "H-final", "Turno", "Comentarios", "Operador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHorometros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHorometrosMouseClicked(evt);
            }
        });
        tblHorometros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblHorometrosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblHorometros);
        if (tblHorometros.getColumnModel().getColumnCount() > 0) {
            tblHorometros.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblHorometros.getColumnModel().getColumn(1).setPreferredWidth(175);
            tblHorometros.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblHorometros.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblHorometros.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHorometros.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblHorometros.getColumnModel().getColumn(6).setPreferredWidth(50);
            tblHorometros.getColumnModel().getColumn(7).setPreferredWidth(300);
            tblHorometros.getColumnModel().getColumn(8).setPreferredWidth(200);
        }

        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Pdf");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnNuevoHorometro.setText("Nuevo");
        btnNuevoHorometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoHorometroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(77, 77, 77)
                        .addComponent(btnNuevoHorometro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(btnNuevoHorometro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoHorometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoHorometroActionPerformed
        FrmHorometro fHorometro = new FrmHorometro(this); // Pasar la referencia de FrmSistema
        fHorometro.setVisible(true);
        fHorometro.pack();
    }//GEN-LAST:event_btnNuevoHorometroActionPerformed

    private void tblHorometrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblHorometrosKeyPressed

    }//GEN-LAST:event_tblHorometrosKeyPressed

    private void tblHorometrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHorometrosMouseClicked
        if (evt.getClickCount() == 2) { // Verificar si fue un doble clic
            FrmHorometro fHorometro = new FrmHorometro(this); // Crear instancia del formulario

            // Obtener la fila seleccionada
            int fila = tblHorometros.rowAtPoint(evt.getPoint());

            // Verificar que la fila seleccionada sea válida
            if (fila >= 0 && fila < tblHorometros.getRowCount()) {
                // Obtener valores de las celdas
                int id_horometro = Integer.parseInt(String.valueOf(tblHorometros.getValueAt(fila, 0)));

                // Obtener la fecha como LocalDate directamente
                LocalDate fecha = (LocalDate) tblHorometros.getValueAt(fila, 1); // No es necesario convertir

                String maquina = String.valueOf(tblHorometros.getValueAt(fila, 2));
                String cliente = String.valueOf(tblHorometros.getValueAt(fila, 3));
                double h_inicio = Double.parseDouble(String.valueOf(tblHorometros.getValueAt(fila, 4)));
                double h_final = Double.parseDouble(String.valueOf(tblHorometros.getValueAt(fila, 5)));
                int turno = Integer.parseInt(String.valueOf(tblHorometros.getValueAt(fila, 6)));
                String comentarios = String.valueOf(tblHorometros.getValueAt(fila, 7));
                String operador = String.valueOf(tblHorometros.getValueAt(fila, 8));

                // Crear instancia de Horometros y configurar los valores
                Horometros hrs = new Horometros();
                hrs.setId_horometro(id_horometro);
                hrs.setFecha(fecha); // Asignar LocalDate directamente
                hrs.setMaquina(maquina);
                hrs.setCliente(cliente);
                hrs.setH_inicio(h_inicio);
                hrs.setH_final(h_final);
                hrs.setTurno(turno);
                hrs.setComentarios(comentarios);
                hrs.setOperador(operador);

                // Configurar los valores en el formulario
                fHorometro.setHorometro(hrs);

                // Mostrar el formulario (si ya estaba abierto, lo trae al frente)
                fHorometro.setVisible(true);
                fHorometro.toFront();
            }
        }
    }//GEN-LAST:event_tblHorometrosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
        if (pregunta == JOptionPane.YES_OPTION) {
            int filaSeleccionada = tblHorometros.getSelectedRow();
            if (filaSeleccionada != -1) {
                int id = (int) tblHorometros.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID está en la primera columna
                modelo.removeRow(filaSeleccionada); // Eliminar la fila de la tabla
                hDao.EliminarHorometro(id); // Llamar al método para eliminar la entrada de la base de datos
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una entrada para eliminar.");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ExcelHorometros.reporte(tblHorometros);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        PdfHorometros pdf = new PdfHorometros();
        pdf.generarPdf(tblHorometros);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarFechaHorometros();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoHorometro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHorometros;
    // End of variables declaration//GEN-END:variables

    public void listarHorometros() {
        List<Horometros> listarHrs = hDao.listarHorometros();
        Collections.sort(listarHrs, Comparator.comparing(Horometros::getId_horometro).reversed());
        modelo = (DefaultTableModel) tblHorometros.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblHorometros.setRowSorter(sorter);
        modelo.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas
        for (int i = 0; i < listarHrs.size(); i++) {
            Object[] obj = new Object[9];
            obj[0] = listarHrs.get(i).getId_horometro();
            obj[1] = listarHrs.get(i).getFecha();
            obj[2] = listarHrs.get(i).getMaquina();
            obj[3] = listarHrs.get(i).getCliente();
            obj[4] = listarHrs.get(i).getH_inicio();
            obj[5] = listarHrs.get(i).getH_final();
            obj[6] = listarHrs.get(i).getTurno();
            obj[7] = listarHrs.get(i).getComentarios();
            obj[8] = listarHrs.get(i).getOperador();
            modelo.addRow(obj);
        }
        tblHorometros.setModel(modelo); // Establecer el modelo después de agregar todas las filas
    }

    // Método para crear y configurar JDateChooser
    private JDateChooser createJDateChooser() {
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy/MM/d HH:mm"); // Formato completo
        return dateChooser;
    }

    public void buscarFechaHorometros() {
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
            HorometrosDao hDao = new HorometrosDao();
            List<Horometros> listaHorometros = hDao.buscarFecha(fechaInicio, fechaFin);

            // Obtener el modelo de la tabla y limpiarlo
            DefaultTableModel modelo = (DefaultTableModel) tblHorometros.getModel();
            modelo.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas

            // Agregar las filas correspondientes a la tabla
            for (Horometros horometros : listaHorometros) {
                modelo.addRow(new Object[]{
                    horometros.getId_horometro(),
                    horometros.getFecha(), // LocalDate
                    horometros.getMaquina(),
                    horometros.getCliente(),
                    horometros.getH_inicio(),
                    horometros.getH_final(),
                    horometros.getTurno(),
                    horometros.getComentarios(),
                    horometros.getOperador()
                });
            }

            // Establecer el nuevo modelo después de agregar todas las filas
            tblHorometros.setModel(modelo);
        }
    }
}
