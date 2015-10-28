package Data.Entidad;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CatTipoProducto {

    private int id;
    private String strValor;
    private String strDescripcion;

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
     * @return the strDescripcion
     */
    public String getStrDescripcion() {
        return strDescripcion;
    }

    /**
     * @param strDescripcion the strDescripcion to set
     */
    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.strValor);
        return sb.toString();
    }
    
}
