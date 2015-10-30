/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Abstract.IPedDetallePedido;
import Concrete.PeddetallepedidoproveedorJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class FactoryPeddetallepedidoproveedor {
     private static FactoryPeddetallepedidoproveedor factory;

    static {
        try {
factory = FactoryPeddetallepedidoproveedor.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryProProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryPeddetallepedidoproveedor getInstance()
    {
        return factory;
    }
    
    public IPedDetallePedido getInstanceAbstract()
    {
        try {
           PeddetallepedidoproveedorJpaController ctrlProducto = new PeddetallepedidoproveedorJpaController();
            return (IPedDetallePedido) ctrlProducto;
        } catch (Exception ex) {
            return null;
        }
    }

}
