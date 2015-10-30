/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.ICatTipoProveedor;
import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Cattipoproveedor;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Proproveedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dies
 */
public class CattipoproveedorJpaController implements Serializable, ICatTipoProveedor {

    public CattipoproveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CattipoproveedorJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Cattipoproveedor cattipoproveedor) {
        if (cattipoproveedor.getProproveedorList() == null) {
            cattipoproveedor.setProproveedorList(new ArrayList<Proproveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proproveedor> attachedProproveedorList = new ArrayList<Proproveedor>();
            for (Proproveedor proproveedorListProproveedorToAttach : cattipoproveedor.getProproveedorList()) {
                proproveedorListProproveedorToAttach = em.getReference(proproveedorListProproveedorToAttach.getClass(), proproveedorListProproveedorToAttach.getId());
                attachedProproveedorList.add(proproveedorListProproveedorToAttach);
            }
            cattipoproveedor.setProproveedorList(attachedProproveedorList);
            em.persist(cattipoproveedor);
            for (Proproveedor proproveedorListProproveedor : cattipoproveedor.getProproveedorList()) {
                Cattipoproveedor oldIdcattipoproveedorOfProproveedorListProproveedor = proproveedorListProproveedor.getIdcattipoproveedor();
                proproveedorListProproveedor.setIdcattipoproveedor(cattipoproveedor);
                proproveedorListProproveedor = em.merge(proproveedorListProproveedor);
                if (oldIdcattipoproveedorOfProproveedorListProproveedor != null) {
                    oldIdcattipoproveedorOfProproveedorListProproveedor.getProproveedorList().remove(proproveedorListProproveedor);
                    oldIdcattipoproveedorOfProproveedorListProproveedor = em.merge(oldIdcattipoproveedorOfProproveedorListProproveedor);
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
    public void edit(Cattipoproveedor cattipoproveedor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cattipoproveedor persistentCattipoproveedor = em.find(Cattipoproveedor.class, cattipoproveedor.getId());
            List<Proproveedor> proproveedorListOld = persistentCattipoproveedor.getProproveedorList();
            List<Proproveedor> proproveedorListNew = cattipoproveedor.getProproveedorList();
            List<String> illegalOrphanMessages = null;
            for (Proproveedor proproveedorListOldProproveedor : proproveedorListOld) {
                if (!proproveedorListNew.contains(proproveedorListOldProproveedor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proproveedor " + proproveedorListOldProproveedor + " since its idcattipoproveedor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Proproveedor> attachedProproveedorListNew = new ArrayList<Proproveedor>();
            for (Proproveedor proproveedorListNewProproveedorToAttach : proproveedorListNew) {
                proproveedorListNewProproveedorToAttach = em.getReference(proproveedorListNewProproveedorToAttach.getClass(), proproveedorListNewProproveedorToAttach.getId());
                attachedProproveedorListNew.add(proproveedorListNewProproveedorToAttach);
            }
            proproveedorListNew = attachedProproveedorListNew;
            cattipoproveedor.setProproveedorList(proproveedorListNew);
            cattipoproveedor = em.merge(cattipoproveedor);
            for (Proproveedor proproveedorListNewProproveedor : proproveedorListNew) {
                if (!proproveedorListOld.contains(proproveedorListNewProproveedor)) {
                    Cattipoproveedor oldIdcattipoproveedorOfProproveedorListNewProproveedor = proproveedorListNewProproveedor.getIdcattipoproveedor();
                    proproveedorListNewProproveedor.setIdcattipoproveedor(cattipoproveedor);
                    proproveedorListNewProproveedor = em.merge(proproveedorListNewProproveedor);
                    if (oldIdcattipoproveedorOfProproveedorListNewProproveedor != null && !oldIdcattipoproveedorOfProproveedorListNewProproveedor.equals(cattipoproveedor)) {
                        oldIdcattipoproveedorOfProproveedorListNewProproveedor.getProproveedorList().remove(proproveedorListNewProproveedor);
                        oldIdcattipoproveedorOfProproveedorListNewProproveedor = em.merge(oldIdcattipoproveedorOfProproveedorListNewProproveedor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cattipoproveedor.getId();
                if (findCattipoproveedor(id) == null) {
                    throw new NonexistentEntityException("The cattipoproveedor with id " + id + " no longer exists.");
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
            Cattipoproveedor cattipoproveedor;
            try {
                cattipoproveedor = em.getReference(Cattipoproveedor.class, id);
                cattipoproveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cattipoproveedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proproveedor> proproveedorListOrphanCheck = cattipoproveedor.getProproveedorList();
            for (Proproveedor proproveedorListOrphanCheckProproveedor : proproveedorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cattipoproveedor (" + cattipoproveedor + ") cannot be destroyed since the Proproveedor " + proproveedorListOrphanCheckProproveedor + " in its proproveedorList field has a non-nullable idcattipoproveedor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cattipoproveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Cattipoproveedor> findCattipoproveedorEntities() {
        return findCattipoproveedorEntities(true, -1, -1);
    }

    @Override
    public List<Cattipoproveedor> findCattipoproveedorEntities(int maxResults, int firstResult) {
        return findCattipoproveedorEntities(false, maxResults, firstResult);
    }

    private List<Cattipoproveedor> findCattipoproveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cattipoproveedor.class));
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
    public Cattipoproveedor findCattipoproveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cattipoproveedor.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getCattipoproveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cattipoproveedor> rt = cq.from(Cattipoproveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
