package proyectopuntoventa;

import Vista.Menu.FrmMenu;
import javax.swing.JOptionPane;

/**
 *
 * @author Dies
 */
public class ProyectoPuntoVenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Vista.Menu.FrmMenu menu = new FrmMenu();
            menu.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

}
