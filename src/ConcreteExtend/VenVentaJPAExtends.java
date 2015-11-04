/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ConcreteExtend;

import Model.Venventa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class VenVentaJPAExtends {
        private EntityManagerFactory emf = null;

    public VenVentaJPAExtends() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Venventa findVentabyfolio(int id, String folio) {
        try {
            EntityManager em = getEntityManager();
            Venventa categoria = (Venventa) em.createQuery("SELECT c FROM Venventa c WHERE c.id = :id and c.strFolio :strFolio")
                    .setParameter("id", id)
                    .setParameter("strFolio", folio)
                    .getSingleResult();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Venventa> findAllProveedor() {
        try {
            EntityManager em = getEntityManager();
            List<Venventa> categoria = em.createQuery("SELECT c FROM Venventa c").getResultList();
            return categoria;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

}