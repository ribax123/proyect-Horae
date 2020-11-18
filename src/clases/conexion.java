package clases;

import java.sql.*;

public class conexion {

    //conexion Local
    public static Connection conectar() {
        try {
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        return (null);
    }
}
