package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ramir
 */
public class MovimientosDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public boolean movimiento(Movimientos movimiento) {
        String sql = "INSERT INTO movimientos (movimiento) VALUES (?)";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Asignar los valores a los parámetros de la consulta
            ps.setString(1, movimiento.getMovimiento());

            // Ejecutar la consulta
            ps.executeUpdate();
            return true; // Retornar true si la inserción fue exitosa
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar medida: " + e.toString());
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

    public List<Movimientos> listarMovimientos() {
        List<Movimientos> listarMovs = new ArrayList<>();
        String sql = "SELECT * FROM movimientos"; // Consulta SQL para obtener todos los horómetros

        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // Ejecutar la consulta

            // Recorrer el resultado de la consulta
            while (rs.next()) {
                Movimientos mov = new Movimientos();
                mov.setId_movimiento(rs.getInt("id_movimiento"));

                mov.setMovimiento(rs.getString("movimiento"));

                listarMovs.add(mov); // Agregar el horómetro a la lista
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar medidas: " + e.toString());
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
        return listarMovs; // Retornar la lista de horómetros
    }

    public boolean ModificarMovimientos(Movimientos movs) {
        String sql = "UPDATE movimientos SET movimiento = ? WHERE id_movimiento = ?";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Asignar los valores a los parámetros de la consulta
            ps.setString(1, movs.getMovimiento());
            ps.setInt(2, movs.getId_movimiento()); // ID del horómetro a modificar

            // Ejecutar la actualización
            ps.executeUpdate();
            return true; // Retornar true si la actualización fue exitosa
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar mvimiento: " + e.toString());
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
    
    public boolean EliminarMovimiento(int id) {
        String sql = "delete from movimientos where id_movimiento=?";
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
    
    public void ConsultarMedida(JComboBox Movimientos) {
        String sql = "SELECT movimiento FROM movimientos";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Limpiar el JComboBox
            Movimientos.removeAllItems();
            Movimientos.addItem("Seleccione un movimiento");

            while (rs.next()) {
                String movimiento = rs.getString("movimiento");
                //System.out.println("Maquina: " + maquina); // Depuración
                Movimientos.addItem(movimiento);
            }

           // System.out.println("Total de clientes cargados: " + Maquina.getItemCount());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar movimiento: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
    
}
