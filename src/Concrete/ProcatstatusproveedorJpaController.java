/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IProCatStatusProveedor;
import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Procatstatusproveedor;
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
public class ProcatstatusproveedorJpaController implements Serializable, IProCatStatusProveedor {

    public ProcatstatusproveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ProcatstatusproveedorJpaController() {
          this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Procatstatusproveedor procatstatusproveedor) {
        if (procatstatusproveedor.getProproveedorList() == null) {
            procatstatusproveedor.setProproveedorList(new ArrayList<Proproveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proproveedor> attachedProproveedorList = new ArrayList<Proproveedor>();
            for (Proproveedor proproveedorListProproveedorToAttach : procatstatusproveedor.getProproveedorList()) {
                proproveedorListProproveedorToAttach = em.getReference(proproveedorListProproveedorToAttach.getClass(), proproveedorListProproveedorToAttach.getId());
                attachedProproveedorList.add(proproveedorListProproveedorToAttach);
            }
            procatstatusproveedor.setProproveedorList(attachedProproveedorList);
            em.persist(procatstatusproveedor);
            for (Proproveedor proproveedorListProproveedor : procatstatusproveedor.getProproveedorList()) {
                Procatstatusproveedor oldIdprocatstatusproveedorOfProproveedorListProproveedor = proproveedorListProproveedor.getIdprocatstatusproveedor();
                proproveedorListProproveedor.setIdprocatstatusproveedor(procatstatusproveedor);
                proproveedorListProproveedor = em.merge(proproveedorListProproveedor);
                if (oldIdprocatstatusproveedorOfProproveedorListProproveedor != null) {
                    oldIdprocatstatusproveedorOfProproveedorListProproveedor.getProproveedorList().remove(proproveedorListProproveedor);
                    oldIdprocatstatusproveedorOfProproveedorListProproveedor = em.merge(oldIdprocatstatusproveedorOfProproveedorListProproveedor);
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
    public void edit(Procatstatusproveedor procatstatusproveedor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Procatstatusproveedor persistentProcatstatusproveedor = em.find(Procatstatusproveedor.class, procatstatusproveedor.getId());
            List<Proproveedor> proproveedorListOld = persistentProcatstatusproveedor.getProproveedorList();
            List<Proproveedor> proproveedorListNew = procatstatusproveedor.getProproveedorList();
            List<String> illegalOrphanMessages = null;
            for (Proproveedor proproveedorListOldProproveedor : proproveedorListOld) {
                if (!proproveedorListNew.contains(proproveedorListOldProproveedor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proproveedor " + proproveedorListOldProproveedor + " since its idprocatstatusproveedor field is not nullable.");
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
            procatstatusproveedor.setProproveedorList(proproveedorListNew);
            procatstatusproveedor = em.merge(procatstatusproveedor);
            for (Proproveedor proproveedorListNewProproveedor : proproveedorListNew) {
                if (!proproveedorListOld.contains(proproveedorListNewProproveedor)) {
                    Procatstatusproveedor oldIdprocatstatusproveedorOfProproveedorListNewProproveedor = proproveedorListNewProproveedor.getIdprocatstatusproveedor();
                    proproveedorListNewProproveedor.setIdprocatstatusproveedor(procatstatusproveedor);
                    proproveedorListNewProproveedor = em.merge(proproveedorListNewProproveedor);
                    if (oldIdprocatstatusproveedorOfProproveedorListNewProproveedor != null && !oldIdprocatstatusproveedorOfProproveedorListNewProproveedor.equals(procatstatusproveedor)) {
                        oldIdprocatstatusproveedorOfProproveedorListNewProproveedor.getProproveedorList().remove(proproveedorListNewProproveedor);
                        oldIdprocatstatusproveedorOfProproveedorListNewProproveedor = em.merge(oldIdprocatstatusproveedorOfProproveedorListNewProproveedor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = procatstatusproveedor.getId();
                if (findProcatstatusproveedor(id) == null) {
                    throw new NonexistentEntityException("The procatstatusproveedor with id " + id + " no longer exists.");
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
            Procatstatusproveedor procatstatusproveedor;
            try {
                procatstatusproveedor = em.getReference(Procatstatusproveedor.class, id);
                procatstatusproveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The procatstatusproveedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proproveedor> proproveedorListOrphanCheck = procatstatusproveedor.getProproveedorList();
            for (Proproveedor proproveedorListOrphanCheckProproveedor : proproveedorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Procatstatusproveedor (" + procatstatusproveedor + ") cannot be destroyed since the Proproveedor " + proproveedorListOrphanCheckProproveedor + " in its proproveedorList field has a non-nullable idprocatstatusproveedor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(procatstatusproveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Procatstatusproveedor> findProcatstatusproveedorEntities() {
        return findProcatstatusproveedorEntities(true, -1, -1);
    }

    @Override
    public List<Procatstatusproveedor> findProcatstatusproveedorEntities(int maxResults, int firstResult) {
        return findProcatstatusproveedorEntities(false, maxResults, firstResult);
    }

    private List<Procatstatusproveedor> findProcatstatusproveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Procatstatusproveedor.class));
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
    public Procatstatusproveedor findProcatstatusproveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Procatstatusproveedor.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getProcatstatusproveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Procatstatusproveedor> rt = cq.from(Procatstatusproveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
