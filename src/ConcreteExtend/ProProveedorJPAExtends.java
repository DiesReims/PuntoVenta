

package ConcreteExtend;

import Model.Proproveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class ProProveedorJPAExtends {
      private EntityManagerFactory emf = null;

    public ProProveedorJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Proproveedor findProveedorByNombreCompania(Proproveedor _proveedor) {
        try {
            EntityManager em = getEntityManager();
            Proproveedor categoria = (Proproveedor) em.createQuery("SELECT c FROM Proproveedor c WHERE c.idcattipoproveedor = :Id and c.strNombreCompania :NombreCompania")
                    .setParameter("Id", _proveedor.getIdcattipoproveedor())
                    .setParameter("NombreCompania", _proveedor.getStrnombrecompania())
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Proproveedor> findAllProveedor() {
        try {
            EntityManager em = getEntityManager();
            List<Proproveedor> proveedores = em.createQuery("SELECT c FROM Proproveedor c").getResultList();
            return proveedores;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
