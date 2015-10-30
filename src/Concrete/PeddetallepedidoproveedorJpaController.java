/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IPedDetallePedido;
import Concrete.exceptions.NonexistentEntityException;
import Model.Peddetallepedidoproveedor;
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
public class PeddetallepedidoproveedorJpaController implements Serializable, IPedDetallePedido {

    public PeddetallepedidoproveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PeddetallepedidoproveedorJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Peddetallepedidoproveedor peddetallepedidoproveedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedpedidoproveedor idpedpedidoproveedor = peddetallepedidoproveedor.getIdpedpedidoproveedor();
            if (idpedpedidoproveedor != null) {
                idpedpedidoproveedor = em.getReference(idpedpedidoproveedor.getClass(), idpedpedidoproveedor.getId());
                peddetallepedidoproveedor.setIdpedpedidoproveedor(idpedpedidoproveedor);
            }
            em.persist(peddetallepedidoproveedor);
            if (idpedpedidoproveedor != null) {
                idpedpedidoproveedor.getPeddetallepedidoproveedorList().add(peddetallepedidoproveedor);
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
    public void edit(Peddetallepedidoproveedor peddetallepedidoproveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Peddetallepedidoproveedor persistentPeddetallepedidoproveedor = em.find(Peddetallepedidoproveedor.class, peddetallepedidoproveedor.getId());
            Pedpedidoproveedor idpedpedidoproveedorOld = persistentPeddetallepedidoproveedor.getIdpedpedidoproveedor();
            Pedpedidoproveedor idpedpedidoproveedorNew = peddetallepedidoproveedor.getIdpedpedidoproveedor();
            if (idpedpedidoproveedorNew != null) {
                idpedpedidoproveedorNew = em.getReference(idpedpedidoproveedorNew.getClass(), idpedpedidoproveedorNew.getId());
                peddetallepedidoproveedor.setIdpedpedidoproveedor(idpedpedidoproveedorNew);
            }
            peddetallepedidoproveedor = em.merge(peddetallepedidoproveedor);
            if (idpedpedidoproveedorOld != null && !idpedpedidoproveedorOld.equals(idpedpedidoproveedorNew)) {
                idpedpedidoproveedorOld.getPeddetallepedidoproveedorList().remove(peddetallepedidoproveedor);
                idpedpedidoproveedorOld = em.merge(idpedpedidoproveedorOld);
            }
            if (idpedpedidoproveedorNew != null && !idpedpedidoproveedorNew.equals(idpedpedidoproveedorOld)) {
                idpedpedidoproveedorNew.getPeddetallepedidoproveedorList().add(peddetallepedidoproveedor);
                idpedpedidoproveedorNew = em.merge(idpedpedidoproveedorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = peddetallepedidoproveedor.getId();
                if (findPeddetallepedidoproveedor(id) == null) {
                    throw new NonexistentEntityException("The peddetallepedidoproveedor with id " + id + " no longer exists.");
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
            Peddetallepedidoproveedor peddetallepedidoproveedor;
            try {
                peddetallepedidoproveedor = em.getReference(Peddetallepedidoproveedor.class, id);
                peddetallepedidoproveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The peddetallepedidoproveedor with id " + id + " no longer exists.", enfe);
            }
            Pedpedidoproveedor idpedpedidoproveedor = peddetallepedidoproveedor.getIdpedpedidoproveedor();
            if (idpedpedidoproveedor != null) {
                idpedpedidoproveedor.getPeddetallepedidoproveedorList().remove(peddetallepedidoproveedor);
                idpedpedidoproveedor = em.merge(idpedpedidoproveedor);
            }
            em.remove(peddetallepedidoproveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Peddetallepedidoproveedor> findPeddetallepedidoproveedorEntities() {
        return findPeddetallepedidoproveedorEntities(true, -1, -1);
    }

    @Override
    public List<Peddetallepedidoproveedor> findPeddetallepedidoproveedorEntities(int maxResults, int firstResult) {
        return findPeddetallepedidoproveedorEntities(false, maxResults, firstResult);
    }

    private List<Peddetallepedidoproveedor> findPeddetallepedidoproveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Peddetallepedidoproveedor.class));
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
    public Peddetallepedidoproveedor findPeddetallepedidoproveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Peddetallepedidoproveedor.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getPeddetallepedidoproveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Peddetallepedidoproveedor> rt = cq.from(Peddetallepedidoproveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
