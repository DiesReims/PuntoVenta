package Factory;


import Abstract.IProProducto;
import Concrete.ProproductoJpaController;
import ConcreteExtend.ProProductoJPAExtends;
import Model.Proproducto;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Alberto Zarate Lara
 */
public class FactoryProProducto {

    private static FactoryProProducto factory;

    static {
        try {
factory = FactoryProProducto.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryProProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static FactoryProProducto getInstance()
    {
        return factory;
    }
    
    public IProProducto getInstanceAbstract()
    {
        try {
           ProproductoJpaController ctrlProducto = new ProproductoJpaController();
            return (IProProducto) ctrlProducto;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<Proproducto> getInstanceBusquedaProductoIdentificador(Proproducto _producto)
    {
        try {
           ProProductoJPAExtends ctrlProducto = new ProProductoJPAExtends();   
            return ctrlProducto.findProductoByIdentificador(_producto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            return null;
        }
    }
    public List<Proproducto> getInstanceBusquedaProductoNombre(Proproducto _producto)
    {
        try {
           ProProductoJPAExtends ctrlProducto = new ProProductoJPAExtends();   
            return ctrlProducto.findProductoByNombre(_producto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            return null;
        }
    }
    
   public List<Proproducto> getInstanceTodosProducto(Proproducto _producto)
    {
        try {
           ProProductoJPAExtends ctrlProducto = new ProProductoJPAExtends();   
            return ctrlProducto.findProductoByIdentificador(_producto);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Proproducto> getInstanceCatalogo(int _tipoProducto)
    {
        try {
           ProProductoJPAExtends ctrlProducto = new ProProductoJPAExtends();   
            return ctrlProducto.findProductoCatalogo(_tipoProducto);
        } catch (Exception e) {
            return null;
        }
    }
    
    public Proproducto getInstanceSpecificById(Proproducto _producto)
    {
        try {
             ProProductoJPAExtends ctrlProducto = new ProProductoJPAExtends();
        return ctrlProducto.getProductoByIdentificador(_producto);
        } catch (Exception e) {
            return null;
        }
       
    }

}
