package Control.Control;

import Control.Conexion.CtrlConexion;
import Control.Interface.IOperaciones;
import Data.Entidad.CatTipoPago;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlCatTipoPago extends CtrlConexion implements IOperaciones{

    @Override
    public Boolean Agregar(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean Delete(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean Modificar(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ConsultaEspecifica(Object _o) {
        try {
            CatTipoPago catTipoPago = (CatTipoPago) _o;
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM cattipopago where id = ?");
            stmt.setInt(1, catTipoPago.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {                
                catTipoPago.setId(rs.getInt(1));
                catTipoPago.setStrValor(rs.getString(2));
                catTipoPago.setStrDescripcion(rs.getString(3));
            }
            return catTipoPago;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaGeneral(Object _o) {
        try {
            ArrayList<CatTipoPago> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM cattipopago");
            rs = stmt.executeQuery();
            while (rs.next()) {
                CatTipoPago pago = new CatTipoPago();
                pago.setId(rs.getInt(1));
                pago.setStrValor(rs.getString(2));
                pago.setStrDescripcion(rs.getString(3));
                lista.add(pago);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaBuscar(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> ConsultaNoCatalogo(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
