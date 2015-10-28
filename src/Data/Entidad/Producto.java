package Data.Entidad;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class Producto {

    private int id;
    private int idTipoProducto;
    private String strCodigo;
    private String strValor;
    private int intCantidad;
    private double dblPrecioCompra;
    private double dblPrecioVenta;

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
     * @return the strValor
     */
    public String getStrValor() {
        return strValor;
    }

    /**
     * @param strValor the strValor to set
     */
    public void setStrValor(String strValor) {
        this.strValor = strValor;
    }

    /**
     * @return the intCantidad
     */
    public int getIntCantidad() {
        return intCantidad;
    }

    /**
     * @param intCantidad the intCantidad to set
     */
    public void setIntCantidad(int intCantidad) {
        this.intCantidad = intCantidad;
    }

    /**
     * @return the dblPrecioCompra
     */
    public double getDblPrecioCompra() {
        return dblPrecioCompra;
    }

    /**
     * @param dblPrecioCompra the dblPrecioCompra to set
     */
    public void setDblPrecioCompra(double dblPrecioCompra) {
        this.dblPrecioCompra = dblPrecioCompra;
    }

    /**
     * @return the dblPrecioVenta
     */
    public double getDblPrecioVenta() {
        return dblPrecioVenta;
    }

    /**
     * @param dblPrecioVenta the dblPrecioVenta to set
     */
    public void setDblPrecioVenta(double dblPrecioVenta) {
        this.dblPrecioVenta = dblPrecioVenta;
    }

    /**
     * @return the idTipoProducto
     */
    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    /**
     * @return the strCodigo
     */
    public String getStrCodigo() {
        return strCodigo;
    }

    /**
     * @param strCodigo the strCodigo to set
     */
    public void setStrCodigo(String strCodigo) {
        this.strCodigo = strCodigo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.strValor);
        return sb.toString();
    }
}
