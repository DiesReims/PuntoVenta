/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IComEstadoDireccion;
import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Proproveedor;
import java.util.ArrayList;
import java.util.List;
import Model.Comdireccion;
import Model.Comestadodireccion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dies
 */
public class ComestadodireccionJpaController implements Serializable, IComEstadoDireccion {

    public ComestadodireccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ComestadodireccionJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Comestadodireccion comestadodireccion) {
        if (comestadodireccion.getProproveedorList() == null) {
            comestadodireccion.setProproveedorList(new ArrayList<Proproveedor>());
        }
        if (comestadodireccion.getComdireccionList() == null) {
            comestadodireccion.setComdireccionList(new ArrayList<Comdireccion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proproveedor> attachedProproveedorList = new ArrayList<Proproveedor>();
            for (Proproveedor proproveedorListProproveedorToAttach : comestadodireccion.getProproveedorList()) {
                proproveedorListProproveedorToAttach = em.getReference(proproveedorListProproveedorToAttach.getClass(), proproveedorListProproveedorToAttach.getId());
                attachedProproveedorList.add(proproveedorListProproveedorToAttach);
            }
            comestadodireccion.setProproveedorList(attachedProproveedorList);
            List<Comdireccion> attachedComdireccionList = new ArrayList<Comdireccion>();
            for (Comdireccion comdireccionListComdireccionToAttach : comestadodireccion.getComdireccionList()) {
                comdireccionListComdireccionToAttach = em.getReference(comdireccionListComdireccionToAttach.getClass(), comdireccionListComdireccionToAttach.getId());
                attachedComdireccionList.add(comdireccionListComdireccionToAttach);
            }
            comestadodireccion.setComdireccionList(attachedComdireccionList);
            em.persist(comestadodireccion);
            for (Proproveedor proproveedorListProproveedor : comestadodireccion.getProproveedorList()) {
                Comestadodireccion oldIdcomdireccionOfProproveedorListProproveedor = proproveedorListProproveedor.getIdcomdireccion();
                proproveedorListProproveedor.setIdcomdireccion(comestadodireccion);
                proproveedorListProproveedor = em.merge(proproveedorListProproveedor);
                if (oldIdcomdireccionOfProproveedorListProproveedor != null) {
                    oldIdcomdireccionOfProproveedorListProproveedor.getProproveedorList().remove(proproveedorListProproveedor);
                    oldIdcomdireccionOfProproveedorListProproveedor = em.merge(oldIdcomdireccionOfProproveedorListProproveedor);
                }
            }
            for (Comdireccion comdireccionListComdireccion : comestadodireccion.getComdireccionList()) {
                Comestadodireccion oldIdestadoOfComdireccionListComdireccion = comdireccionListComdireccion.getIdestado();
                comdireccionListComdireccion.setIdestado(comestadodireccion);
                comdireccionListComdireccion = em.merge(comdireccionListComdireccion);
                if (oldIdestadoOfComdireccionListComdireccion != null) {
                    oldIdestadoOfComdireccionListComdireccion.getComdireccionList().remove(comdireccionListComdireccion);
                    oldIdestadoOfComdireccionListComdireccion = em.merge(oldIdestadoOfComdireccionListComdireccion);
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
    public void edit(Comestadodireccion comestadodireccion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comestadodireccion persistentComestadodireccion = em.find(Comestadodireccion.class, comestadodireccion.getId());
            List<Proproveedor> proproveedorListOld = persistentComestadodireccion.getProproveedorList();
            List<Proproveedor> proproveedorListNew = comestadodireccion.getProproveedorList();
            List<Comdireccion> comdireccionListOld = persistentComestadodireccion.getComdireccionList();
            List<Comdireccion> comdireccionListNew = comestadodireccion.getComdireccionList();
            List<String> illegalOrphanMessages = null;
            for (Proproveedor proproveedorListOldProproveedor : proproveedorListOld) {
                if (!proproveedorListNew.contains(proproveedorListOldProproveedor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proproveedor " + proproveedorListOldProproveedor + " since its idcomdireccion field is not nullable.");
                }
            }
            for (Comdireccion comdireccionListOldComdireccion : comdireccionListOld) {
                if (!comdireccionListNew.contains(comdireccionListOldComdireccion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Comdireccion " + comdireccionListOldComdireccion + " since its idestado field is not nullable.");
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
            comestadodireccion.setProproveedorList(proproveedorListNew);
            List<Comdireccion> attachedComdireccionListNew = new ArrayList<Comdireccion>();
            for (Comdireccion comdireccionListNewComdireccionToAttach : comdireccionListNew) {
                comdireccionListNewComdireccionToAttach = em.getReference(comdireccionListNewComdireccionToAttach.getClass(), comdireccionListNewComdireccionToAttach.getId());
                attachedComdireccionListNew.add(comdireccionListNewComdireccionToAttach);
            }
            comdireccionListNew = attachedComdireccionListNew;
            comestadodireccion.setComdireccionList(comdireccionListNew);
            comestadodireccion = em.merge(comestadodireccion);
            for (Proproveedor proproveedorListNewProproveedor : proproveedorListNew) {
                if (!proproveedorListOld.contains(proproveedorListNewProproveedor)) {
                    Comestadodireccion oldIdcomdireccionOfProproveedorListNewProproveedor = proproveedorListNewProproveedor.getIdcomdireccion();
                    proproveedorListNewProproveedor.setIdcomdireccion(comestadodireccion);
                    proproveedorListNewProproveedor = em.merge(proproveedorListNewProproveedor);
                    if (oldIdcomdireccionOfProproveedorListNewProproveedor != null && !oldIdcomdireccionOfProproveedorListNewProproveedor.equals(comestadodireccion)) {
                        oldIdcomdireccionOfProproveedorListNewProproveedor.getProproveedorList().remove(proproveedorListNewProproveedor);
                        oldIdcomdireccionOfProproveedorListNewProproveedor = em.merge(oldIdcomdireccionOfProproveedorListNewProproveedor);
                    }
                }
            }
            for (Comdireccion comdireccionListNewComdireccion : comdireccionListNew) {
                if (!comdireccionListOld.contains(comdireccionListNewComdireccion)) {
                    Comestadodireccion oldIdestadoOfComdireccionListNewComdireccion = comdireccionListNewComdireccion.getIdestado();
                    comdireccionListNewComdireccion.setIdestado(comestadodireccion);
                    comdireccionListNewComdireccion = em.merge(comdireccionListNewComdireccion);
                    if (oldIdestadoOfComdireccionListNewComdireccion != null && !oldIdestadoOfComdireccionListNewComdireccion.equals(comestadodireccion)) {
                        oldIdestadoOfComdireccionListNewComdireccion.getComdireccionList().remove(comdireccionListNewComdireccion);
                        oldIdestadoOfComdireccionListNewComdireccion = em.merge(oldIdestadoOfComdireccionListNewComdireccion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comestadodireccion.getId();
                if (findComestadodireccion(id) == null) {
                    throw new NonexistentEntityException("The comestadodireccion with id " + id + " no longer exists.");
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
            Comestadodireccion comestadodireccion;
            try {
                comestadodireccion = em.getReference(Comestadodireccion.class, id);
                comestadodireccion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comestadodireccion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proproveedor> proproveedorListOrphanCheck = comestadodireccion.getProproveedorList();
            for (Proproveedor proproveedorListOrphanCheckProproveedor : proproveedorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Comestadodireccion (" + comestadodireccion + ") cannot be destroyed since the Proproveedor " + proproveedorListOrphanCheckProproveedor + " in its proproveedorList field has a non-nullable idcomdireccion field.");
            }
            List<Comdireccion> comdireccionListOrphanCheck = comestadodireccion.getComdireccionList();
            for (Comdireccion comdireccionListOrphanCheckComdireccion : comdireccionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Comestadodireccion (" + comestadodireccion + ") cannot be destroyed since the Comdireccion " + comdireccionListOrphanCheckComdireccion + " in its comdireccionList field has a non-nullable idestado field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(comestadodireccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Comestadodireccion> findComestadodireccionEntities() {
        return findComestadodireccionEntities(true, -1, -1);
    }

    @Override
    public List<Comestadodireccion> findComestadodireccionEntities(int maxResults, int firstResult) {
        return findComestadodireccionEntities(false, maxResults, firstResult);
    }

    private List<Comestadodireccion> findComestadodireccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comestadodireccion.class));
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
    public Comestadodireccion findComestadodireccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comestadodireccion.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getComestadodireccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comestadodireccion> rt = cq.from(Comestadodireccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
