

package ConcreteExtend;

import Model.Comestadodireccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class ComEstadoDireccionJPAExtends {
  private EntityManagerFactory emf = null;

    public ComEstadoDireccionJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Comestadodireccion findValor(int id, String valor) {
        try {
            EntityManager em = getEntityManager();
            Comestadodireccion categoria = (Comestadodireccion) em.createQuery("SELECT c FROM Comestadodireccion c WHERE c.id = :id and c.strValor :strValor")
                    .setParameter("id", id)
                    .setParameter("strValor", valor)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Comestadodireccion> findEstadoDireccion() {
        try {
            EntityManager em = getEntityManager();
            List<Comestadodireccion> categoria = em.createQuery("SELECT c FROM Comestadodireccion c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}