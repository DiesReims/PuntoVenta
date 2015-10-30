/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;


import Abstract.IComDireccion;
import Concrete.ComdireccionJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis antonio
 */
public class FactoryComDireccion {
    
    private static FactoryComDireccion  factory;

    static {
        try {
factory = FactoryComDireccion .class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryComDireccion .class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryComDireccion  getInstance()
    {
        return factory;
    }
    
    public IComDireccion  getInstanceAbstract()
    {
        try {
          ComdireccionJpaController ctrlComDireccion  = new ComdireccionJpaController();
            return (IComDireccion ) ctrlComDireccion ;
        } catch (Exception ex) {
            return null;
        }
    }
}
