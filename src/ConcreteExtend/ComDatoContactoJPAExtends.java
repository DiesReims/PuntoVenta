
package ConcreteExtend;

import Model.Comdatocontacto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class ComDatoContactoJPAExtends {
  private EntityManagerFactory emf = null;

    public ComDatoContactoJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Comdatocontacto findContactobyNombreContacto(int id, String nombreContacto) {
        try {
            EntityManager em = getEntityManager();
            Comdatocontacto categoria = (Comdatocontacto) em.createQuery("SELECT c FROM Comdatocontacto c WHERE c.id = :id and c.strNombreContacto :strNombreContacto")
                    .setParameter("id", id)
                    .setParameter("strNombreContacto", nombreContacto)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Comdatocontacto> findAllContacto() {
        try {
            EntityManager em = getEntityManager();
            List<Comdatocontacto> categoria = em.createQuery("SELECT c FROM Comdatocontacto c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
