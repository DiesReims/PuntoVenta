

package ConcreteExtend;

import Model.Pedpagospedidoproveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class PedPagosPedidoProveedorJPAExtends {
  private EntityManagerFactory emf = null;

    public PedPagosPedidoProveedorJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Pedpagospedidoproveedor findPagosbyforanea(int id, String idPedPedido) {
        try {
            EntityManager em = getEntityManager();
            Pedpagospedidoproveedor categoria = (Pedpagospedidoproveedor) em.createQuery("SELECT c FROM Pedpagospedidoproveedor c WHERE c.id = :id and c.idPedPedidoProveedor :idPedPedidoProveedor")
                    .setParameter("id", id)
                    .setParameter("idPedPedidoProveedor", idPedPedido)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pedpagospedidoproveedor> findAllPagosProveedor() {
        try {
            EntityManager em = getEntityManager();
            List<Pedpagospedidoproveedor> categoria = em.createQuery("SELECT c FROM Pedpagospedidoproveedor c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}

