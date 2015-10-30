/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;


import Abstract.IComDatoContacto;
import Concrete.ComdatocontactoJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis antonio
 */
public class FactoryComDatoContacto {
    
    private static FactoryComDatoContacto  factory;

    static {
        try {
factory = FactoryComDatoContacto .class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryComDatoContacto .class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryComDatoContacto  getInstance()
    {
        return factory;
    }
    
    public IComDatoContacto  getInstanceAbstract()
    {
        try {
          ComdatocontactoJpaController ctrlComDatoContacto  = new ComdatocontactoJpaController();
            return (IComDatoContacto ) ctrlComDatoContacto ;
        } catch (Exception ex) {
            return null;
        }
    }
}
