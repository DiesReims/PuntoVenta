package Data.Entidad;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class Proveedor {

    private int id;
    private String strNombreContacto;
    private String strApellidoPContacto;
    private String strApellidoMContacto;
    private String strCorreo;
    private String rutaImagen;
    private Byte[] ArrayImagen;
    private int idDireccion;
    private int idTipoProveedor;
    private int idAltaProveedor;
    private int idEstadoProveedor;
    private Image imaImagenLogo;
    private ArrayList<Telefono> telefonos;
    private Direccion direccion;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the strNombreContacto
     */
    public String getStrNombreContacto() {
        return strNombreContacto;
    }

    /**
     * @param strNombreContacto the strNombreContacto to set
     */
    public void setStrNombreContacto(String strNombreContacto) {
        this.strNombreContacto = strNombreContacto;
    }

    /**
     * @return the strApellidoPContacto
     */
    public String getStrApellidoPContacto() {
        return strApellidoPContacto;
    }

    /**
     * @param strApellidoPContacto the strApellidoPContacto to set
     */
    public void setStrApellidoPContacto(String strApellidoPContacto) {
        this.strApellidoPContacto = strApellidoPContacto;
    }

    /**
     * @return the strApellidoMContacto
     */
    public String getStrApellidoMContacto() {
        return strApellidoMContacto;
    }

    /**
     * @param strApellidoMContacto the strApellidoMContacto to set
     */
    public void setStrApellidoMContacto(String strApellidoMContacto) {
        this.strApellidoMContacto = strApellidoMContacto;
    }

    /**
     * @return the idDireccion
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * @param idDireccion the idDireccion to set
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * @return the idTipoProveedor
     */
    public int getIdTipoProveedor() {
        return idTipoProveedor;
    }

    /**
     * @param idTipoProveedor the idTipoProveedor to set
     */
    public void setIdTipoProveedor(int idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
    }

    /**
     * @return the idAltaProveedor
     */
    public int getIdAltaProveedor() {
        return idAltaProveedor;
    }

    /**
     * @param idAltaProveedor the idAltaProveedor to set
     */
    public void setIdAltaProveedor(int idAltaProveedor) {
        this.idAltaProveedor = idAltaProveedor;
    }

    /**
     * @return the imaImagenLogo
     */
    public Image getImaImagenLogo() {
        return imaImagenLogo;
    }

    /**
     * @param imaImagenLogo the imaImagenLogo to set
     */
    public void setImaImagenLogo(Image imaImagenLogo) {
        this.imaImagenLogo = imaImagenLogo;
    }

    /**
     * @return the telefonos
     */
    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    /**
     * @param telefonos the telefonos to set
     */
    public void setTelefonos(ArrayList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the rutaImagen
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * @param rutaImagen the rutaImagen to set
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * @return the ArrayImagen
     */
    public Byte[] getArrayImagen() {
        return ArrayImagen;
    }

    /**
     * @param ArrayImagen the ArrayImagen to set
     */
    public void setArrayImagen(Byte[] ArrayImagen) {
        this.ArrayImagen = ArrayImagen;
    }

    /**
     * @return the strCorreo
     */
    public String getStrCorreo() {
        return strCorreo;
    }

    /**
     * @param strCorreo the strCorreo to set
     */
    public void setStrCorreo(String strCorreo) {
        this.strCorreo = strCorreo;
    }

    /**
     * @return the idEstadoProveedor
     */
    public int getIdEstadoProveedor() {
        return idEstadoProveedor;
    }

    /**
     * @param idEstadoProveedor the idEstadoProveedor to set
     */
    public void setIdEstadoProveedor(int idEstadoProveedor) {
        this.idEstadoProveedor = idEstadoProveedor;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.strNombreContacto);
        sb.append(" ");
        sb.append(this.strApellidoPContacto);
        sb.append(" ");
        sb.append(this.strApellidoMContacto);
        return sb.toString();
    }

}
