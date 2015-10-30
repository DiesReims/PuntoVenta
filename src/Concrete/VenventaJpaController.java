/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IVenVenta;
import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Vendetalleventa;
import Model.Venventa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dies
 */
public class VenventaJpaController implements Serializable, IVenVenta {

    public VenventaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public VenventaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Venventa venventa) {
        if (venventa.getVendetalleventaList() == null) {
            venventa.setVendetalleventaList(new ArrayList<Vendetalleventa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Vendetalleventa> attachedVendetalleventaList = new ArrayList<Vendetalleventa>();
            for (Vendetalleventa vendetalleventaListVendetalleventaToAttach : venventa.getVendetalleventaList()) {
                vendetalleventaListVendetalleventaToAttach = em.getReference(vendetalleventaListVendetalleventaToAttach.getClass(), vendetalleventaListVendetalleventaToAttach.getId());
                attachedVendetalleventaList.add(vendetalleventaListVendetalleventaToAttach);
            }
            venventa.setVendetalleventaList(attachedVendetalleventaList);
            em.persist(venventa);
            for (Vendetalleventa vendetalleventaListVendetalleventa : venventa.getVendetalleventaList()) {
                Venventa oldIdvenventaOfVendetalleventaListVendetalleventa = vendetalleventaListVendetalleventa.getIdvenventa();
                vendetalleventaListVendetalleventa.setIdvenventa(venventa);
                vendetalleventaListVendetalleventa = em.merge(vendetalleventaListVendetalleventa);
                if (oldIdvenventaOfVendetalleventaListVendetalleventa != null) {
                    oldIdvenventaOfVendetalleventaListVendetalleventa.getVendetalleventaList().remove(vendetalleventaListVendetalleventa);
                    oldIdvenventaOfVendetalleventaListVendetalleventa = em.merge(oldIdvenventaOfVendetalleventaListVendetalleventa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Venventa venventa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venventa persistentVenventa = em.find(Venventa.class, venventa.getId());
            List<Vendetalleventa> vendetalleventaListOld = persistentVenventa.getVendetalleventaList();
            List<Vendetalleventa> vendetalleventaListNew = venventa.getVendetalleventaList();
            List<String> illegalOrphanMessages = null;
            for (Vendetalleventa vendetalleventaListOldVendetalleventa : vendetalleventaListOld) {
                if (!vendetalleventaListNew.contains(vendetalleventaListOldVendetalleventa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vendetalleventa " + vendetalleventaListOldVendetalleventa + " since its idvenventa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Vendetalleventa> attachedVendetalleventaListNew = new ArrayList<Vendetalleventa>();
            for (Vendetalleventa vendetalleventaListNewVendetalleventaToAttach : vendetalleventaListNew) {
                vendetalleventaListNewVendetalleventaToAttach = em.getReference(vendetalleventaListNewVendetalleventaToAttach.getClass(), vendetalleventaListNewVendetalleventaToAttach.getId());
                attachedVendetalleventaListNew.add(vendetalleventaListNewVendetalleventaToAttach);
            }
            vendetalleventaListNew = attachedVendetalleventaListNew;
            venventa.setVendetalleventaList(vendetalleventaListNew);
            venventa = em.merge(venventa);
            for (Vendetalleventa vendetalleventaListNewVendetalleventa : vendetalleventaListNew) {
                if (!vendetalleventaListOld.contains(vendetalleventaListNewVendetalleventa)) {
                    Venventa oldIdvenventaOfVendetalleventaListNewVendetalleventa = vendetalleventaListNewVendetalleventa.getIdvenventa();
                    vendetalleventaListNewVendetalleventa.setIdvenventa(venventa);
                    vendetalleventaListNewVendetalleventa = em.merge(vendetalleventaListNewVendetalleventa);
                    if (oldIdvenventaOfVendetalleventaListNewVendetalleventa != null && !oldIdvenventaOfVendetalleventaListNewVendetalleventa.equals(venventa)) {
                        oldIdvenventaOfVendetalleventaListNewVendetalleventa.getVendetalleventaList().remove(vendetalleventaListNewVendetalleventa);
                        oldIdvenventaOfVendetalleventaListNewVendetalleventa = em.merge(oldIdvenventaOfVendetalleventaListNewVendetalleventa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venventa.getId();
                if (findVenventa(id) == null) {
                    throw new NonexistentEntityException("The venventa with id " + id + " no longer exists.");
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
    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venventa venventa;
            try {
                venventa = em.getReference(Venventa.class, id);
                venventa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venventa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Vendetalleventa> vendetalleventaListOrphanCheck = venventa.getVendetalleventaList();
            for (Vendetalleventa vendetalleventaListOrphanCheckVendetalleventa : vendetalleventaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Venventa (" + venventa + ") cannot be destroyed since the Vendetalleventa " + vendetalleventaListOrphanCheckVendetalleventa + " in its vendetalleventaList field has a non-nullable idvenventa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(venventa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Venventa> findVenventaEntities() {
        return findVenventaEntities(true, -1, -1);
    }

    @Override
    public List<Venventa> findVenventaEntities(int maxResults, int firstResult) {
        return findVenventaEntities(false, maxResults, firstResult);
    }

    private List<Venventa> findVenventaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venventa.class));
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
    public Venventa findVenventa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venventa.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getVenventaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venventa> rt = cq.from(Venventa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
