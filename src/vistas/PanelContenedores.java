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
import modelo.Contenedores;
import modelo.ContenedoresDao;
import reportes.ExcelContenedores;

/**
 *
 * @author ramir
 */
public class PanelContenedores extends javax.swing.JPanel {
    
    ContenedoresDao cDao= new ContenedoresDao();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public PanelContenedores() {
        initComponents();
        listarContenedores();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblContenedores = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(790, 560));

        tblContenedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdContenedor", "Fecha", "Maquina", "Contenedor", "Medida", "Movimiento", "Comentarios", "Operador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContenedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContenedoresMouseClicked(evt);
            }
        });
        tblContenedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblContenedoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblContenedores);
        if (tblContenedores.getColumnModel().getColumnCount() > 0) {
            tblContenedores.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblContenedores.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblContenedores.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblContenedores.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblContenedores.getColumnModel().getColumn(4).setPreferredWidth(75);
            tblContenedores.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblContenedores.getColumnModel().getColumn(6).setPreferredWidth(225);
            tblContenedores.getColumnModel().getColumn(7).setPreferredWidth(100);
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

        btnExcel.setText("Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnFiltrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcel)
                        .addGap(134, 134, 134)
                        .addComponent(btnNuevo)
                        .addGap(0, 254, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrar)
                    .addComponent(btnEliminar)
                    .addComponent(btnExcel)
                    .addComponent(btnNuevo))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        FrmContenedores fContenedores = new FrmContenedores(this); // Pasar la referencia de FrmSistema
        fContenedores.setVisible(true);
        fContenedores.pack();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tblContenedoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblContenedoresKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblContenedoresKeyPressed

    private void tblContenedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContenedoresMouseClicked
       if (evt.getClickCount() == 2) { // Verificar si fue un doble clic
            FrmContenedores fContenedores = new FrmContenedores(this); // Crear instancia del formulario

            // Obtener la fila seleccionada
            int fila = tblContenedores.rowAtPoint(evt.getPoint());

            // Verificar que la fila seleccionada sea válida
            if (fila >= 0 && fila < tblContenedores.getRowCount()) {
                // Obtener valores de las celdas
                int id_contenedor = Integer.parseInt(String.valueOf(tblContenedores.getValueAt(fila, 0)));

                // Obtener la fecha como LocalDate directamente
                LocalDate fecha = (LocalDate) tblContenedores.getValueAt(fila, 1); // No es necesario convertir

                String maquina = String.valueOf(tblContenedores.getValueAt(fila, 2));
                String contenedor = String.valueOf(tblContenedores.getValueAt(fila, 3));
                String medida = String.valueOf(tblContenedores.getValueAt(fila, 4));
                String movimiento = String.valueOf(tblContenedores.getValueAt(fila, 5));
                String comentarios = String.valueOf(tblContenedores.getValueAt(fila, 6));
                String operador = String.valueOf(tblContenedores.getValueAt(fila, 7));

                // Crear instancia de Horometros y configurar los valores
                Contenedores cont = new Contenedores();
                cont.setId_contenedor(id_contenedor);
                cont.setFecha(fecha); // Asignar LocalDate directamente
                cont.setMaquina(maquina);
                cont.setContenedor(contenedor);
                cont.setMedida(medida);
                cont.setMovimiento(movimiento);
                cont.setComentarios(comentarios);
                cont.setOperador(operador);

                // Configurar los valores en el formulario
                fContenedores.setContenedor(cont);

                // Mostrar el formulario (si ya estaba abierto, lo trae al frente)
                fContenedores.setVisible(true);
                fContenedores.toFront();
            }
        }
    }//GEN-LAST:event_tblContenedoresMouseClicked

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        buscarFechaContenedores();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
        if (pregunta == JOptionPane.YES_OPTION) {
            int filaSeleccionada = tblContenedores.getSelectedRow();
            if (filaSeleccionada != -1) {
                int id = (int) tblContenedores.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID está en la primera columna
                modelo.removeRow(filaSeleccionada); // Eliminar la fila de la tabla
                cDao.EliminarContenedor(id); // Llamar al método para eliminar la entrada de la base de datos
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una entrada para eliminar.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        ExcelContenedores.reporte(tblContenedores);
    }//GEN-LAST:event_btnExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContenedores;
    // End of variables declaration//GEN-END:variables

public void listarContenedores() {
        List<Contenedores> listarCont = cDao.listarContenedores();
        Collections.sort(listarCont, Comparator.comparing(Contenedores::getId_contenedor).reversed());
        modelo = (DefaultTableModel) tblContenedores.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblContenedores.setRowSorter(sorter);
        modelo.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas
        for (int i = 0; i < listarCont.size(); i++) {
            Object[] obj = new Object[8];
            obj[0] = listarCont.get(i).getId_contenedor();
            obj[1] = listarCont.get(i).getFecha();
            obj[2] = listarCont.get(i).getMaquina();
            obj[3] = listarCont.get(i).getContenedor();
            obj[4] = listarCont.get(i).getMedida();
            obj[5] = listarCont.get(i).getMovimiento();
            obj[6] = listarCont.get(i).getComentarios();
            obj[7] = listarCont.get(i).getOperador();
            modelo.addRow(obj);
        }
        tblContenedores.setModel(modelo); // Establecer el modelo después de agregar todas las filas
    }

    // Método para crear y configurar JDateChooser
    private JDateChooser createJDateChooser() {
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy/MM/d HH:mm"); // Formato completo
        return dateChooser;
    }

    public void buscarFechaContenedores() {
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
            ContenedoresDao cDao = new ContenedoresDao();
            List<Contenedores> listaContenedores = cDao.buscarFecha(fechaInicio, fechaFin);

            // Obtener el modelo de la tabla y limpiarlo
            DefaultTableModel modelo = (DefaultTableModel) tblContenedores.getModel();
            modelo.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas

            // Agregar las filas correspondientes a la tabla
            for (Contenedores contenedores : listaContenedores) {
                modelo.addRow(new Object[]{
                    contenedores.getId_contenedor(),
                    contenedores.getFecha(), // LocalDate
                    contenedores.getMaquina(),
                    contenedores.getContenedor(),
                    contenedores.getMedida(),
                    contenedores.getMovimiento(),
                    contenedores.getComentarios(),
                    contenedores.getOperador()
                });
            }

            // Establecer el nuevo modelo después de agregar todas las filas
            tblContenedores.setModel(modelo);
        }
    }
}
