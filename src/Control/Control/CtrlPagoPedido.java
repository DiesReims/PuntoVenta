package Control.Control;

import Control.Conexion.CtrlConexion;
import Control.Interface.IOperaciones;
import Data.Entidad.PagoPedido;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlPagoPedido extends CtrlConexion implements IOperaciones {

    //<editor-fold defaultstate="collapsed" desc="MTD Agregar">
    @Override
    public Boolean Agregar(Object _o) {
        try {
            PagoPedido producto = (PagoPedido) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("INSERT INTO PagoPedido(idpedido,idcattipopago,dblmontopago) values (?,?,?)");
            stmt.setInt(1, producto.getIdPedido());
            stmt.setInt(2, producto.getIdcatTipoPago());
            stmt.setDouble(3, producto.getDblMontoPago());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD COnsulta General">
    @Override
    public ArrayList<Object> ConsultaGeneral(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        try {
            int idFiltro = (int) _o;
            ArrayList<PagoPedido> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM pagopedido WHERE idpedido = ?");
            stmt.setInt(1, idFiltro);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PagoPedido pedido = new PagoPedido();
                pedido.setId(rs.getInt(1));
                pedido.setIdPedido(rs.getInt(2));
                pedido.setIdcatTipoPago(rs.getInt(3));
                pedido.setDblMontoPago(rs.getDouble(4));
                lista.add(pedido);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

}
