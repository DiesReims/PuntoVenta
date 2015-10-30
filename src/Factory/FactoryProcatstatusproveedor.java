/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Abstract.IProCatStatusProveedor;
import Concrete.ProcatstatusproveedorJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class FactoryProcatstatusproveedor {
     private static FactoryProcatstatusproveedor factory;

    static {
        try {
factory = FactoryProcatstatusproveedor.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryProProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryProcatstatusproveedor getInstance()
    {
        return factory;
    }
    
    public IProCatStatusProveedor getInstanceAbstract()
    {
        try {
           ProcatstatusproveedorJpaController ctrlProducto = new ProcatstatusproveedorJpaController();
            return (IProCatStatusProveedor) ctrlProducto;
        } catch (Exception ex) {
            return null;
        }
    }

}
