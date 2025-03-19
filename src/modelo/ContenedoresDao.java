
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ramir
 */
public class ContenedoresDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public boolean contenedores(Contenedores contenedores) {
        String sql = "INSERT INTO contenedores (fecha, maquina, contenedor, medida, movimiento, comentarios, operador) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Convertir LocalDate a java.sql.Date
            LocalDate fechaLocalDate = contenedores.getFecha();
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaLocalDate);

            // Asignar los valores a los parámetros de la consulta
            ps.setDate(1, fechaSQL); // Usar setDate en lugar de setTimestamp
            ps.setString(2, contenedores.getMaquina());
            ps.setString(3, contenedores.getContenedor());
            ps.setString(4, contenedores.getMedida());
            ps.setString(5, contenedores.getMovimiento());
            ps.setString(6, contenedores.getComentarios());
            ps.setString(7, contenedores.getOperador());

            // Ejecutar la consulta
            ps.executeUpdate();
            return true; // Retornar true si la inserción fue exitosa
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el contenedor: " + e.toString());
            return false; // Retornar false si ocurrió un error
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cerrar la conexión
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.toString());
            }
        }
    }

    public List<Contenedores> listarContenedores() {
        List<Contenedores> listarCont = new ArrayList<>();
        String sql = "SELECT * FROM contenedores"; // Consulta SQL para obtener todos los horómetros

        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // Ejecutar la consulta

            // Recorrer el resultado de la consulta
            while (rs.next()) {
                Contenedores cont = new Contenedores();
                cont.setId_contenedor(rs.getInt("id_contenedor"));

                // Convertir java.sql.Date a LocalDate
                java.sql.Date fechaSQL = rs.getDate("fecha");
                LocalDate fecha = (fechaSQL != null) ? fechaSQL.toLocalDate() : null;
                cont.setFecha(fecha); // Asignar LocalDate

                cont.setMaquina(rs.getString("maquina"));
                cont.setContenedor(rs.getString("contenedor"));
                cont.setMedida(rs.getString("medida"));
                cont.setMovimiento(rs.getString("movimiento"));
                cont.setComentarios(rs.getString("comentarios"));
                cont.setOperador(rs.getString("operador"));

                listarCont.add(cont); // Agregar el horómetro a la lista
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar contenedor: " + e.toString());
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.toString());
            }
        }
        return listarCont; // Retornar la lista de horómetros
    }

    public boolean ModificarContenedor(Contenedores cont) {
        String sql = "UPDATE contenedores SET fecha = ?, maquina = ?, contenedor = ?, medida = ?, movimiento = ?, comentarios = ?, operador = ? WHERE id_contenedor = ?";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Convertir LocalDate a java.sql.Date
            LocalDate fechaLocalDate = cont.getFecha();
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaLocalDate);

            // Asignar los valores a los parámetros de la consulta
            ps.setDate(1, fechaSQL); // Usar setDate en lugar de setTimestamp
            ps.setString(2, cont.getMaquina());
            ps.setString(3, cont.getContenedor());
            ps.setString(4, cont.getMedida());
            ps.setString(5, cont.getMovimiento());
            ps.setString(6, cont.getComentarios());
            ps.setString(7, cont.getOperador());
            ps.setInt(8, cont.getId_contenedor()); // ID del horómetro a modificar

            // Ejecutar la actualización
            ps.executeUpdate();
            return true; // Retornar true si la actualización fue exitosa
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el contenedor: " + e.toString());
            return false; // Retornar false si ocurrió un error
        } finally {
            // Cerrar la conexión
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.toString());
            }
        }
    }

    public boolean EliminarContenedor(int id) {
        String sql = "delete from contenedores where id_contenedor=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }

    }

    // Método en HorometrosDao para buscar por rango de fechas
    public List<Contenedores> buscarFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Contenedores> listaContenedores = new ArrayList<>();
        String sql = "SELECT * FROM contenedores WHERE fecha BETWEEN ? AND ?";

        try (Connection con = cn.Conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Convertir LocalDate a java.sql.Date
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(fechaInicio);
            java.sql.Date fechaFinSQL = java.sql.Date.valueOf(fechaFin);

            ps.setDate(1, fechaInicioSQL);
            ps.setDate(2, fechaFinSQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Contenedores contenedores = new Contenedores();
                contenedores.setId_contenedor(rs.getInt("id_contenedor"));

                // Convertir java.sql.Date a LocalDate
                java.sql.Date fechaSQL = rs.getDate("fecha");
                LocalDate fecha = (fechaSQL != null) ? fechaSQL.toLocalDate() : null;
                contenedores.setFecha(fecha); // Asignar LocalDate

                contenedores.setMaquina(rs.getString("maquina"));
                contenedores.setContenedor(rs.getString("contenedor"));
                contenedores.setMedida(rs.getString("medida"));
                contenedores.setMovimiento(rs.getString("movimiento"));
                contenedores.setComentarios(rs.getString("comentarios"));
                contenedores.setOperador(rs.getString("operador"));
                listaContenedores.add(contenedores);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaContenedores;
    }

}
