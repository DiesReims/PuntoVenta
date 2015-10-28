package Data.Estatic;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class EcConexion {

    private static String user = "postgres";
    private static String password = "furimmer";
    private static String database = "PuntoVentaDiego";
    private static String url = "jdbc:postgresql://localhost:5432/PuntoVentaDiego";

    /**
     * @return the user
     */
    public static String getUser() {
        return user;
    }

    /**
     * @param _user the user to set
     */
    public static void setUser(String _user) {
        user = _user;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param _password the password to set
     */
    public static void setPassword(String _password) {
        password = _password;
    }

    /**
     * @return the database
     */
    public static String getDatabase() {
        return database;
    }

    /**
     * @param _database the database to set
     */
    public static void setDatabase(String _database) {
        database = _database;
    }

    /**
     * @return the url
     */
    public static String getUrl() {
        return url;
    }

    /**
     * @param _url the url to set
     */
    public static void setUrl(String _url) {
        url = _url;
    }

}
