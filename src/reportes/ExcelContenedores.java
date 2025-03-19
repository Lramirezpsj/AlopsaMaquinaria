
package reportes;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ramir
 */
public class ExcelContenedores {
    
    public static void reporte(JTable table) {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Contenedores");

        try {
            // Crear fila para las cabeceras
            Row filaEncabezados = sheet.createRow(0);

            // Obtener el modelo de tabla de la tabla filtrada
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) table.getRowSorter();
            TableModel model = table.getModel();
            TableModel filteredModel = sorter.getModel();

            // Agregar las cabeceras a la fila
            for (int i = 0; i < filteredModel.getColumnCount(); i++) {
                Cell celdaEncabezado = filaEncabezados.createCell(i);
                celdaEncabezado.setCellValue(filteredModel.getColumnName(i)); // Usar el nombre de la columna del modelo de tabla filtrada
            }

            // Agregar los datos filtrados de la tabla al libro de trabajo
            for (int row = 0; row < filteredModel.getRowCount(); row++) {
                Row filaDatos = sheet.createRow(row + 1);
                for (int col = 0; col < filteredModel.getColumnCount(); col++) {
                    Cell celdaDatos = filaDatos.createCell(col);
                    Object value = filteredModel.getValueAt(row, col);
                    if (value != null) {
                        if (value instanceof Number) {
                            celdaDatos.setCellValue(((Number) value).doubleValue());
                        } else if (value instanceof Boolean) {
                            celdaDatos.setCellValue((Boolean) value);
                        } else {
                            celdaDatos.setCellValue(value.toString());
                        }
                    }
                }
            }

            // Ajustar el tamaño de las columnas para adaptarse al contenido
            for (int i = 0; i < filteredModel.getColumnCount(); i++) {
                sheet.autoSizeColumn(i);
            }

            // Guardar el archivo de ExcelIngreso en la carpeta de descargas del usuario
            String fileName = "Contenedores";
            String home = System.getProperty("user.home");
            File file = new File(home + "/Documents/" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            book.write(fileOut);
            fileOut.close();

            // Abrir el archivo ExcelIngreso generado
            Desktop.getDesktop().open(file);

            // Mostrar un mensaje de confirmación al usuario
            JOptionPane.showMessageDialog(null, "Reporte Generado");

        } catch (IOException ex) {
            Logger.getLogger(ExcelUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
