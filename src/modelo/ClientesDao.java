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
public class ClientesDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public boolean cliente(Clientes clientes) {
        String sql = "INSERT INTO clientes (cliente) VALUES (?)";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Asignar los valores a los parámetros de la consulta
            ps.setString(1, clientes.getCliente());

            // Ejecutar la consulta
            ps.executeUpdate();
            return true; // Retornar true si la inserción fue exitosa
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el cliente: " + e.toString());
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

    public List<Clientes> listarClientes() {
        List<Clientes> listarClt = new ArrayList<>();
        String sql = "SELECT * FROM clientes"; // Consulta SQL para obtener todos los horómetros

        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // Ejecutar la consulta

            // Recorrer el resultado de la consulta
            while (rs.next()) {
                Clientes clt = new Clientes();
                clt.setId_cliente(rs.getInt("id_cliente"));

                clt.setCliente(rs.getString("cliente"));

                listarClt.add(clt); // Agregar el cliente a la lista
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
        return listarClt; // Retornar la lista de clientes
    }

    public boolean ModificarClientes(Clientes clt) {
        String sql = "UPDATE maquinas SET maquina = ? WHERE id_maquina = ?";
        try {
            con = cn.Conectar(); // Obtener la conexión a la base de datos
            ps = con.prepareStatement(sql);

            // Asignar los valores a los parámetros de la consulta
            ps.setString(1, clt.getCliente());
            ps.setInt(2, clt.getId_cliente()); // ID del horómetro a modificar

            // Ejecutar la actualización
            ps.executeUpdate();
            return true; // Retornar true si la actualización fue exitosa
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar cliente: " + e.toString());
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

    public boolean EliminarCliente(int id) {
        String sql = "delete from clientes where id_cliente=?";
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

    public void ConsultarClientes(JComboBox Clientes) {
        String sql = "SELECT cliente FROM clientes";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Limpiar el JComboBox
            Clientes.removeAllItems();
            Clientes.addItem("Seleccione un cliente");

            while (rs.next()) {
                String cliente = rs.getString("cliente");
                System.out.println("Cliente: " + cliente); // Depuración
                Clientes.addItem(cliente);
            }

            System.out.println("Total de clientes cargados: " + Clientes.getItemCount());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar clientes: " + e.getMessage());
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
