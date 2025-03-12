package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ramir
 */
public class Conexion {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/alopsamaquinaria";
    String user = "root";
    String pass = "";

    public Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error: ");
            System.out.println(e);
        }
        return con;
    }

}
