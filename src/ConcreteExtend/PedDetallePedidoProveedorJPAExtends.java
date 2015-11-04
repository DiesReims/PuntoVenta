
package ConcreteExtend;

import Model.Peddetallepedidoproveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class PedDetallePedidoProveedorJPAExtends {
     private EntityManagerFactory emf = null;

    public PedDetallePedidoProveedorJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Peddetallepedidoproveedor findPedidoDetallebyforanea(int id, String idPedPedido) {
        try {
            EntityManager em = getEntityManager();
            Peddetallepedidoproveedor categoria = (Peddetallepedidoproveedor) em.createQuery("SELECT c FROM Peddetallepedidoproveedor c WHERE c.id = :id and c.idPedPedidoProveedor :idPedPedidoProveedor")
                    .setParameter("id", id)
                    .setParameter("idPedPedidoProveedor", idPedPedido)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Peddetallepedidoproveedor> findAllPeddetallePedidoProveedor() {
        try {
            EntityManager em = getEntityManager();
            List<Peddetallepedidoproveedor> categoria = em.createQuery("SELECT c FROM Peddetallepedidoproveedor c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}

