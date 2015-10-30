/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IVenDetalleVenta;
import Concrete.exceptions.NonexistentEntityException;
import Model.Vendetalleventa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Venventa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dies
 */
public class VendetalleventaJpaController implements Serializable, IVenDetalleVenta {

    public VendetalleventaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public VendetalleventaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Vendetalleventa vendetalleventa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venventa idvenventa = vendetalleventa.getIdvenventa();
            if (idvenventa != null) {
                idvenventa = em.getReference(idvenventa.getClass(), idvenventa.getId());
                vendetalleventa.setIdvenventa(idvenventa);
            }
            em.persist(vendetalleventa);
            if (idvenventa != null) {
                idvenventa.getVendetalleventaList().add(vendetalleventa);
                idvenventa = em.merge(idvenventa);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Vendetalleventa vendetalleventa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendetalleventa persistentVendetalleventa = em.find(Vendetalleventa.class, vendetalleventa.getId());
            Venventa idvenventaOld = persistentVendetalleventa.getIdvenventa();
            Venventa idvenventaNew = vendetalleventa.getIdvenventa();
            if (idvenventaNew != null) {
                idvenventaNew = em.getReference(idvenventaNew.getClass(), idvenventaNew.getId());
                vendetalleventa.setIdvenventa(idvenventaNew);
            }
            vendetalleventa = em.merge(vendetalleventa);
            if (idvenventaOld != null && !idvenventaOld.equals(idvenventaNew)) {
                idvenventaOld.getVendetalleventaList().remove(vendetalleventa);
                idvenventaOld = em.merge(idvenventaOld);
            }
            if (idvenventaNew != null && !idvenventaNew.equals(idvenventaOld)) {
                idvenventaNew.getVendetalleventaList().add(vendetalleventa);
                idvenventaNew = em.merge(idvenventaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vendetalleventa.getId();
                if (findVendetalleventa(id) == null) {
                    throw new NonexistentEntityException("The vendetalleventa with id " + id + " no longer exists.");
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
            Vendetalleventa vendetalleventa;
            try {
                vendetalleventa = em.getReference(Vendetalleventa.class, id);
                vendetalleventa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendetalleventa with id " + id + " no longer exists.", enfe);
            }
            Venventa idvenventa = vendetalleventa.getIdvenventa();
            if (idvenventa != null) {
                idvenventa.getVendetalleventaList().remove(vendetalleventa);
                idvenventa = em.merge(idvenventa);
            }
            em.remove(vendetalleventa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Vendetalleventa> findVendetalleventaEntities() {
        return findVendetalleventaEntities(true, -1, -1);
    }

    @Override
    public List<Vendetalleventa> findVendetalleventaEntities(int maxResults, int firstResult) {
        return findVendetalleventaEntities(false, maxResults, firstResult);
    }

    private List<Vendetalleventa> findVendetalleventaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendetalleventa.class));
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
    public Vendetalleventa findVendetalleventa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendetalleventa.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getVendetalleventaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendetalleventa> rt = cq.from(Vendetalleventa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
