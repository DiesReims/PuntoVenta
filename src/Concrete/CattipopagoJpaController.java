/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.ICatTipoPago;
import Concrete.exceptions.NonexistentEntityException;
import Model.Cattipopago;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Dies
 */
public class CattipopagoJpaController implements Serializable, ICatTipoPago {

    public CattipopagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CattipopagoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Cattipopago cattipopago) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cattipopago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Cattipopago cattipopago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cattipopago = em.merge(cattipopago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cattipopago.getId();
                if (findCattipopago(id) == null) {
                    throw new NonexistentEntityException("The cattipopago with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cattipopago cattipopago;
            try {
                cattipopago = em.getReference(Cattipopago.class, id);
                cattipopago.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cattipopago with id " + id + " no longer exists.", enfe);
            }
            em.remove(cattipopago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Cattipopago> findCattipopagoEntities() {
        return findCattipopagoEntities(true, -1, -1);
    }

    @Override
    public List<Cattipopago> findCattipopagoEntities(int maxResults, int firstResult) {
        return findCattipopagoEntities(false, maxResults, firstResult);
    }

    private List<Cattipopago> findCattipopagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cattipopago.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Cattipopago findCattipopago(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cattipopago.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getCattipopagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cattipopago> rt = cq.from(Cattipopago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
