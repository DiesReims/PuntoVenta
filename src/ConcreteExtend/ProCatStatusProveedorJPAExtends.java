package ConcreteExtend;

import Model.Procatstatusproveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class ProCatStatusProveedorJPAExtends {

    private EntityManagerFactory emf = null;

    public ProCatStatusProveedorJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Procatstatusproveedor findPagosbyforanea(int id, String valor) {
        try {
            EntityManager em = getEntityManager();
            Procatstatusproveedor categoria = (Procatstatusproveedor) em.createQuery("SELECT c FROM Procatstatusproveedor c WHERE c.id = :id and c.strValor :strValor")
                    .setParameter("id", id)
                    .setParameter("strValor", valor)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Procatstatusproveedor> findAllStatusProveedor() {
        try {
            EntityManager em = getEntityManager();
            List<Procatstatusproveedor> categoria = em.createQuery("SELECT c FROM Procatstatusproveedor c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
