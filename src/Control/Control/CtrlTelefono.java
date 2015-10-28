package Control.Control;

import Control.Conexion.CtrlConexion;
import Control.Interface.IOperaciones;
import Data.Entidad.Telefono;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlTelefono extends CtrlConexion implements IOperaciones {

    //<editor-fold defaultstate="collapsed" desc="MTD Agregar">
    @Override
    public Boolean Agregar(Object _o) {
        try {
            Telefono telefono = (Telefono) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("INSERT INTO telefono(strvalor,idproveedor) values (?,?)");
            stmt.setString(1, telefono.getStrValor());
            stmt.setInt(2, telefono.getIdProveedor());
            int res = stmt.executeUpdate();
            stmt.close();
            return (res == 1) ? true : false;
        } catch (SQLException _se) {
            System.out.println(_se.getMessage());
            _se.printStackTrace();
            return false;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Eliminar">
    @Override
    public Boolean Delete(Object _o) {
        try {
            Telefono telefono = (Telefono) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("DELETE FROM telefono WHERE id = ?");
            stmt.setInt(1, telefono.getId());
            boolean res = stmt.execute();
            stmt.close();
            if (!super.CloseConexion()) {
                return false;
            }
            return res;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" MTD Modificar">
    @Override
    public Boolean Modificar(Object _o) {
        try {
            Telefono telefono = (Telefono) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("UPDATE telefono set strvalor = '" + telefono.getStrValor() + "',idproveedor = ? where id = ?");
            stmt.setInt(1, telefono.getIdProveedor());
            stmt.setInt(2, telefono.getId());
            int res = stmt.executeUpdate();
            stmt.close();
            return (res == 1) ? true : false;
        } catch (SQLException _se) {
            System.out.println(_se.getMessage());
            _se.printStackTrace();
            return false;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" MTD Consulta Unica">
    @Override
    public Object ConsultaEspecifica(Object _o) {
        try {
            Telefono telefono = new Telefono();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM telefono where id = ?");
            stmt.setInt(1, telefono.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                telefono.setId(rs.getInt(1));
                telefono.setStrValor(rs.getString(2));
                telefono.setIdProveedor(rs.getInt(3));
            }
            return telefono;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" MTD Consulta General">
    @Override
    public ArrayList<Object> ConsultaGeneral(Object _o) {
        try {
            ArrayList<Telefono> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM telefono");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Telefono telefono = new Telefono();
                telefono.setId(rs.getInt(1));
                telefono.setStrValor(rs.getString(2));
                telefono.setIdProveedor(rs.getInt(3));
                lista.add(telefono);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" MTD Consulta Buscar">
    @Override
    public ArrayList<Object> ConsultaBuscar(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta No catalogo">
    @Override
    public ArrayList<Object> ConsultaNoCatalogo(Object _o) {
        try {
            int idFiltro = (int) _o;
            ArrayList<Telefono> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM telefono WHERE idproveedor = ?");
            stmt.setInt(1, idFiltro);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Telefono telefono = new Telefono();
                telefono.setId(rs.getInt(1));
                telefono.setStrValor(rs.getString(2));
                telefono.setIdProveedor(rs.getInt(3));
                lista.add(telefono);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

}
