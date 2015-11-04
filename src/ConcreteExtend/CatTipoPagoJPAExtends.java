

package ConcreteExtend;

import Model.Cattipopago;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CatTipoPagoJPAExtends {
   private EntityManagerFactory emf = null;

    public CatTipoPagoJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Cattipopago findCategoriabyValor(int id, String valor) {
        try {
            EntityManager em = getEntityManager();
            Cattipopago categoria = (Cattipopago) em.createQuery("SELECT c FROM Cattipopago c WHERE c.id = :id and c.strValor :strValor")
                    .setParameter("id", id)
                    .setParameter("strValor", valor)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Cattipopago> findAllcategoria() {
        try {
            EntityManager em = getEntityManager();
            List<Cattipopago> categoria = em.createQuery("SELECT c FROM Cattipopago c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
