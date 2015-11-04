

package ConcreteExtend;

import Model.Cattipoproveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CatTipoProveedorJPAExtends {
 private EntityManagerFactory emf = null;

    public CatTipoProveedorJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Cattipoproveedor findCategoriabyValor(int id, String valor) {
        try {
            EntityManager em = getEntityManager();
            Cattipoproveedor categoria = (Cattipoproveedor) em.createQuery("SELECT c FROM Cattipoproveedor c WHERE c.id = :id and c.strValor :strValor")
                    .setParameter("id", id)
                    .setParameter("strValor", valor)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Cattipoproveedor> findAllProveedor() {
        try {
            EntityManager em = getEntityManager();
            List<Cattipoproveedor> categoria = em.createQuery("SELECT c FROM Cattipoproveedor c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
