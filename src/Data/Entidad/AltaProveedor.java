package Data.Entidad;

import java.sql.Date;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class AltaProveedor {

    private int id;
    private Date dteIngreso;

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
     * @return the dteIngreso
     */
    public Date getDteIngreso() {
        return dteIngreso;
    }

    /**
     * @param dteIngreso the dteIngreso to set
     */
    public void setDteIngreso(Date dteIngreso) {
        this.dteIngreso = dteIngreso;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dteIngreso);
        return sb.toString();
    }
}
