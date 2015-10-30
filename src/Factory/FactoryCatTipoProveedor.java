/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;


import Abstract.ICatTipoProveedor;
import Concrete.CattipoproveedorJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis antonio
 */
public class FactoryCatTipoProveedor {
    private static FactoryCatTipoProveedor factory;

    static {
        try {
factory = FactoryCatTipoProveedor.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryCatTipoProveedor.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryCatTipoProveedor getInstance()
    {
        return factory;
    }
    
    public ICatTipoProveedor getInstanceAbstract()
    {
        try {
          CattipoproveedorJpaController ctrlCatTipoProveedor = new CattipoproveedorJpaController();
            return (ICatTipoProveedor) ctrlCatTipoProveedor;
        } catch (Exception ex) {
            return null;
        }
    }
}
