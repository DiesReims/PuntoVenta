package Control.Conexion;

import javax.swing.JOptionPane;
import java.sql.*;
import Data.Estatic.EcConexion;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlConexion {

    private Connection conexion;

    public CtrlConexion() {

    }

    public Connection AbrirConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println(EcConexion.getUrl() + EcConexion.getDatabase()+ EcConexion.getUser() + EcConexion.getPassword());
            conexion = DriverManager.getConnection(EcConexion.getUrl(), EcConexion.getUser(), EcConexion.getPassword());
            System.out.println("Open OK");
            return conexion;
        } catch (Exception _e) {
            System.out.println("Conexión Invalida: " + _e.getMessage() + _e.getCause());
            _e.printStackTrace();
            return null;
        }
    }

    public Boolean CloseConexion() {
        try {
            this.conexion.close();
            System.out.println("Close OK");
            return true;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            return false;
        }
    }
}
