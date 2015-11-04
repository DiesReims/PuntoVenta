package ConcreteExtend;

import Model.Catstatuspedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CatStatusPedidoJPAExtends {

    private EntityManagerFactory emf = null;

    public CatStatusPedidoJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Catstatuspedido findCategoriabyValor(int id, String valor) {
        try {
            EntityManager em = getEntityManager();
            Catstatuspedido categoria = (Catstatuspedido) em.createQuery("SELECT c FROM Catstatuspedido c WHERE c.id = :id and c.strValor :strValor")
                    .setParameter("id", id)
                    .setParameter("strValor", valor)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Catstatuspedido> findAllcategoria() {
        try {
            EntityManager em = getEntityManager();
            List<Catstatuspedido> categoria = em.createQuery("SELECT c FROM Catstatuspedido c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
