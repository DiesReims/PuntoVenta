/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IComDatoContacto;
import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Comdatocontacto;
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

/**
 *
 * @author Dies
 */
public class ComdatocontactoJpaController implements Serializable, IComDatoContacto {

    public ComdatocontactoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Comdatocontacto comdatocontacto) {
        if (comdatocontacto.getProproveedorList() == null) {
            comdatocontacto.setProproveedorList(new ArrayList<Proproveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proproveedor> attachedProproveedorList = new ArrayList<Proproveedor>();
            for (Proproveedor proproveedorListProproveedorToAttach : comdatocontacto.getProproveedorList()) {
                proproveedorListProproveedorToAttach = em.getReference(proproveedorListProproveedorToAttach.getClass(), proproveedorListProproveedorToAttach.getId());
                attachedProproveedorList.add(proproveedorListProproveedorToAttach);
            }
            comdatocontacto.setProproveedorList(attachedProproveedorList);
            em.persist(comdatocontacto);
            for (Proproveedor proproveedorListProproveedor : comdatocontacto.getProproveedorList()) {
                Comdatocontacto oldIdcomdatocontactoOfProproveedorListProproveedor = proproveedorListProproveedor.getIdcomdatocontacto();
                proproveedorListProproveedor.setIdcomdatocontacto(comdatocontacto);
                proproveedorListProproveedor = em.merge(proproveedorListProproveedor);
                if (oldIdcomdatocontactoOfProproveedorListProproveedor != null) {
                    oldIdcomdatocontactoOfProproveedorListProproveedor.getProproveedorList().remove(proproveedorListProproveedor);
                    oldIdcomdatocontactoOfProproveedorListProproveedor = em.merge(oldIdcomdatocontactoOfProproveedorListProproveedor);
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
    public void edit(Comdatocontacto comdatocontacto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comdatocontacto persistentComdatocontacto = em.find(Comdatocontacto.class, comdatocontacto.getId());
            List<Proproveedor> proproveedorListOld = persistentComdatocontacto.getProproveedorList();
            List<Proproveedor> proproveedorListNew = comdatocontacto.getProproveedorList();
            List<String> illegalOrphanMessages = null;
            for (Proproveedor proproveedorListOldProproveedor : proproveedorListOld) {
                if (!proproveedorListNew.contains(proproveedorListOldProproveedor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proproveedor " + proproveedorListOldProproveedor + " since its idcomdatocontacto field is not nullable.");
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
            comdatocontacto.setProproveedorList(proproveedorListNew);
            comdatocontacto = em.merge(comdatocontacto);
            for (Proproveedor proproveedorListNewProproveedor : proproveedorListNew) {
                if (!proproveedorListOld.contains(proproveedorListNewProproveedor)) {
                    Comdatocontacto oldIdcomdatocontactoOfProproveedorListNewProproveedor = proproveedorListNewProproveedor.getIdcomdatocontacto();
                    proproveedorListNewProproveedor.setIdcomdatocontacto(comdatocontacto);
                    proproveedorListNewProproveedor = em.merge(proproveedorListNewProproveedor);
                    if (oldIdcomdatocontactoOfProproveedorListNewProproveedor != null && !oldIdcomdatocontactoOfProproveedorListNewProproveedor.equals(comdatocontacto)) {
                        oldIdcomdatocontactoOfProproveedorListNewProproveedor.getProproveedorList().remove(proproveedorListNewProproveedor);
                        oldIdcomdatocontactoOfProproveedorListNewProproveedor = em.merge(oldIdcomdatocontactoOfProproveedorListNewProproveedor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comdatocontacto.getId();
                if (findComdatocontacto(id) == null) {
                    throw new NonexistentEntityException("The comdatocontacto with id " + id + " no longer exists.");
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
            Comdatocontacto comdatocontacto;
            try {
                comdatocontacto = em.getReference(Comdatocontacto.class, id);
                comdatocontacto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comdatocontacto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proproveedor> proproveedorListOrphanCheck = comdatocontacto.getProproveedorList();
            for (Proproveedor proproveedorListOrphanCheckProproveedor : proproveedorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Comdatocontacto (" + comdatocontacto + ") cannot be destroyed since the Proproveedor " + proproveedorListOrphanCheckProproveedor + " in its proproveedorList field has a non-nullable idcomdatocontacto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(comdatocontacto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Comdatocontacto> findComdatocontactoEntities() {
        return findComdatocontactoEntities(true, -1, -1);
    }

    @Override
    public List<Comdatocontacto> findComdatocontactoEntities(int maxResults, int firstResult) {
        return findComdatocontactoEntities(false, maxResults, firstResult);
    }

    private List<Comdatocontacto> findComdatocontactoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comdatocontacto.class));
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
    public Comdatocontacto findComdatocontacto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comdatocontacto.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getComdatocontactoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comdatocontacto> rt = cq.from(Comdatocontacto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
