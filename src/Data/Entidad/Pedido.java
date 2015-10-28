package Data.Entidad;

import java.util.Date;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class Pedido {
 private int id;
 private int idProveedor;
 private int idProducto;
 private int intCantidad;
 private int idTipoPago;
 private double total;
 private double pagado;
 private Date dteFechaPedido;

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
     * @return the idProveedor
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * @param idProveedor the idProveedor to set
     */
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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
     * @return the idTipoPago
     */
    public int getIdTipoPago() {
        return idTipoPago;
    }

    /**
     * @param idTipoPago the idTipoPago to set
     */
    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the pagado
     */
    public double getPagado() {
        return pagado;
    }

    /**
     * @param pagado the pagado to set
     */
    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

    /**
     * @return the dteFechaPedido
     */
    public Date getDteFechaPedido() {
        return dteFechaPedido;
    }

    /**
     * @param dteFechaPedido the dteFechaPedido to set
     */
    public void setDteFechaPedido(Date dteFechaPedido) {
        this.dteFechaPedido = dteFechaPedido;
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
}
