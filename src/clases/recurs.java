package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import windows.Restaura_pass;

public class recurs extends type {

//Consulta a base de datos para actualizar un password de ingreso.
    @Override
    public void variable() {
        password = Restaura_pass.password;
        confirmacion_password = Restaura_pass.confirmacion_password;
        user_update = Restaura_pass.user_update;

        if (!password.equals("") && !confirmacion_password.equals("")) {

            if (password.equals(confirmacion_password)) {

                try {
                    // conexion al la base de datos.
                    Connection cn = conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "update usuarios set password=? where username = '" + user_update + "'");

                    pst.setString(1, password);

                    pst.executeUpdate();
                    cn.close();

                    bandera = true;
                    JOptionPane.showMessageDialog(null, "Restauración exitosa");
                } catch (SQLException e) {
                    System.err.println("Error en restaurar la contraseña " + e);
                }
            } else {
                bandera = false;
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se admiten campos vacios.");
        }
    }
}
