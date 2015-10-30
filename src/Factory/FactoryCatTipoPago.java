/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;


import Abstract.ICatTipoPago;
import Concrete.CattipopagoJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis antonio
 */
public class FactoryCatTipoPago {
    private static FactoryCatTipoPago factory;

    static {
        try {
factory = FactoryCatTipoPago.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryCatTipoPago.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryCatTipoPago getInstance()
    {
        return factory;
    }
    
    public ICatTipoPago getInstanceAbstract()
    {
        try {
          CattipopagoJpaController ctrlCatTipoPago = new CattipopagoJpaController();
            return (ICatTipoPago) ctrlCatTipoPago;
        } catch (Exception ex) {
            return null;
        }
    }
}
