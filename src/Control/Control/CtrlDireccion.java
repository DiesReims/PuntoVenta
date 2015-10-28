package Control.Control;

import Control.Conexion.CtrlConexion;
import Control.Interface.IOperaciones;
import Data.Entidad.Direccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlDireccion extends CtrlConexion implements IOperaciones {

    //<editor-fold defaultstate="collapsed" desc="MTD Agregar">
    @Override
    public Boolean Agregar(Object _o) {
        try {
            Direccion producto = (Direccion) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("INSERT INTO direccion(strcalle,strcolonia,strmunicipio,idestado) values (?,?,?,?)");
            stmt.setString(1, producto.getStrCalle());
            stmt.setString(2, producto.getStrColonia());
            stmt.setString(3, producto.getStrMunicipio());
            stmt.setInt(4, producto.getIdEstado());
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

    //<editor-fold defaultstate="collapsed" desc="MTD Delete">
    @Override
    public Boolean Delete(Object _o) {
        try {
            Direccion direccion = (Direccion) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("DELETE FROM direccion WHERE id = ?");
            stmt.setInt(1, direccion.getId());
            int res = stmt.executeUpdate();
            stmt.close();
            if (!super.CloseConexion()) {
                return false;
            }
            return (res == 1) ? true : false;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Modificar">
    @Override
    public Boolean Modificar(Object _o) {
        try {
            Direccion direccion = (Direccion) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("UPDATE direccion set strcalle = '" + direccion.getStrCalle() + "',strcolonia = '" + direccion.getStrColonia() + "', "
                    + "strmunicipio = '" + direccion.getStrMunicipio() + "', idestado  = ? where id = ?");
            stmt.setInt(1, direccion.getIdEstado());
            stmt.setInt(2, direccion.getId());
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

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta Unica">
    @Override
    public Object ConsultaEspecifica(Object _o) {
        try {
            Direccion direccion = (Direccion) _o;
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM direccion where id = ?");
            stmt.setInt(1, direccion.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                direccion.setId(rs.getInt(1));
                direccion.setStrCalle(rs.getString(2));
                direccion.setStrColonia(rs.getString(3));
                direccion.setStrMunicipio(rs.getString(4));
                direccion.setIdEstado(rs.getInt(5));
            }
            return direccion;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta General">
    @Override
    public ArrayList<Object> ConsultaGeneral(Object _o) {
        try {
            ArrayList<Direccion> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM direccion");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Direccion direccion = new Direccion();
                direccion.setId(rs.getInt(1));
                direccion.setStrCalle(rs.getString(2));
                direccion.setStrColonia(rs.getString(3));
                direccion.setStrMunicipio(rs.getString(4));
                direccion.setIdEstado(rs.getInt(5));
                lista.add(direccion);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta Buscar">
    @Override
    public ArrayList<Object> ConsultaBuscar(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta No Catalogo">
    @Override
    public ArrayList<Object> ConsultaNoCatalogo(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Obtener Maximo Id">
    public int ObtenerMaximoId() {
        try {
            int resultado = 0;
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT MAX(id) FROM direccion");
            rs = stmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt(1);
            }
            return resultado;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            return 0;
        }
    }
//</editor-fold>
}
