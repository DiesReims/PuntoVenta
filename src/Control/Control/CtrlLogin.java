package Control.Control;

import Control.Conexion.CtrlConexion;
import java.sql.*;
import Data.Entidad.Login;

/**
 *
 * @author Dies
 */
public class CtrlLogin extends CtrlConexion {

    public CtrlLogin() {
        CtrlConexion ctrlConexion = new CtrlConexion();
    }

    //<editor-fold defaultstate="collapsed" desc="MTD Ingreso Super Usuario">
    public boolean ingresoSuperUsuario(String _usuario, String _password) {
        try {
            return (_usuario.equals("Administrador")) && (_password.equals("Administrador"));
        } catch (Exception e) {
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Ingreso Usuario Normal">
    public Login ingresoUsuarioSistema(String _usuario, String _password) {
        try {
            Login login = new Login();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = this.AbrirConexion().prepareStatement("SELECT * FROM login where strusuario = ? and strpassword = ?");
            stmt.setString(1, _usuario);
            stmt.setString(2, _password);
            rs = stmt.executeQuery();
            while (rs.next()) {
                login.setId(rs.getInt(1));
                login.setStrUsuario(rs.getString(2));
                login.setStrPassword(rs.getString(3));
                login.setIdPerfil(rs.getInt(4));
            }
            if(login.getStrUsuario().trim().equals("")) {
                return null;
            }
            if(login.getStrPassword().trim().equals("")) {
                return null;
            }
            if(login.getId() <= 0){
                return null;
            }
            if (login.getIdPerfil() <= 0) {
                return null;
            }
            return login;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
    //</editor-fold>
}
