package Data.Entidad;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class PagoPedido {

    private int id;
    private int idPedido;
    private int idcatTipoPago;  
    private double dblMontoPago;

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
     * @return the idPedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the idcatTipoPago
     */
    public int getIdcatTipoPago() {
        return idcatTipoPago;
    }

    /**
     * @param idcatTipoPago the idcatTipoPago to set
     */
    public void setIdcatTipoPago(int idcatTipoPago) {
        this.idcatTipoPago = idcatTipoPago;
    }

    /**
     * @return the dblMontoPago
     */
    public double getDblMontoPago() {
        return dblMontoPago;
    }

    /**
     * @param dblMontoPago the dblMontoPago to set
     */
    public void setDblMontoPago(double dblMontoPago) {
        this.dblMontoPago = dblMontoPago;
    }

}
