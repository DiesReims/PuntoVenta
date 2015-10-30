/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IPedPedidoProveedor;
import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Catstatuspedido;
import Model.Pedpagospedidoproveedor;
import java.util.ArrayList;
import java.util.List;
import Model.Peddetallepedidoproveedor;
import Model.Pedpedidoproveedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dies
 */
public class PedpedidoproveedorJpaController implements Serializable, IPedPedidoProveedor {

    public PedpedidoproveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PedpedidoproveedorJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Pedpedidoproveedor pedpedidoproveedor) {
        if (pedpedidoproveedor.getPedpagospedidoproveedorList() == null) {
            pedpedidoproveedor.setPedpagospedidoproveedorList(new ArrayList<Pedpagospedidoproveedor>());
        }
        if (pedpedidoproveedor.getPeddetallepedidoproveedorList() == null) {
            pedpedidoproveedor.setPeddetallepedidoproveedorList(new ArrayList<Peddetallepedidoproveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Catstatuspedido idcatstatuspedido = pedpedidoproveedor.getIdcatstatuspedido();
            if (idcatstatuspedido != null) {
                idcatstatuspedido = em.getReference(idcatstatuspedido.getClass(), idcatstatuspedido.getId());
                pedpedidoproveedor.setIdcatstatuspedido(idcatstatuspedido);
            }
            List<Pedpagospedidoproveedor> attachedPedpagospedidoproveedorList = new ArrayList<Pedpagospedidoproveedor>();
            for (Pedpagospedidoproveedor pedpagospedidoproveedorListPedpagospedidoproveedorToAttach : pedpedidoproveedor.getPedpagospedidoproveedorList()) {
                pedpagospedidoproveedorListPedpagospedidoproveedorToAttach = em.getReference(pedpagospedidoproveedorListPedpagospedidoproveedorToAttach.getClass(), pedpagospedidoproveedorListPedpagospedidoproveedorToAttach.getId());
                attachedPedpagospedidoproveedorList.add(pedpagospedidoproveedorListPedpagospedidoproveedorToAttach);
            }
            pedpedidoproveedor.setPedpagospedidoproveedorList(attachedPedpagospedidoproveedorList);
            List<Peddetallepedidoproveedor> attachedPeddetallepedidoproveedorList = new ArrayList<Peddetallepedidoproveedor>();
            for (Peddetallepedidoproveedor peddetallepedidoproveedorListPeddetallepedidoproveedorToAttach : pedpedidoproveedor.getPeddetallepedidoproveedorList()) {
                peddetallepedidoproveedorListPeddetallepedidoproveedorToAttach = em.getReference(peddetallepedidoproveedorListPeddetallepedidoproveedorToAttach.getClass(), peddetallepedidoproveedorListPeddetallepedidoproveedorToAttach.getId());
                attachedPeddetallepedidoproveedorList.add(peddetallepedidoproveedorListPeddetallepedidoproveedorToAttach);
            }
            pedpedidoproveedor.setPeddetallepedidoproveedorList(attachedPeddetallepedidoproveedorList);
            em.persist(pedpedidoproveedor);
            if (idcatstatuspedido != null) {
                idcatstatuspedido.getPedpedidoproveedorList().add(pedpedidoproveedor);
                idcatstatuspedido = em.merge(idcatstatuspedido);
            }
            for (Pedpagospedidoproveedor pedpagospedidoproveedorListPedpagospedidoproveedor : pedpedidoproveedor.getPedpagospedidoproveedorList()) {
                Pedpedidoproveedor oldIdpedpedidoproveedorOfPedpagospedidoproveedorListPedpagospedidoproveedor = pedpagospedidoproveedorListPedpagospedidoproveedor.getIdpedpedidoproveedor();
                pedpagospedidoproveedorListPedpagospedidoproveedor.setIdpedpedidoproveedor(pedpedidoproveedor);
                pedpagospedidoproveedorListPedpagospedidoproveedor = em.merge(pedpagospedidoproveedorListPedpagospedidoproveedor);
                if (oldIdpedpedidoproveedorOfPedpagospedidoproveedorListPedpagospedidoproveedor != null) {
                    oldIdpedpedidoproveedorOfPedpagospedidoproveedorListPedpagospedidoproveedor.getPedpagospedidoproveedorList().remove(pedpagospedidoproveedorListPedpagospedidoproveedor);
                    oldIdpedpedidoproveedorOfPedpagospedidoproveedorListPedpagospedidoproveedor = em.merge(oldIdpedpedidoproveedorOfPedpagospedidoproveedorListPedpagospedidoproveedor);
                }
            }
            for (Peddetallepedidoproveedor peddetallepedidoproveedorListPeddetallepedidoproveedor : pedpedidoproveedor.getPeddetallepedidoproveedorList()) {
                Pedpedidoproveedor oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListPeddetallepedidoproveedor = peddetallepedidoproveedorListPeddetallepedidoproveedor.getIdpedpedidoproveedor();
                peddetallepedidoproveedorListPeddetallepedidoproveedor.setIdpedpedidoproveedor(pedpedidoproveedor);
                peddetallepedidoproveedorListPeddetallepedidoproveedor = em.merge(peddetallepedidoproveedorListPeddetallepedidoproveedor);
                if (oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListPeddetallepedidoproveedor != null) {
                    oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListPeddetallepedidoproveedor.getPeddetallepedidoproveedorList().remove(peddetallepedidoproveedorListPeddetallepedidoproveedor);
                    oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListPeddetallepedidoproveedor = em.merge(oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListPeddetallepedidoproveedor);
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
    public void edit(Pedpedidoproveedor pedpedidoproveedor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedpedidoproveedor persistentPedpedidoproveedor = em.find(Pedpedidoproveedor.class, pedpedidoproveedor.getId());
            Catstatuspedido idcatstatuspedidoOld = persistentPedpedidoproveedor.getIdcatstatuspedido();
            Catstatuspedido idcatstatuspedidoNew = pedpedidoproveedor.getIdcatstatuspedido();
            List<Pedpagospedidoproveedor> pedpagospedidoproveedorListOld = persistentPedpedidoproveedor.getPedpagospedidoproveedorList();
            List<Pedpagospedidoproveedor> pedpagospedidoproveedorListNew = pedpedidoproveedor.getPedpagospedidoproveedorList();
            List<Peddetallepedidoproveedor> peddetallepedidoproveedorListOld = persistentPedpedidoproveedor.getPeddetallepedidoproveedorList();
            List<Peddetallepedidoproveedor> peddetallepedidoproveedorListNew = pedpedidoproveedor.getPeddetallepedidoproveedorList();
            List<String> illegalOrphanMessages = null;
            for (Pedpagospedidoproveedor pedpagospedidoproveedorListOldPedpagospedidoproveedor : pedpagospedidoproveedorListOld) {
                if (!pedpagospedidoproveedorListNew.contains(pedpagospedidoproveedorListOldPedpagospedidoproveedor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedpagospedidoproveedor " + pedpagospedidoproveedorListOldPedpagospedidoproveedor + " since its idpedpedidoproveedor field is not nullable.");
                }
            }
            for (Peddetallepedidoproveedor peddetallepedidoproveedorListOldPeddetallepedidoproveedor : peddetallepedidoproveedorListOld) {
                if (!peddetallepedidoproveedorListNew.contains(peddetallepedidoproveedorListOldPeddetallepedidoproveedor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Peddetallepedidoproveedor " + peddetallepedidoproveedorListOldPeddetallepedidoproveedor + " since its idpedpedidoproveedor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idcatstatuspedidoNew != null) {
                idcatstatuspedidoNew = em.getReference(idcatstatuspedidoNew.getClass(), idcatstatuspedidoNew.getId());
                pedpedidoproveedor.setIdcatstatuspedido(idcatstatuspedidoNew);
            }
            List<Pedpagospedidoproveedor> attachedPedpagospedidoproveedorListNew = new ArrayList<Pedpagospedidoproveedor>();
            for (Pedpagospedidoproveedor pedpagospedidoproveedorListNewPedpagospedidoproveedorToAttach : pedpagospedidoproveedorListNew) {
                pedpagospedidoproveedorListNewPedpagospedidoproveedorToAttach = em.getReference(pedpagospedidoproveedorListNewPedpagospedidoproveedorToAttach.getClass(), pedpagospedidoproveedorListNewPedpagospedidoproveedorToAttach.getId());
                attachedPedpagospedidoproveedorListNew.add(pedpagospedidoproveedorListNewPedpagospedidoproveedorToAttach);
            }
            pedpagospedidoproveedorListNew = attachedPedpagospedidoproveedorListNew;
            pedpedidoproveedor.setPedpagospedidoproveedorList(pedpagospedidoproveedorListNew);
            List<Peddetallepedidoproveedor> attachedPeddetallepedidoproveedorListNew = new ArrayList<Peddetallepedidoproveedor>();
            for (Peddetallepedidoproveedor peddetallepedidoproveedorListNewPeddetallepedidoproveedorToAttach : peddetallepedidoproveedorListNew) {
                peddetallepedidoproveedorListNewPeddetallepedidoproveedorToAttach = em.getReference(peddetallepedidoproveedorListNewPeddetallepedidoproveedorToAttach.getClass(), peddetallepedidoproveedorListNewPeddetallepedidoproveedorToAttach.getId());
                attachedPeddetallepedidoproveedorListNew.add(peddetallepedidoproveedorListNewPeddetallepedidoproveedorToAttach);
            }
            peddetallepedidoproveedorListNew = attachedPeddetallepedidoproveedorListNew;
            pedpedidoproveedor.setPeddetallepedidoproveedorList(peddetallepedidoproveedorListNew);
            pedpedidoproveedor = em.merge(pedpedidoproveedor);
            if (idcatstatuspedidoOld != null && !idcatstatuspedidoOld.equals(idcatstatuspedidoNew)) {
                idcatstatuspedidoOld.getPedpedidoproveedorList().remove(pedpedidoproveedor);
                idcatstatuspedidoOld = em.merge(idcatstatuspedidoOld);
            }
            if (idcatstatuspedidoNew != null && !idcatstatuspedidoNew.equals(idcatstatuspedidoOld)) {
                idcatstatuspedidoNew.getPedpedidoproveedorList().add(pedpedidoproveedor);
                idcatstatuspedidoNew = em.merge(idcatstatuspedidoNew);
            }
            for (Pedpagospedidoproveedor pedpagospedidoproveedorListNewPedpagospedidoproveedor : pedpagospedidoproveedorListNew) {
                if (!pedpagospedidoproveedorListOld.contains(pedpagospedidoproveedorListNewPedpagospedidoproveedor)) {
                    Pedpedidoproveedor oldIdpedpedidoproveedorOfPedpagospedidoproveedorListNewPedpagospedidoproveedor = pedpagospedidoproveedorListNewPedpagospedidoproveedor.getIdpedpedidoproveedor();
                    pedpagospedidoproveedorListNewPedpagospedidoproveedor.setIdpedpedidoproveedor(pedpedidoproveedor);
                    pedpagospedidoproveedorListNewPedpagospedidoproveedor = em.merge(pedpagospedidoproveedorListNewPedpagospedidoproveedor);
                    if (oldIdpedpedidoproveedorOfPedpagospedidoproveedorListNewPedpagospedidoproveedor != null && !oldIdpedpedidoproveedorOfPedpagospedidoproveedorListNewPedpagospedidoproveedor.equals(pedpedidoproveedor)) {
                        oldIdpedpedidoproveedorOfPedpagospedidoproveedorListNewPedpagospedidoproveedor.getPedpagospedidoproveedorList().remove(pedpagospedidoproveedorListNewPedpagospedidoproveedor);
                        oldIdpedpedidoproveedorOfPedpagospedidoproveedorListNewPedpagospedidoproveedor = em.merge(oldIdpedpedidoproveedorOfPedpagospedidoproveedorListNewPedpagospedidoproveedor);
                    }
                }
            }
            for (Peddetallepedidoproveedor peddetallepedidoproveedorListNewPeddetallepedidoproveedor : peddetallepedidoproveedorListNew) {
                if (!peddetallepedidoproveedorListOld.contains(peddetallepedidoproveedorListNewPeddetallepedidoproveedor)) {
                    Pedpedidoproveedor oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListNewPeddetallepedidoproveedor = peddetallepedidoproveedorListNewPeddetallepedidoproveedor.getIdpedpedidoproveedor();
                    peddetallepedidoproveedorListNewPeddetallepedidoproveedor.setIdpedpedidoproveedor(pedpedidoproveedor);
                    peddetallepedidoproveedorListNewPeddetallepedidoproveedor = em.merge(peddetallepedidoproveedorListNewPeddetallepedidoproveedor);
                    if (oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListNewPeddetallepedidoproveedor != null && !oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListNewPeddetallepedidoproveedor.equals(pedpedidoproveedor)) {
                        oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListNewPeddetallepedidoproveedor.getPeddetallepedidoproveedorList().remove(peddetallepedidoproveedorListNewPeddetallepedidoproveedor);
                        oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListNewPeddetallepedidoproveedor = em.merge(oldIdpedpedidoproveedorOfPeddetallepedidoproveedorListNewPeddetallepedidoproveedor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pedpedidoproveedor.getId();
                if (findPedpedidoproveedor(id) == null) {
                    throw new NonexistentEntityException("The pedpedidoproveedor with id " + id + " no longer exists.");
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
            Pedpedidoproveedor pedpedidoproveedor;
            try {
                pedpedidoproveedor = em.getReference(Pedpedidoproveedor.class, id);
                pedpedidoproveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedpedidoproveedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pedpagospedidoproveedor> pedpagospedidoproveedorListOrphanCheck = pedpedidoproveedor.getPedpagospedidoproveedorList();
            for (Pedpagospedidoproveedor pedpagospedidoproveedorListOrphanCheckPedpagospedidoproveedor : pedpagospedidoproveedorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedpedidoproveedor (" + pedpedidoproveedor + ") cannot be destroyed since the Pedpagospedidoproveedor " + pedpagospedidoproveedorListOrphanCheckPedpagospedidoproveedor + " in its pedpagospedidoproveedorList field has a non-nullable idpedpedidoproveedor field.");
            }
            List<Peddetallepedidoproveedor> peddetallepedidoproveedorListOrphanCheck = pedpedidoproveedor.getPeddetallepedidoproveedorList();
            for (Peddetallepedidoproveedor peddetallepedidoproveedorListOrphanCheckPeddetallepedidoproveedor : peddetallepedidoproveedorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedpedidoproveedor (" + pedpedidoproveedor + ") cannot be destroyed since the Peddetallepedidoproveedor " + peddetallepedidoproveedorListOrphanCheckPeddetallepedidoproveedor + " in its peddetallepedidoproveedorList field has a non-nullable idpedpedidoproveedor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Catstatuspedido idcatstatuspedido = pedpedidoproveedor.getIdcatstatuspedido();
            if (idcatstatuspedido != null) {
                idcatstatuspedido.getPedpedidoproveedorList().remove(pedpedidoproveedor);
                idcatstatuspedido = em.merge(idcatstatuspedido);
            }
            em.remove(pedpedidoproveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Pedpedidoproveedor> findPedpedidoproveedorEntities() {
        return findPedpedidoproveedorEntities(true, -1, -1);
    }

    @Override
    public List<Pedpedidoproveedor> findPedpedidoproveedorEntities(int maxResults, int firstResult) {
        return findPedpedidoproveedorEntities(false, maxResults, firstResult);
    }

    private List<Pedpedidoproveedor> findPedpedidoproveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedpedidoproveedor.class));
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
    public Pedpedidoproveedor findPedpedidoproveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedpedidoproveedor.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getPedpedidoproveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedpedidoproveedor> rt = cq.from(Pedpedidoproveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
