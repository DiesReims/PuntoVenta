/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Abstract.ICatStatusPedido;
import Concrete.CatstatuspedidoJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis antonio
 */
public class FactoryCatstatuspedido {
     private static FactoryCatstatuspedido factory;

    static {
        try {
factory = FactoryCatstatuspedido.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryCatstatuspedido.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryCatstatuspedido getInstance()
    {
        return factory;
    }
    
    public ICatStatusPedido getInstanceAbstract()
    {
        try {
           CatstatuspedidoJpaController ctrlStatusPedido = new CatstatuspedidoJpaController();
            return (ICatStatusPedido) ctrlStatusPedido;
        } catch (Exception ex) {
            return null;
        }
    }
}
