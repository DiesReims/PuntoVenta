package Control.Control;

import Control.Conexion.CtrlConexion;
import Control.Interface.IOperaciones;
import Data.Entidad.Proveedor;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import Control.Validacion.CtrlProcesarImagen;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlProveedor extends CtrlConexion implements IOperaciones {

    //<editor-fold defaultstate="collapsed" desc="MTD Agregar">
    @Override
    public Boolean Agregar(Object _o) {
        try {
            Proveedor proveedor = (Proveedor) _o;
            File archivo = new File(proveedor.getRutaImagen());
            FileInputStream fis = null;
            fis = new FileInputStream(archivo);
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("INSERT INTO Proveedor(strnombrecontacto,strapellidopcontacto,strapellidomcontacto,"
                    + "iddireccion,idcattipoproveedor,idaltaproveedor,imaimagenlogo, idestadoproveedor, strcorreo) "
                    + "values (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, proveedor.getStrNombreContacto());
            stmt.setString(2, proveedor.getStrApellidoPContacto());
            stmt.setString(3, proveedor.getStrApellidoMContacto());
            stmt.setInt(4, proveedor.getIdDireccion());
            stmt.setInt(5, proveedor.getIdTipoProveedor());
            stmt.setInt(6, proveedor.getIdAltaProveedor());
            stmt.setBinaryStream(7, fis, (int) archivo.length());
            stmt.setInt(8, proveedor.getIdEstadoProveedor());
            stmt.setString(9, proveedor.getStrCorreo());
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
            Proveedor proveedor = (Proveedor) _o;
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("DELETE FROM proveedor WHERE id = ?");
            stmt.setInt(1, proveedor.getId());
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
            Proveedor proveedor = (Proveedor) _o;
            File archivo = new File(proveedor.getRutaImagen());
            FileInputStream fis = null;
            fis = new FileInputStream(archivo);
            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("UPDATE Proveedor set strnombrecontacto = '" + proveedor.getStrNombreContacto() + "',"
                    + "strapellidopcontacto = '" + proveedor.getStrApellidoPContacto() + "',strapellidomcontacto = '" + proveedor.getStrApellidoMContacto() + "',"
                    + "strcorreo = '" + proveedor.getStrCorreo() + "', iddireccion = ?, idcattipoproveedor = ?, idaltaproveedor = ?, imaimagenlogo = ?, idestadoproveedor = ? "
                    + "where id = ?");
            stmt.setInt(1, proveedor.getIdDireccion());
            stmt.setInt(2, proveedor.getIdTipoProveedor());
            stmt.setDouble(3, proveedor.getIdAltaProveedor());
            stmt.setBinaryStream(4, fis, (int) archivo.length());
            stmt.setInt(5, proveedor.getIdEstadoProveedor());
            stmt.setInt(6, proveedor.getId());
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

    //<editor-fold defaultstate="collapsed" desc="MTD Modificar Imagen sin cambios">
    public boolean ModificarImagenSincambios(Object _o) {
        try {
            Proveedor proveedor = (Proveedor) _o;


            PreparedStatement stmt;
            stmt = super.AbrirConexion().prepareStatement("UPDATE Proveedor set strnombrecontacto = '" + proveedor.getStrNombreContacto() + "',"
                    + "strapellidopcontacto = '" + proveedor.getStrApellidoPContacto() + "',strapellidomcontacto = '" + proveedor.getStrApellidoMContacto() + "',"
                    + " iddireccion = ?, idcattipoproveedor = ?, idaltaproveedor = ? where id = ?");
            stmt.setInt(1, proveedor.getIdDireccion());
            stmt.setInt(2, proveedor.getIdTipoProveedor());
            stmt.setDouble(3, proveedor.getIdAltaProveedor());
            stmt.setInt(4, proveedor.getId());
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
            InputStream inputStream;
            ImageIcon logo;
            Proveedor proveedor = (Proveedor) _o;
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM Proveedor where id = ?");
            stmt.setInt(1, proveedor.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                proveedor.setId(rs.getInt(1));
                proveedor.setStrNombreContacto(rs.getString(2));
                proveedor.setStrApellidoPContacto(rs.getString(3));
                proveedor.setStrApellidoMContacto(rs.getString(4));
                proveedor.setIdDireccion(rs.getInt(5));
                proveedor.setIdTipoProveedor(rs.getInt(6));
                proveedor.setIdAltaProveedor(rs.getInt(7));
                proveedor.setIdEstadoProveedor(rs.getInt(8));
                inputStream = rs.getBinaryStream(9);
                BufferedImage bufferedImage = ImageIO.read(inputStream);
                logo = new ImageIcon(bufferedImage);
                proveedor.setImaImagenLogo(logo.getImage());
                proveedor.setStrCorreo(rs.getString(10));
            }
            return proveedor;
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
            InputStream inputStream;
            ImageIcon logo;
            ArrayList<Proveedor> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM proveedor");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt(1));
                proveedor.setStrNombreContacto(rs.getString(2));
                proveedor.setStrApellidoPContacto(rs.getString(3));
                proveedor.setStrApellidoMContacto(rs.getString(4));
                proveedor.setIdDireccion(rs.getInt(5));
                proveedor.setIdTipoProveedor(rs.getInt(6));
                proveedor.setIdAltaProveedor(rs.getInt(7));
                proveedor.setIdEstadoProveedor(rs.getInt(8));
                inputStream = rs.getBinaryStream(9);
                BufferedImage bufferedImage = ImageIO.read(inputStream);
                logo = new ImageIcon(bufferedImage);
                proveedor.setImaImagenLogo(logo.getImage());
                proveedor.setStrCorreo(rs.getString(10));
                lista.add(proveedor);
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
            InputStream inputStream;
            ImageIcon logo;
            Proveedor objTemp = (Proveedor) _o;
            int idFiltro = objTemp.getIdTipoProveedor();
            String busqueda = objTemp.getStrNombreContacto();
            ArrayList<Proveedor> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM proveedor WHERE strnombrecontacto like '%" + busqueda + "%' and idcattipoproveedor = ?");
            stmt.setInt(1, idFiltro);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt(1));
                proveedor.setStrNombreContacto(rs.getString(2));
                proveedor.setStrApellidoPContacto(rs.getString(3));
                proveedor.setStrApellidoMContacto(rs.getString(4));
                proveedor.setIdDireccion(rs.getInt(5));
                proveedor.setIdTipoProveedor(rs.getInt(6));
                proveedor.setIdAltaProveedor(rs.getInt(7));
                proveedor.setIdEstadoProveedor(rs.getInt(8));
                inputStream = rs.getBinaryStream(9);
                BufferedImage bufferedImage = ImageIO.read(inputStream);
                logo = new ImageIcon(bufferedImage);
                proveedor.setImaImagenLogo(logo.getImage());
                proveedor.setStrCorreo(rs.getString(10));
                lista.add(proveedor);
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
            InputStream inputStream;
            ImageIcon logo;
            int idFiltro = (int) _o;
            ArrayList<Proveedor> lista = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT * FROM proveedor WHERE idcattipoproveedor = ?");
            stmt.setInt(1, idFiltro);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt(1));
                proveedor.setStrNombreContacto(rs.getString(2));
                proveedor.setStrApellidoPContacto(rs.getString(3));
                proveedor.setStrApellidoMContacto(rs.getString(4));
                proveedor.setIdDireccion(rs.getInt(5));
                proveedor.setIdTipoProveedor(rs.getInt(6));
                proveedor.setIdAltaProveedor(rs.getInt(7));
                proveedor.setIdEstadoProveedor(rs.getInt(8));
                inputStream = rs.getBinaryStream(9);
                BufferedImage bufferedImage = ImageIO.read(inputStream);
                logo = new ImageIcon(bufferedImage);
                proveedor.setImaImagenLogo(logo.getImage());
                proveedor.setStrCorreo(rs.getString(10));
                lista.add(proveedor);
            }
            return new ArrayList(lista);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Obtener Maximo Id">
    public int ObtenerMaximoId() {
        try {
            int resultado = 0;
            PreparedStatement stmt;
            ResultSet rs;
            stmt = super.AbrirConexion().prepareStatement("SELECT MAX(id) FROM proveedor");
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
