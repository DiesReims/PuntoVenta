package Data.Entidad;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class VentaProducto {
private int id;
private int idVenta;
private int idProducto;
private int intCantidad;
private double subtotal;

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
     * @return the idVenta
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
