package Data.Entidad;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class Telefono {

    private int id;
    private String strValor;
    private int idProveedor;

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.strValor);
        return sb.toString();
    }

}
