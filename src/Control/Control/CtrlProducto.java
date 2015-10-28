package Control.Control;

import Control.Interface.IOperaciones;
import Control.Conexion.CtrlConexion;
import java.sql.*;
import Data.Entidad.Producto;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlProducto extends CtrlConexion implements IOperaciones {

    public CtrlProducto() {

    }

    //<editor-fold defaultstate="collapsed" desc="MTD Agregar">
    @Override
    public Boolean Agregar(Object _o) {
        try {
            Producto producto = (Producto) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("INSERT INTO Producto(idtipoproducto,strcodigo,strvalor,intcantidad,dblpreciocompra,dblprecioventa) values (?,?,?,?,?,?)");
            stmt.setInt(1, producto.getIdTipoProducto());
            stmt.setString(2, producto.getStrCodigo());
            stmt.setString(3, producto.getStrValor());
            stmt.setInt(4, producto.getIntCantidad());
            stmt.setDouble(5, producto.getDblPrecioCompra());
            stmt.setDouble(6, producto.getDblPrecioVenta());           
            int  res = stmt.executeUpdate();
            stmt.close();            
            return (res == 1)?true:false;
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
            Producto producto = (Producto) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("DELETE FROM producto WHERE id = ?");
            stmt.setInt(1, producto.getId());
            int res = stmt.executeUpdate();
            stmt.close();
            if (!super.CloseConexion()) {
                return false;
            }
            return (res == 1)?true:false;
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
            Producto producto = (Producto) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("UPDATE Producto set idtipoproducto = ?,strcodigo = '"+producto.getStrCodigo()+"',"
                    + "strvalor = '"+producto.getStrValor()+"', intcantidad = ?, dblpreciocompra = ?, dblprecioventa = ? where id = ?");
            stmt.setInt(1, producto.getIdTipoProducto());
            stmt.setInt(2, producto.getIntCantidad());
            stmt.setDouble(3, producto.getDblPrecioCompra());
            stmt.setDouble(4, producto.getDblPrecioVenta());
            stmt.setInt(5, producto.getId());
            int res = stmt.executeUpdate();
            stmt.close();        
            return (res == 1)?true:false;
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
    
    //<editor-fold defaultstate="collapsed" desc="MTD Modificar Stock">
    public boolean ModifcarStock(Producto _o)
    {
        try {
            Producto producto = (Producto) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("UPDATE Producto set intcantidad = ? where id = ?");
            stmt.setDouble(1, producto.getIntCantidad());
            stmt.setInt(2, producto.getId());
            int res = stmt.executeUpdate();
            stmt.close();        
            return (res == 1)?true:false;
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
            Producto producto = (Producto) _o;
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM Producto where id = ?");
            stmt.setInt(1, producto.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                producto.setId(rs.getInt(1));
                producto.setIdTipoProducto(rs.getInt(2));
                producto.setStrCodigo(rs.getString(3));
                producto.setStrValor(rs.getString(4));
                producto.setIntCantidad(Integer.parseInt(rs.getString(5)));
                producto.setDblPrecioCompra(Double.parseDouble(rs.getString(6)));
                producto.setDblPrecioVenta(Double.parseDouble(rs.getString(7)));
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
        try {
            ArrayList<Producto> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM producto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setIdTipoProducto(rs.getInt(2));
                producto.setStrCodigo(rs.getString(3));
                producto.setStrValor(rs.getString(4));
                producto.setIntCantidad(rs.getInt(5));
                producto.setDblPrecioCompra(rs.getDouble(6));
                producto.setDblPrecioVenta(rs.getDouble(7));
                lista.add(producto);
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
        try {
            Producto objTemp = (Producto) _o;
            int idFiltro = objTemp.getIdTipoProducto();
            String busqueda = objTemp.getStrCodigo();
            ArrayList<Producto> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM producto WHERE strcodigo like '%" + busqueda + "%' and idtipoproducto = ?");
            stmt.setInt(1, idFiltro);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setIdTipoProducto(rs.getInt(2));
                producto.setStrCodigo(rs.getString(3));
                producto.setStrValor(rs.getString(4));
                producto.setIntCantidad(rs.getInt(5));
                producto.setDblPrecioCompra(rs.getDouble(6));
                producto.setDblPrecioVenta(rs.getDouble(7));
                lista.add(producto);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="MTD Consulta Buscar Venta">
     public ArrayList<Object> ConsultaBuscarVenta(Object _o) {
        try {
            Producto objTemp = (Producto) _o;
            String busqueda = objTemp.getStrCodigo();
            ArrayList<Producto> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM producto WHERE strcodigo like '%" + busqueda + "%'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setIdTipoProducto(rs.getInt(2));
                producto.setStrCodigo(rs.getString(3));
                producto.setStrValor(rs.getString(4));
                producto.setIntCantidad(rs.getInt(5));
                producto.setDblPrecioCompra(rs.getDouble(6));
                producto.setDblPrecioVenta(rs.getDouble(7));
                lista.add(producto);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Consulta No Catalogo">
    @Override
    public ArrayList<Object> ConsultaNoCatalogo(Object _o) {
        try {
            int idFiltro = (int) _o;
            ArrayList<Producto> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM producto WHERE idtipoproducto = ?");
            stmt.setInt(1, idFiltro);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setIdTipoProducto(rs.getInt(2));
                producto.setStrCodigo(rs.getString(3));
                producto.setStrValor(rs.getString(4));
                producto.setIntCantidad(rs.getInt(5));
                producto.setDblPrecioCompra(rs.getDouble(6));
                producto.setDblPrecioVenta(rs.getDouble(7));
                lista.add(producto);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

}
