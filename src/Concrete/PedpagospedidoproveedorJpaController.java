/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IPedPagosPedidoProveedor;
import Concrete.exceptions.NonexistentEntityException;
import Model.Pedpagospedidoproveedor;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Pedpedidoproveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dies
 */
public class PedpagospedidoproveedorJpaController implements Serializable, IPedPagosPedidoProveedor {

    public PedpagospedidoproveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PedpagospedidoproveedorJpaController() {
         this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    

    @Override
    public void create(Pedpagospedidoproveedor pedpagospedidoproveedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedpedidoproveedor idpedpedidoproveedor = pedpagospedidoproveedor.getIdpedpedidoproveedor();
            if (idpedpedidoproveedor != null) {
                idpedpedidoproveedor = em.getReference(idpedpedidoproveedor.getClass(), idpedpedidoproveedor.getId());
                pedpagospedidoproveedor.setIdpedpedidoproveedor(idpedpedidoproveedor);
            }
            em.persist(pedpagospedidoproveedor);
            if (idpedpedidoproveedor != null) {
                idpedpedidoproveedor.getPedpagospedidoproveedorList().add(pedpagospedidoproveedor);
                idpedpedidoproveedor = em.merge(idpedpedidoproveedor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Pedpagospedidoproveedor pedpagospedidoproveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedpagospedidoproveedor persistentPedpagospedidoproveedor = em.find(Pedpagospedidoproveedor.class, pedpagospedidoproveedor.getId());
            Pedpedidoproveedor idpedpedidoproveedorOld = persistentPedpagospedidoproveedor.getIdpedpedidoproveedor();
            Pedpedidoproveedor idpedpedidoproveedorNew = pedpagospedidoproveedor.getIdpedpedidoproveedor();
            if (idpedpedidoproveedorNew != null) {
                idpedpedidoproveedorNew = em.getReference(idpedpedidoproveedorNew.getClass(), idpedpedidoproveedorNew.getId());
                pedpagospedidoproveedor.setIdpedpedidoproveedor(idpedpedidoproveedorNew);
            }
            pedpagospedidoproveedor = em.merge(pedpagospedidoproveedor);
            if (idpedpedidoproveedorOld != null && !idpedpedidoproveedorOld.equals(idpedpedidoproveedorNew)) {
                idpedpedidoproveedorOld.getPedpagospedidoproveedorList().remove(pedpagospedidoproveedor);
                idpedpedidoproveedorOld = em.merge(idpedpedidoproveedorOld);
            }
            if (idpedpedidoproveedorNew != null && !idpedpedidoproveedorNew.equals(idpedpedidoproveedorOld)) {
                idpedpedidoproveedorNew.getPedpagospedidoproveedorList().add(pedpagospedidoproveedor);
                idpedpedidoproveedorNew = em.merge(idpedpedidoproveedorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pedpagospedidoproveedor.getId();
                if (findPedpagospedidoproveedor(id) == null) {
                    throw new NonexistentEntityException("The pedpagospedidoproveedor with id " + id + " no longer exists.");
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
            Pedpagospedidoproveedor pedpagospedidoproveedor;
            try {
                pedpagospedidoproveedor = em.getReference(Pedpagospedidoproveedor.class, id);
                pedpagospedidoproveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedpagospedidoproveedor with id " + id + " no longer exists.", enfe);
            }
            Pedpedidoproveedor idpedpedidoproveedor = pedpagospedidoproveedor.getIdpedpedidoproveedor();
            if (idpedpedidoproveedor != null) {
                idpedpedidoproveedor.getPedpagospedidoproveedorList().remove(pedpagospedidoproveedor);
                idpedpedidoproveedor = em.merge(idpedpedidoproveedor);
            }
            em.remove(pedpagospedidoproveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Pedpagospedidoproveedor> findPedpagospedidoproveedorEntities() {
        return findPedpagospedidoproveedorEntities(true, -1, -1);
    }

    @Override
    public List<Pedpagospedidoproveedor> findPedpagospedidoproveedorEntities(int maxResults, int firstResult) {
        return findPedpagospedidoproveedorEntities(false, maxResults, firstResult);
    }

    private List<Pedpagospedidoproveedor> findPedpagospedidoproveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedpagospedidoproveedor.class));
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
    public Pedpagospedidoproveedor findPedpagospedidoproveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedpagospedidoproveedor.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getPedpagospedidoproveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedpagospedidoproveedor> rt = cq.from(Pedpagospedidoproveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
