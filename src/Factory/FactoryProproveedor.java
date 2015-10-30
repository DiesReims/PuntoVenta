/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Abstract.IProProveedor;
import Concrete.ProproveedorJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class FactoryProproveedor {
     private static FactoryProproveedor factory;

    static {
        try {
factory = FactoryProproveedor.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryProProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryProproveedor getInstance()
    {
        return factory;
    }
    
    public IProProveedor getInstanceAbstract()
    {
        try {
           ProproveedorJpaController ctrlProducto = new ProproveedorJpaController();
            return (IProProveedor) ctrlProducto;
        } catch (Exception ex) {
            return null;
        }
    }
}
