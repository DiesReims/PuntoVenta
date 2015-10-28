package Control.Control;

import Control.Conexion.CtrlConexion;
import Control.Interface.IOperaciones;
import Data.Entidad.CatTipoProveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlCatTipoProveedor extends CtrlConexion implements IOperaciones {

    //<editor-fold defaultstate="collapsed" desc="MTD Agregar">
    @Override
    public Boolean Agregar(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Eliminar">
    @Override
    public Boolean Delete(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Modificar">
    @Override
    public Boolean Modificar(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta Unica">
    @Override
    public Object ConsultaEspecifica(Object _o) {
        try {
            CatTipoProveedor catTipoProveedor = new CatTipoProveedor();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM cattipoproducto where id = ?");
            stmt.setInt(1, catTipoProveedor.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                catTipoProveedor.setId(rs.getInt(1));
                catTipoProveedor.setStrValor(rs.getString(2));
                catTipoProveedor.setStrDescripcion(rs.getString(3));
            }
            return catTipoProveedor;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta General">
    @Override
    public ArrayList<Object> ConsultaGeneral(Object _o) {
        try {
            ArrayList<CatTipoProveedor> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM cattipoproveedor");
            rs = stmt.executeQuery();
            while (rs.next()) {
                CatTipoProveedor catTipoProducto = new CatTipoProveedor();
                catTipoProducto.setId(rs.getInt(1));
                catTipoProducto.setStrValor(rs.getString(2));
                catTipoProducto.setStrDescripcion(rs.getString(3));
                lista.add(catTipoProducto);
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

    

}
