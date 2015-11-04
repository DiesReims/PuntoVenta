package ConcreteExtend;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Model.Proproducto;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.persistence.TypedQuery;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class ProProductoJPAExtends {

    private EntityManagerFactory emf = null;

    public ProProductoJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Proproducto> findAllProductos() {
        try {
            EntityManager em = getEntityManager();
            List<Proproducto> productos = em.createNamedQuery("SELECT c FROM ProProducto c").getResultList();
            return productos;
        } catch (Exception _e) {
            return null;
        }
    }

    public List<Proproducto> findProductoByIdentificador(Proproducto _producto) {
        try {
            EntityManager em = getEntityManager();
            List<Proproducto> productos =  em.createQuery("SELECT c FROM Proproducto c WHERE  c.idcattipoproducto.id = :TipoProducto  and c.stridentificador LIKE :Identificador")
                    .setParameter("Identificador","%" + _producto.getStridentificador() + "%")
                    .setParameter("TipoProducto", _producto.getIdcattipoproducto().getId())
                    .getResultList();
            return productos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            return null;
        }
    }
    
    public List<Proproducto> findProductoByNombre(Proproducto _producto) {
        try {
            EntityManager em = getEntityManager();
            List<Proproducto> productos =  em.createQuery("SELECT c FROM Proproducto c WHERE  c.idcattipoproducto.id = :TipoProducto  and c.strnombre LIKE :Identificador")
                    .setParameter("Identificador","%" + _producto.getStrnombre() + "%")
                    .setParameter("TipoProducto", _producto.getIdcattipoproducto().getId())
                    .getResultList();
            return productos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            return null;
        }
    }
    
    public Proproducto getProductoByIdentificador(Proproducto _producto) {
        try {
            EntityManager em = getEntityManager();
            Proproducto producto = (Proproducto) em.createQuery("SELECT c FROM Proproducto c WHERE c.id = :Identificador")
                    .setParameter("Identificador", _producto.getId())
                    .getSingleResult();
            return producto;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Proproducto> findProductoCatalogo(int _tipoProducto) {
        try {
            EntityManager em = getEntityManager();
            List<Proproducto> productos =  em.createQuery("SELECT a FROM Proproducto a WHERE a.idcattipoproducto.id = :TipoProducto")
                    .setParameter("TipoProducto", _tipoProducto)
                    .getResultList();
            return productos;
        } catch (Exception e) {
            return null;
        }
    }

}
