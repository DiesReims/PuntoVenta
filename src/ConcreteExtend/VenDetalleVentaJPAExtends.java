package ConcreteExtend;

import Model.Vendetalleventa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class VenDetalleVentaJPAExtends {

    private EntityManagerFactory emf = null;

    public VenDetalleVentaJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Vendetalleventa findVentabyidVenta(int id, String idvenventa) {
        try {
            EntityManager em = getEntityManager();
            Vendetalleventa categoria = (Vendetalleventa) em.createQuery("SELECT c FROM Vendetalleventa c WHERE c.id = :id and c.idVenVenta :idvenventa")
                    .setParameter("id", id)
                    .setParameter("idvenventa", idvenventa)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Vendetalleventa> findAllProveedor() {
        try {
            EntityManager em = getEntityManager();
            List<Vendetalleventa> categoria = em.createQuery("SELECT c FROM Vendetalleventa c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
