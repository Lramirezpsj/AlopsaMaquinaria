package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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

        String sql = "insert into horometros (fecha, maquina, cliente, h_inicio, h_final, turno, comentarios, operador) values (?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, (Timestamp) horometro.getFecha());
            ps.setString(2, horometro.getMaquina());
            ps.setString(3, horometro.getCliente());
            ps.setDouble(4, horometro.getH_inicio());
            ps.setDouble(5, horometro.getH_final());
            ps.setString(6, horometro.getTurno());
            ps.setString(7, horometro.getComentarios());
            ps.setString(8, horometro.getOperador());
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

    public List listarHorometros() {
        List<Horometros> listarHrs = new ArrayList();
        String sql = "select * from horometros";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Horometros hrs = new Horometros();
                hrs.setId_horometro(rs.getInt("id_horometro"));
                hrs.setFecha(rs.getTimestamp("fecha"));
                hrs.setMaquina(rs.getString("maquina"));
                hrs.setCliente(rs.getString("cliente"));
                hrs.setH_inicio(rs.getDouble("h_inicio"));
                hrs.setH_final(rs.getDouble("h_final"));
                hrs.setTurno(rs.getString("turno"));
                hrs.setComentarios(rs.getString("comentarios"));
                hrs.setOperador(rs.getString("operador"));
                listarHrs.add(hrs);
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
        return listarHrs;
    }
    
    public boolean ModificarUsuario(Horometros hrs) {
        String sql = "UPDATE horometros SET fecha = ?, maquina = ?, cliente = ?, h_inicio = ?, h_final = ?, turno = ?, comentarios = ?, operador = ? WHERE id_horometro = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, (Timestamp)hrs.getFecha());
            ps.setString(2, hrs.getMaquina());
            ps.setString(3, hrs.getCliente());
            ps.setDouble(4, hrs.getH_inicio());
            ps.setDouble(5, hrs.getH_final());
            ps.setString(6, hrs.getTurno());
            ps.setString(7, hrs.getComentarios());
            ps.setString(8, hrs.getOperador());
            ps.setInt(9, hrs.getId_horometro());
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
}
