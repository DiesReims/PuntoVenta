package Control.Control;

import Control.Conexion.CtrlConexion;
import Control.Interface.IOperaciones;
import Data.Entidad.VentaProducto;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlVentaProducto extends CtrlConexion implements IOperaciones {

    //<editor-fold defaultstate="collapsed" desc="MTD Agregar">
    @Override
    public Boolean Agregar(Object _o) {
        try {
            VentaProducto producto = (VentaProducto) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("INSERT INTO venta_producto(idventa,idproducto,intcantidad,dblsubtotal) values (?,?,?,?)");
            stmt.setInt(1, producto.getIdVenta());
            stmt.setInt(2, producto.getIdProducto());
            stmt.setInt(3, producto.getIntCantidad());
            stmt.setDouble(4, producto.getSubtotal());
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

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta General">
    @Override
    public ArrayList<Object> ConsultaGeneral(Object _o) {
         try {
            ArrayList<VentaProducto> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM venta_producto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                VentaProducto ventaProducto = new VentaProducto();
                ventaProducto.setId(rs.getInt(1));
                ventaProducto.setIdVenta(rs.getInt(2));
                ventaProducto.setIdProducto(rs.getInt(3));
                ventaProducto.setIntCantidad(rs.getInt(4));
                ventaProducto.setSubtotal(rs.getDouble(5));
                lista.add(ventaProducto);
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
        try {
            VentaProducto ventaProductoParametro = (VentaProducto) _o;
            ArrayList<VentaProducto> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM venta_producto where idventa = ?");
            stmt.setInt(1, ventaProductoParametro.getIdVenta());
            rs = stmt.executeQuery();
            while (rs.next()) {
                VentaProducto ventaProducto = new VentaProducto();
                ventaProducto.setId(rs.getInt(1));
                ventaProducto.setIdVenta(rs.getInt(2));
                ventaProducto.setIdProducto(rs.getInt(3));
                ventaProducto.setIntCantidad(rs.getInt(4));
                ventaProducto.setSubtotal(rs.getDouble(5));
                lista.add(ventaProducto);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
    //</editor-fold>

}
