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
public class HorometrosDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public boolean horometros(Horometros horometro) {
        String sql = "INSERT INTO horometros (fecha, maquina, cliente, h_inicio, h_final, turno, comentarios, operador) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Convertir LocalDate a java.sql.Date
            LocalDate fechaLocalDate = horometro.getFecha();
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaLocalDate);

            // Asignar los valores a los parámetros de la consulta
            ps.setDate(1, fechaSQL); // Usar setDate en lugar de setTimestamp
            ps.setString(2, horometro.getMaquina());
            ps.setString(3, horometro.getCliente());
            ps.setDouble(4, horometro.getH_inicio());
            ps.setDouble(5, horometro.getH_final());
            ps.setInt(6, horometro.getTurno());
            ps.setString(7, horometro.getComentarios());
            ps.setString(8, horometro.getOperador());

            // Ejecutar la consulta
            ps.executeUpdate();
            return true; // Retornar true si la inserción fue exitosa
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el horómetro: " + e.toString());
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

    public List<Horometros> listarHorometros() {
        List<Horometros> listarHrs = new ArrayList<>();
        String sql = "SELECT * FROM horometros"; // Consulta SQL para obtener todos los horómetros

        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // Ejecutar la consulta

            // Recorrer el resultado de la consulta
            while (rs.next()) {
                Horometros hrs = new Horometros();
                hrs.setId_horometro(rs.getInt("id_horometro"));

                // Convertir java.sql.Date a LocalDate
                java.sql.Date fechaSQL = rs.getDate("fecha");
                LocalDate fecha = (fechaSQL != null) ? fechaSQL.toLocalDate() : null;
                hrs.setFecha(fecha); // Asignar LocalDate

                hrs.setMaquina(rs.getString("maquina"));
                hrs.setCliente(rs.getString("cliente"));
                hrs.setH_inicio(rs.getDouble("h_inicio"));
                hrs.setH_final(rs.getDouble("h_final"));
                hrs.setTurno(rs.getInt("turno"));
                hrs.setComentarios(rs.getString("comentarios"));
                hrs.setOperador(rs.getString("operador"));

                listarHrs.add(hrs); // Agregar el horómetro a la lista
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar horómetros: " + e.toString());
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
        return listarHrs; // Retornar la lista de horómetros
    }

    public boolean ModificarHorometro(Horometros hrs) {
        String sql = "UPDATE horometros SET fecha = ?, maquina = ?, cliente = ?, h_inicio = ?, h_final = ?, turno = ?, comentarios = ?, operador = ? WHERE id_horometro = ?";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Convertir LocalDate a java.sql.Date
            LocalDate fechaLocalDate = hrs.getFecha();
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaLocalDate);

            // Asignar los valores a los parámetros de la consulta
            ps.setDate(1, fechaSQL); // Usar setDate en lugar de setTimestamp
            ps.setString(2, hrs.getMaquina());
            ps.setString(3, hrs.getCliente());
            ps.setDouble(4, hrs.getH_inicio());
            ps.setDouble(5, hrs.getH_final());
            ps.setInt(6, hrs.getTurno());
            ps.setString(7, hrs.getComentarios());
            ps.setString(8, hrs.getOperador());
            ps.setInt(9, hrs.getId_horometro()); // ID del horómetro a modificar

            // Ejecutar la actualización
            ps.executeUpdate();
            return true; // Retornar true si la actualización fue exitosa
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el horómetro: " + e.toString());
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

    public boolean EliminarHorometro(int id) {
        String sql = "delete from horometros where id_horometro=?";
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
    public List<Horometros> buscarFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Horometros> listaHorometros = new ArrayList<>();
        String sql = "SELECT * FROM horometros WHERE fecha BETWEEN ? AND ?";

        try (Connection con = cn.Conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Convertir LocalDate a java.sql.Date
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(fechaInicio);
            java.sql.Date fechaFinSQL = java.sql.Date.valueOf(fechaFin);

            ps.setDate(1, fechaInicioSQL);
            ps.setDate(2, fechaFinSQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Horometros horometros = new Horometros();
                horometros.setId_horometro(rs.getInt("id_horometro"));

                // Convertir java.sql.Date a LocalDate
                java.sql.Date fechaSQL = rs.getDate("fecha");
                LocalDate fecha = (fechaSQL != null) ? fechaSQL.toLocalDate() : null;
                horometros.setFecha(fecha); // Asignar LocalDate

                horometros.setMaquina(rs.getString("maquina"));
                horometros.setH_inicio(rs.getDouble("h_inicio"));
                horometros.setH_final(rs.getDouble("h_final"));
                horometros.setTurno(rs.getInt("turno"));
                horometros.setComentarios(rs.getString("comentarios"));
                horometros.setOperador(rs.getString("operador"));
                listaHorometros.add(horometros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaHorometros;
    }
}
