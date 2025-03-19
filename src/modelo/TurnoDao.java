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
public class TurnoDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public boolean turno(Turno turno) {
        String sql = "INSERT INTO turnos (turno) VALUES (?)";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Asignar los valores a los parámetros de la consulta
            ps.setInt(1, turno.getTurno());

            // Ejecutar la consulta
            ps.executeUpdate();
            return true; // Retornar true si la inserción fue exitosa
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el turno: " + e.toString());
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

    public List<Turno> listarTurno() {
        List<Turno> listarTrn = new ArrayList<>();
        String sql = "SELECT * FROM turnos"; // Consulta SQL para obtener todos los horómetros

        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // Ejecutar la consulta

            // Recorrer el resultado de la consulta
            while (rs.next()) {
                Turno trn = new Turno();
                trn.setId_turno(rs.getInt("id_turno"));

                trn.setTurno(rs.getInt("turno"));

                listarTrn.add(trn); // Agregar el horómetro a la lista
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar turno: " + e.toString());
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
        return listarTrn; // Retornar la lista de horómetros
    }

    public boolean ModificarTurno(Turno trn) {
        String sql = "UPDATE turnos SET turno = ? WHERE id_turno = ?";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Asignar los valores a los parámetros de la consulta
            ps.setInt(1, trn.getTurno());
            ps.setInt(2, trn.getId_turno()); // ID del horómetro a modificar

            // Ejecutar la actualización
            ps.executeUpdate();
            return true; // Retornar true si la actualización fue exitosa
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar turno: " + e.toString());
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
    
    public boolean EliminarTurno(int id) {
        String sql = "delete from turnos where id_turno=?";
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
    
    public void ConsultarTurno(JComboBox Turno) {
        String sql = "SELECT turno FROM turnos";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Limpiar el JComboBox
            Turno.removeAllItems();
            Turno.addItem("Seleccione un turno");

            while (rs.next()) {
                int turno = rs.getInt("turno");
                //System.out.println("Maquina: " + maquina); // Depuración
                Turno.addItem(turno);
            }

           // System.out.println("Total de clientes cargados: " + Maquina.getItemCount());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar turno: " + e.getMessage());
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
