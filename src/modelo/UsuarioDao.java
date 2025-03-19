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
public class UsuarioDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public boolean usuarios(Usuarios usuario) {

        String sql = "insert into usuarios (usuario, contrasenia, rol) values (?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasenia());
            ps.setString(3, usuario.getRol());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }

    public List listarUsuarios() {
        List<Usuarios> listarUsu = new ArrayList();
        String sql = "select * from usuarios";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuarios usu = new Usuarios();
                usu.setId_usuario(rs.getInt("id_usuario"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setContrasenia(rs.getString("contrasenia"));
                usu.setRol(rs.getString("rol"));
                listarUsu.add(usu);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
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
                System.out.println(e.toString());
            }
        }
        return listarUsu;
    }

    public boolean ModificarUsuario(Usuarios usu) {
        String sql = "UPDATE usuarios SET usuario = ?, contrasenia = ?, rol = ? WHERE id_usuario = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getContrasenia());
            ps.setString(3, usu.getRol());
            ps.setInt(4, usu.getId_usuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }

    }

    public boolean EliminarUsuario(int id) {
        String sql = "delete from usuarios where id_usuario=?";
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

    public void ConsultarUsuario(JComboBox Usuario) {
        String sql = "SELECT usuario FROM usuarios";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Limpiar el JComboBox
            Usuario.removeAllItems();
            if (Sesion.usuarioAutenticado != null) {
                Usuario.addItem(Sesion.usuarioAutenticado.usuario);
            } else {
                Usuario.addItem("Sin sesión activa");
            }

            /*while (rs.next()) {
                String usuario = rs.getString("usuario");
                System.out.println("Usuario: " + usuario); // Depuración
                Usuario.addItem(usuario);
            }*/

            //System.out.println("Total de clientes cargados: " + Usuario.getItemCount());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar máquinas: " + e.getMessage());
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
