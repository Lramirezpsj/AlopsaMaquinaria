package reportes;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;

public class PdfHorometros {

    public void generarPdf(JTable tblHorometros) {
        FileOutputStream archivo = null;
        try {
            File file = new File("src/reportes/horometro.pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            // Imagen del logo
            Image img = Image.getInstance("src/img/Alopsa.png");

            // Formato de fecha
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaActual = new Date();

            // Datos de la fila seleccionada
            int filaSeleccionada = tblHorometros.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila.");
                return;
            }

            // Imagen
            img.scaleToFit(250, 250);
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);

            String empresa = "Asistencia y logistica porturaria";
            String id = tblHorometros.getValueAt(filaSeleccionada, 0).toString();
            String fecha = tblHorometros.getValueAt(filaSeleccionada, 1).toString();
            String maquina = tblHorometros.getValueAt(filaSeleccionada, 2).toString();
            String cliente = tblHorometros.getValueAt(filaSeleccionada, 3).toString();
            String hInicio = tblHorometros.getValueAt(filaSeleccionada, 4).toString();
            String hFinal = tblHorometros.getValueAt(filaSeleccionada, 5).toString();
            String turno = tblHorometros.getValueAt(filaSeleccionada, 6).toString();
            String comentarios = tblHorometros.getValueAt(filaSeleccionada, 7).toString();
            String operador = tblHorometros.getValueAt(filaSeleccionada, 8).toString();

            // Encabezado del PDF
            /*PdfPTable encabezado = new PdfPTable(2);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            encabezado.setWidths(new float[]{50f, 50f});

            encabezado.addCell("LOGO DE LA EMPRESA");
            encabezado.addCell(empresa + "\nFecha: " + sdf.format(fechaActual) + "\nID: " + id);
            doc.add(encabezado);*/
            // Título
            Paragraph titulo = new Paragraph("Datos del Horómetro", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLUE));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.add(Chunk.NEWLINE);
            doc.add(titulo);

            // Agregar detalles del registro
            doc.add(new Paragraph("No. de registro: " + tblHorometros.getValueAt(filaSeleccionada, 0).toString()));
            doc.add(new Paragraph("Fecha: " + tblHorometros.getValueAt(filaSeleccionada, 1).toString()));
            doc.add(new Paragraph("Máquina: " + tblHorometros.getValueAt(filaSeleccionada, 2).toString()));
            doc.add(new Paragraph("Turno: " + tblHorometros.getValueAt(filaSeleccionada, 6).toString()));
            doc.add(new Paragraph("Operador: " + tblHorometros.getValueAt(filaSeleccionada, 8).toString()));
            doc.add(new Paragraph("Comentarios: " + tblHorometros.getValueAt(filaSeleccionada, 7).toString()));
            doc.add(new Paragraph(" "));

            // Crear tabla
            BaseColor azulCosmo = new BaseColor(52, 152, 219);
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{15f, 15f, 20f});

            // Encabezados
            agregarCeldaEncabezado(tabla, "Inicio:", azulCosmo);
            agregarCeldaEncabezado(tabla, "Final:", azulCosmo);
            agregarCeldaEncabezado(tabla, "Total en horas", azulCosmo);

            double hInicio1 = obtenerValorDouble(hInicio);
            double hFinal1 = obtenerValorDouble(hFinal);
            double diferencia = hFinal1 - hInicio1;
            int horas = (int) diferencia;
            int minutos = (int) ((diferencia - horas) * 60);
            String resultado = String.format("%02d:%02d", horas, minutos);

            tabla.addCell(hInicio);
            tabla.addCell(hFinal);
            tabla.addCell(resultado);

            doc.add(tabla);

            /*// Comentarios
            Paragraph comentario = new Paragraph("Comentarios: " + comentarios, new Font(Font.FontFamily.TIMES_ROMAN, 12));
            comentario.add(Chunk.NEWLINE);
            doc.add(comentario);*/

            doc.close();

            // Abrir el PDF automáticamente
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (archivo != null) {
                    archivo.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void agregarCeldaEncabezado(PdfPTable tabla, String texto, BaseColor color) {
        PdfPCell celda = new PdfPCell(new Phrase(texto));
        celda.setBackgroundColor(color);
        celda.setBorder(com.itextpdf.text.Rectangle.BOX);
        tabla.addCell(celda);
    }
    
    private double obtenerValorDouble(String valor) {
        try {
            return valor != null && !valor.isEmpty() ? Double.parseDouble(valor) : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
