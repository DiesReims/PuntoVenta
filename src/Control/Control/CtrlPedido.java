package Control.Control;

import Control.Conexion.CtrlConexion;
import Control.Interface.IOperaciones;
import Data.Entidad.Pedido;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlPedido extends CtrlConexion implements IOperaciones {

    //<editor-fold defaultstate="collapsed" desc="MTD Agregar">
    @Override
    public Boolean Agregar(Object _o) {
        try {
            Pedido producto = (Pedido) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("INSERT INTO Pedido(idproveedor,idproducto,intcantidad,dbltotal,dtefechapedido) values (?,?,?,?,?)");
            stmt.setInt(1, producto.getIdProveedor());
            stmt.setInt(2, producto.getIdProducto());
            stmt.setInt(3, producto.getIntCantidad());
            stmt.setDouble(4, producto.getTotal());
            java.util.Date date = producto.getDteFechaPedido();
            long d = date.getTime();
            java.sql.Date fecha = new java.sql.Date(d);
            stmt.setDate(5, fecha);
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
            Pedido producto = (Pedido) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("DELETE FROM pedido WHERE id = ?");
            stmt.setInt(1, producto.getId());
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
            Pedido producto = (Pedido) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("UPDATE Pedido set idproveedor = ?,idproducto = ?,"
                    + "idtipopago = ?, dbltotal = ?, dblpagado = ? where id = ?");
            stmt.setInt(1, producto.getIdProveedor());
            stmt.setInt(2, producto.getIdProducto());
            stmt.setInt(3, producto.getIdTipoPago());
            stmt.setDouble(4, producto.getPagado());
            stmt.setDouble(5, producto.getTotal());
            stmt.setInt(6, producto.getId());
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
            Pedido producto = (Pedido) _o;
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM pedido where id = ?");
            stmt.setInt(1, producto.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                producto.setId(rs.getInt(1));
                producto.setIdProveedor(rs.getInt(2));
                producto.setIdProducto(rs.getInt(3));
                producto.setIntCantidad(rs.getInt(4));
                producto.setTotal(Double.parseDouble(rs.getString(5)));
                producto.setDteFechaPedido(rs.getDate(6));
            }
            return producto;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta General">
    @Override
    public ArrayList<Object> ConsultaGeneral(Object _o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD COnsulta Buscar">
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
            ArrayList<Pedido> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM pedido WHERE idproveedor = ?");
            stmt.setInt(1, idFiltro);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt(1));
                pedido.setIdProveedor(rs.getInt(2));
                pedido.setIdProducto(rs.getInt(3));
                pedido.setIntCantidad(rs.getInt(4));
                pedido.setTotal(rs.getDouble(5));
                pedido.setDteFechaPedido(rs.getDate(6));
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
