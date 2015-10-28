package Data.Entidad;

/**
 *
 * @author Dies
 */
public class Login {

    private int id;
    private String strUsuario;
    private String strPassword;
    private int idPerfil;

    /**
     * @return the strUsuario
     */
    public String getStrUsuario() {
        return strUsuario;
    }

    /**
     * @param strUsuario the strUsuario to set
     */
    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }

    /**
     * @return the strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }

    /**
     * @param strPassword the strPassword to set
     */
    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    /**
     * @return the idPerfil
     */
    public int getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

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
}
