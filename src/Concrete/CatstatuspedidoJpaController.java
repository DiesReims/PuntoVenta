/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.ICatStatusPedido;
import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Catstatuspedido;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Pedpedidoproveedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dies
 */
public class CatstatuspedidoJpaController implements Serializable, ICatStatusPedido {

    public CatstatuspedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Catstatuspedido catstatuspedido) {
        if (catstatuspedido.getPedpedidoproveedorList() == null) {
            catstatuspedido.setPedpedidoproveedorList(new ArrayList<Pedpedidoproveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Pedpedidoproveedor> attachedPedpedidoproveedorList = new ArrayList<Pedpedidoproveedor>();
            for (Pedpedidoproveedor pedpedidoproveedorListPedpedidoproveedorToAttach : catstatuspedido.getPedpedidoproveedorList()) {
                pedpedidoproveedorListPedpedidoproveedorToAttach = em.getReference(pedpedidoproveedorListPedpedidoproveedorToAttach.getClass(), pedpedidoproveedorListPedpedidoproveedorToAttach.getId());
                attachedPedpedidoproveedorList.add(pedpedidoproveedorListPedpedidoproveedorToAttach);
            }
            catstatuspedido.setPedpedidoproveedorList(attachedPedpedidoproveedorList);
            em.persist(catstatuspedido);
            for (Pedpedidoproveedor pedpedidoproveedorListPedpedidoproveedor : catstatuspedido.getPedpedidoproveedorList()) {
                Catstatuspedido oldIdcatstatuspedidoOfPedpedidoproveedorListPedpedidoproveedor = pedpedidoproveedorListPedpedidoproveedor.getIdcatstatuspedido();
                pedpedidoproveedorListPedpedidoproveedor.setIdcatstatuspedido(catstatuspedido);
                pedpedidoproveedorListPedpedidoproveedor = em.merge(pedpedidoproveedorListPedpedidoproveedor);
                if (oldIdcatstatuspedidoOfPedpedidoproveedorListPedpedidoproveedor != null) {
                    oldIdcatstatuspedidoOfPedpedidoproveedorListPedpedidoproveedor.getPedpedidoproveedorList().remove(pedpedidoproveedorListPedpedidoproveedor);
                    oldIdcatstatuspedidoOfPedpedidoproveedorListPedpedidoproveedor = em.merge(oldIdcatstatuspedidoOfPedpedidoproveedorListPedpedidoproveedor);
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
    public void edit(Catstatuspedido catstatuspedido) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Catstatuspedido persistentCatstatuspedido = em.find(Catstatuspedido.class, catstatuspedido.getId());
            List<Pedpedidoproveedor> pedpedidoproveedorListOld = persistentCatstatuspedido.getPedpedidoproveedorList();
            List<Pedpedidoproveedor> pedpedidoproveedorListNew = catstatuspedido.getPedpedidoproveedorList();
            List<String> illegalOrphanMessages = null;
            for (Pedpedidoproveedor pedpedidoproveedorListOldPedpedidoproveedor : pedpedidoproveedorListOld) {
                if (!pedpedidoproveedorListNew.contains(pedpedidoproveedorListOldPedpedidoproveedor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedpedidoproveedor " + pedpedidoproveedorListOldPedpedidoproveedor + " since its idcatstatuspedido field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Pedpedidoproveedor> attachedPedpedidoproveedorListNew = new ArrayList<Pedpedidoproveedor>();
            for (Pedpedidoproveedor pedpedidoproveedorListNewPedpedidoproveedorToAttach : pedpedidoproveedorListNew) {
                pedpedidoproveedorListNewPedpedidoproveedorToAttach = em.getReference(pedpedidoproveedorListNewPedpedidoproveedorToAttach.getClass(), pedpedidoproveedorListNewPedpedidoproveedorToAttach.getId());
                attachedPedpedidoproveedorListNew.add(pedpedidoproveedorListNewPedpedidoproveedorToAttach);
            }
            pedpedidoproveedorListNew = attachedPedpedidoproveedorListNew;
            catstatuspedido.setPedpedidoproveedorList(pedpedidoproveedorListNew);
            catstatuspedido = em.merge(catstatuspedido);
            for (Pedpedidoproveedor pedpedidoproveedorListNewPedpedidoproveedor : pedpedidoproveedorListNew) {
                if (!pedpedidoproveedorListOld.contains(pedpedidoproveedorListNewPedpedidoproveedor)) {
                    Catstatuspedido oldIdcatstatuspedidoOfPedpedidoproveedorListNewPedpedidoproveedor = pedpedidoproveedorListNewPedpedidoproveedor.getIdcatstatuspedido();
                    pedpedidoproveedorListNewPedpedidoproveedor.setIdcatstatuspedido(catstatuspedido);
                    pedpedidoproveedorListNewPedpedidoproveedor = em.merge(pedpedidoproveedorListNewPedpedidoproveedor);
                    if (oldIdcatstatuspedidoOfPedpedidoproveedorListNewPedpedidoproveedor != null && !oldIdcatstatuspedidoOfPedpedidoproveedorListNewPedpedidoproveedor.equals(catstatuspedido)) {
                        oldIdcatstatuspedidoOfPedpedidoproveedorListNewPedpedidoproveedor.getPedpedidoproveedorList().remove(pedpedidoproveedorListNewPedpedidoproveedor);
                        oldIdcatstatuspedidoOfPedpedidoproveedorListNewPedpedidoproveedor = em.merge(oldIdcatstatuspedidoOfPedpedidoproveedorListNewPedpedidoproveedor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = catstatuspedido.getId();
                if (findCatstatuspedido(id) == null) {
                    throw new NonexistentEntityException("The catstatuspedido with id " + id + " no longer exists.");
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
            Catstatuspedido catstatuspedido;
            try {
                catstatuspedido = em.getReference(Catstatuspedido.class, id);
                catstatuspedido.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The catstatuspedido with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pedpedidoproveedor> pedpedidoproveedorListOrphanCheck = catstatuspedido.getPedpedidoproveedorList();
            for (Pedpedidoproveedor pedpedidoproveedorListOrphanCheckPedpedidoproveedor : pedpedidoproveedorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Catstatuspedido (" + catstatuspedido + ") cannot be destroyed since the Pedpedidoproveedor " + pedpedidoproveedorListOrphanCheckPedpedidoproveedor + " in its pedpedidoproveedorList field has a non-nullable idcatstatuspedido field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(catstatuspedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Catstatuspedido> findCatstatuspedidoEntities() {
        return findCatstatuspedidoEntities(true, -1, -1);
    }

    @Override
    public List<Catstatuspedido> findCatstatuspedidoEntities(int maxResults, int firstResult) {
        return findCatstatuspedidoEntities(false, maxResults, firstResult);
    }

    private List<Catstatuspedido> findCatstatuspedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Catstatuspedido.class));
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
    public Catstatuspedido findCatstatuspedido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Catstatuspedido.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getCatstatuspedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Catstatuspedido> rt = cq.from(Catstatuspedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
