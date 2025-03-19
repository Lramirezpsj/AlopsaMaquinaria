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
public class SuministrosDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public boolean horometros(Suministros suministro) {
        String sql = "INSERT INTO suministros (fecha, maquina, horometro, total, comentarios, operador) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Convertir LocalDate a java.sql.Date
            LocalDate fechaLocalDate = suministro.getFecha();
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaLocalDate);

            // Asignar los valores a los parámetros de la consulta
            ps.setDate(1, fechaSQL); // Usar setDate en lugar de setTimestamp
            ps.setString(2, suministro.getMaquina());
            ps.setDouble(3, suministro.getHorometro());
            ps.setDouble(4, suministro.getTotal());
            ps.setString(5, suministro.getComentarios());
            ps.setString(6, suministro.getOperador());

            // Ejecutar la consulta
            ps.executeUpdate();
            return true; // Retornar true si la inserción fue exitosa
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el suministro: " + e.toString());
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

    public List<Suministros> listarSumistros() {
        List<Suministros> listarSum = new ArrayList<>();
        String sql = "SELECT * FROM suministros"; // Consulta SQL para obtener todos los horómetros

        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // Ejecutar la consulta

            // Recorrer el resultado de la consulta
            while (rs.next()) {
                Suministros sum = new Suministros();
                sum.setId_suministro(rs.getInt("id_suministro"));

                // Convertir java.sql.Date a LocalDate
                java.sql.Date fechaSQL = rs.getDate("fecha");
                LocalDate fecha = (fechaSQL != null) ? fechaSQL.toLocalDate() : null;
                sum.setFecha(fecha); // Asignar LocalDate

                sum.setMaquina(rs.getString("maquina"));
                sum.setHorometro(rs.getDouble("horometro"));
                sum.setTotal(rs.getDouble("total"));
                sum.setComentarios(rs.getString("comentarios"));
                sum.setOperador(rs.getString("operador"));

                listarSum.add(sum); // Agregar el horómetro a la lista
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
        return listarSum; // Retornar la lista de horómetros
    }

    public boolean ModificarSuministro(Suministros sum) {
        String sql = "UPDATE suministros SET fecha = ?, maquina = ?, horometro = ?, total = ?, comentarios = ?, operador = ? WHERE id_suministro = ?";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Convertir LocalDate a java.sql.Date
            LocalDate fechaLocalDate = sum.getFecha();
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaLocalDate);

            // Asignar los valores a los parámetros de la consulta
            ps.setDate(1, fechaSQL); // Usar setDate en lugar de setTimestamp
            ps.setString(2, sum.getMaquina());
            ps.setDouble(3, sum.getHorometro());
            ps.setDouble(4, sum.getTotal());
            ps.setString(5, sum.getComentarios());
            ps.setString(6, sum.getOperador());
            ps.setInt(7, sum.getId_suministro()); // ID del horómetro a modificar

            // Ejecutar la actualización
            ps.executeUpdate();
            return true; // Retornar true si la actualización fue exitosa
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el suministro: " + e.toString());
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

    public boolean EliminarSuministro(int id) {
        String sql = "delete from suministro where id_suministro=?";
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
    public List<Suministros> buscarFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Suministros> listaSuministros = new ArrayList<>();
        String sql = "SELECT * FROM suministros WHERE fecha BETWEEN ? AND ?";

        try (Connection con = cn.Conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Convertir LocalDate a java.sql.Date
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(fechaInicio);
            java.sql.Date fechaFinSQL = java.sql.Date.valueOf(fechaFin);

            ps.setDate(1, fechaInicioSQL);
            ps.setDate(2, fechaFinSQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Suministros suministros = new Suministros();
                suministros.setId_suministro(rs.getInt("id_suministro"));

                // Convertir java.sql.Date a LocalDate
                java.sql.Date fechaSQL = rs.getDate("fecha");
                LocalDate fecha = (fechaSQL != null) ? fechaSQL.toLocalDate() : null;
                suministros.setFecha(fecha); // Asignar LocalDate

                suministros.setMaquina(rs.getString("maquina"));
                suministros.setHorometro(rs.getDouble("horometro"));
                suministros.setTotal(rs.getDouble("total"));
                suministros.setComentarios(rs.getString("comentarios"));
                suministros.setOperador(rs.getString("operador"));
                listaSuministros.add(suministros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaSuministros;
    }
    
}
