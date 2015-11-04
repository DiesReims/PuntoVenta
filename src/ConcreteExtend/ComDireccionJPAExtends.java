

package ConcreteExtend;

import Model.Comdireccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class ComDireccionJPAExtends {
 private EntityManagerFactory emf = null;

    public ComDireccionJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Comdireccion findDireccionbyMunicipio(int id, String municipio) {
        try {
            EntityManager em = getEntityManager();
            Comdireccion categoria = (Comdireccion) em.createQuery("SELECT c FROM Comdireccion c WHERE c.id = :id and c.strMunicipio :strMunicipio")
                    .setParameter("id", id)
                    .setParameter("strMunicipio", municipio)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Comdireccion> findAllDireccion() {
        try {
            EntityManager em = getEntityManager();
            List<Comdireccion> categoria = em.createQuery("SELECT c FROM Comdireccion c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
