/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Abstract.IVenDetalleVenta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class FactoryVendetalleventa {
     private static FactoryVendetalleventa factory;

    static {
        try {
factory = FactoryVendetalleventa.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryProProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryVendetalleventa getInstance()
    {
        return factory;
    }
    
    public IVenDetalleVenta getInstanceAbstract()
    {
        try {
           FactoryVendetalleventa ctrlProducto = new FactoryVendetalleventa();
            return (IVenDetalleVenta) ctrlProducto;
        } catch (Exception ex) {
            return null;
        }
    }
}
