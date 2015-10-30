/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;


import Abstract.IComEstadoDireccion;
import Concrete.ComestadodireccionJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis antonio
 */
public class FactoryComEstadoDireccion {
    
    private static FactoryComEstadoDireccion  factory;

    static {
        try {
factory = FactoryComEstadoDireccion .class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryComEstadoDireccion .class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryComEstadoDireccion  getInstance()
    {
        return factory;
    }
    
    public IComEstadoDireccion  getInstanceAbstract()
    {
        try {
          ComestadodireccionJpaController ctrlEstadoDireccion  = new ComestadodireccionJpaController();
            return (IComEstadoDireccion ) ctrlEstadoDireccion ;
        } catch (Exception ex) {
            return null;
        }
    }
}
