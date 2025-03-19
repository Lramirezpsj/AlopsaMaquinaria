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
public class MedidasDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public boolean medida(Medidas medida) {
        String sql = "INSERT INTO medidas (medida) VALUES (?)";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Asignar los valores a los parámetros de la consulta
            ps.setString(1, medida.getMedida());

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

    public List<Medidas> listarMedidas() {
        List<Medidas> listarMds = new ArrayList<>();
        String sql = "SELECT * FROM medidas"; // Consulta SQL para obtener todos los horómetros

        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // Ejecutar la consulta

            // Recorrer el resultado de la consulta
            while (rs.next()) {
                Medidas mds = new Medidas();
                mds.setId_medida(rs.getInt("id_medida"));

                mds.setMedida(rs.getString("medida"));

                listarMds.add(mds); // Agregar el horómetro a la lista
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
        return listarMds; // Retornar la lista de horómetros
    }

    public boolean ModificarMedidas(Medidas mds) {
        String sql = "UPDATE medidas SET medida = ? WHERE id_medida = ?";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Asignar los valores a los parámetros de la consulta
            ps.setString(1, mds.getMedida());
            ps.setInt(2, mds.getId_medida()); // ID del horómetro a modificar

            // Ejecutar la actualización
            ps.executeUpdate();
            return true; // Retornar true si la actualización fue exitosa
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar medida: " + e.toString());
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
    
    public boolean EliminarMedida(int id) {
        String sql = "delete from medidas where id_medida=?";
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
    
    public void ConsultarMedida(JComboBox Medidas) {
        String sql = "SELECT medida FROM medidas";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Limpiar el JComboBox
            Medidas.removeAllItems();
            Medidas.addItem("Seleccione una medida");

            while (rs.next()) {
                String medida = rs.getString("medida");
                //System.out.println("Maquina: " + maquina); // Depuración
                Medidas.addItem(medida);
            }

           // System.out.println("Total de clientes cargados: " + Maquina.getItemCount());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar medida: " + e.getMessage());
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
