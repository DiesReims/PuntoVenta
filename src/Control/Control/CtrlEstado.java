package Control.Control;

import Control.Conexion.CtrlConexion;
import Control.Interface.IOperaciones;
import Data.Entidad.CatEstado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlEstado extends CtrlConexion implements IOperaciones {

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
            CatEstado catEstado = new CatEstado();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM cattipoproducto where id = ?");
            stmt.setInt(1, catEstado.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                catEstado.setId(rs.getInt(1));
                catEstado.setStrValor(rs.getString(2));
                catEstado.setStrDescripcion(rs.getString(3));
            }
            return catEstado;
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
            ArrayList<CatEstado> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM catestado");
            rs = stmt.executeQuery();
            while (rs.next()) {
                CatEstado catEstado = new CatEstado();
                catEstado.setId(rs.getInt(1));
                catEstado.setStrValor(rs.getString(2));
                lista.add(catEstado);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" MTD Buscar">
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
