package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ramir
 */
public class LoginDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public Login log(String usuario, String contrasenia) throws ClassNotFoundException {//Se cra el metodo con nombre Login igual que la clase Login, con el nombre log.
        Login log = new Login();//este nombre log es independiente del metodo
        String sql = "select * from usuarios where usuario = ? and contrasenia = ?";

        try {
            con = cn.Conectar();//Se conecta con la clase Conexion en el motodo Connection y el nombre conectar
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            if (rs.next()) {
                log.setId_usuario(rs.getInt("id_usuario"));
                log.setUsuario(rs.getString("usuario"));
                log.setContrasenia(rs.getString("contrasenia"));
                log.setRol(rs.getString("rol"));
            } else {
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        }

        return log;
    }

}
