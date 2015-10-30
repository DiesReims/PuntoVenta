/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Abstract.IPedPedidoProveedor;
import Concrete.PedpedidoproveedorJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class FactoryPedpedidoproveedor {
      private static FactoryPedpedidoproveedor factory;

    static {
        try {
factory = FactoryPedpedidoproveedor.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryProProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryPedpedidoproveedor getInstance()
    {
        return factory;
    }
    
    public IPedPedidoProveedor getInstanceAbstract()
    {
        try {
           PedpedidoproveedorJpaController ctrlProducto = new PedpedidoproveedorJpaController();
            return (IPedPedidoProveedor) ctrlProducto;
        } catch (Exception ex) {
            return null;
        }
    }
}
