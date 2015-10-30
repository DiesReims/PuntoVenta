/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Abstract.IVenVenta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class FactoryVenventa {
    private static FactoryVenventa factory;

    static {
        try {
factory = FactoryVenventa.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryProProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryVenventa getInstance()
    {
        return factory;
    }
    
    public IVenVenta getInstanceAbstract()
    {
        try {
           FactoryVendetalleventa ctrlProducto = new FactoryVendetalleventa();
            return (IVenVenta) ctrlProducto;
        } catch (Exception ex) {
            return null;
        }
    }
}
