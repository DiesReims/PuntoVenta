package ConcreteExtend;

import Model.Pedpedidoproveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class PedPedidoProveedorJPAExtends {

    private EntityManagerFactory emf = null;

    public PedPedidoProveedorJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Pedpedidoproveedor findPedidobyfolio(int id, String folio) {
        try {
            EntityManager em = getEntityManager();
            Pedpedidoproveedor categoria = (Pedpedidoproveedor) em.createQuery("SELECT c FROM Pedpedidoproveedor c WHERE c.id = :id and c.strFolio :strFolio")
                    .setParameter("id", id)
                    .setParameter("strFolio", folio)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pedpedidoproveedor> findAllPagosPedidos() {
        try {
            EntityManager em = getEntityManager();
            List<Pedpedidoproveedor> categoria = em.createQuery("SELECT c FROM Pedpedidoproveedor c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
