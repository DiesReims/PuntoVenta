package Factory;

import Abstract.ICatTipoProducto;
import Concrete.CattipoproductoJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Cattipoproducto;
import java.util.List;
import ConcreteExtend.CatTipoProductoJPAExtends;

/**
 *
 * @author luis antonio
 */
public class FactoryCatTipoProducto {

    private static FactoryCatTipoProducto factory;

    static {
        try {
            factory = FactoryCatTipoProducto.class.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(FactoryCatTipoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static FactoryCatTipoProducto getInstance() {
        return factory;
    }

    public ICatTipoProducto getInstanceAbstract() {
        try {
            CattipoproductoJpaController ctrlCatTipoProducto = new CattipoproductoJpaController();
            return (ICatTipoProducto) ctrlCatTipoProducto;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Cattipoproducto> getInstanceAllTipoProducto() {
        try {
            CatTipoProductoJPAExtends ctrlTipoProducto = new CatTipoProductoJPAExtends();
            return ctrlTipoProducto.findAllcategoria();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getCause());
            return null;
        }
    }
}
