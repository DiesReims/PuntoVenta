package ConcreteExtend;

import Model.Cattipoproducto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CatTipoProductoJPAExtends {

    private EntityManagerFactory emf = null;

    public CatTipoProductoJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Cattipoproducto findCategoriabyValor(int id, String valor) {
        try {
            EntityManager em = getEntityManager();
            Cattipoproducto categoria = (Cattipoproducto) em.createQuery("SELECT c FROM Cattipoproducto c WHERE c.id = :id and c.strValor :strValor")
                    .setParameter("id", id)
                    .setParameter("strValor", valor)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Cattipoproducto> findAllcategoria() {
        try {
            EntityManager em = getEntityManager();
            List<Cattipoproducto> categoria = em.createQuery("SELECT c FROM Cattipoproducto c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}
