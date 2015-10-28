package Data.Entidad;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class Direccion {

    private int id;
    private String strCalle;
    private String strColonia;
    private String strMunicipio;
    private int idEstado;

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
     * @return the strCalle
     */
    public String getStrCalle() {
        return strCalle;
    }

    /**
     * @param strCalle the strCalle to set
     */
    public void setStrCalle(String strCalle) {
        this.strCalle = strCalle;
    }

    /**
     * @return the strColonia
     */
    public String getStrColonia() {
        return strColonia;
    }

    /**
     * @param strColonia the strColonia to set
     */
    public void setStrColonia(String strColonia) {
        this.strColonia = strColonia;
    }

    /**
     * @return the strMunicipio
     */
    public String getStrMunicipio() {
        return strMunicipio;
    }

    /**
     * @param strMunicipio the strMunicipio to set
     */
    public void setStrMunicipio(String strMunicipio) {
        this.strMunicipio = strMunicipio;
    }

    /**
     * @return the idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.strCalle);
        return sb.toString();
    }
}
