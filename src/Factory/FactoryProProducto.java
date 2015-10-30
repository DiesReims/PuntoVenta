package Factory;


import Abstract.IProProducto;
import Concrete.ProproductoJpaController;
import Model.Proproducto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Alberto Zarate Lara
 */
public class FactoryProProducto {

    private static FactoryProProducto factory;

    static {
        try {
factory = FactoryProProducto.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryProProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryProProducto getInstance()
    {
        return factory;
    }
    
    public IProProducto getInstanceAbstract()
    {
        try {
           ProproductoJpaController ctrlProducto = new ProproductoJpaController();
            return (IProProducto) ctrlProducto;
        } catch (Exception ex) {
            return null;
        }
    }

}
