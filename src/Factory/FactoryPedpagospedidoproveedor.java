/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Abstract.IPedPagosPedidoProveedor;
import Concrete.PedpagospedidoproveedorJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class FactoryPedpagospedidoproveedor {
     private static FactoryPedpagospedidoproveedor factory;

    static {
        try {
factory = FactoryPedpagospedidoproveedor.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryProProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryPedpagospedidoproveedor getInstance()
    {
        return factory;
    }
    
    public IPedPagosPedidoProveedor getInstanceAbstract()
    {
        try {
           PedpagospedidoproveedorJpaController ctrlProducto = new PedpagospedidoproveedorJpaController();
            return (IPedPagosPedidoProveedor) ctrlProducto;
        } catch (Exception ex) {
            return null;
        }
    }

}
