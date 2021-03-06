package Control.Interface;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public interface IManager {

    Object showDialog(Object _obj);

    boolean validaDatos();

    void setInformacion(int _id);

    void setEstatus();

    Object getInformacion();

    boolean setComboBoxInitial();

    boolean setLoadInformation();

    void setComboBox();

    void setTextField();

    void setFecha();

    void setTabla();

    void setCheck();

    void setRadio();

    void setExtra();

    void huboCambio();
}
