/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IComDireccion;
import Concrete.exceptions.NonexistentEntityException;
import Model.Comdireccion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Comestadodireccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dies
 */
public class ComdireccionJpaController implements Serializable, IComDireccion {

    public ComdireccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Comdireccion comdireccion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comestadodireccion idestado = comdireccion.getIdestado();
            if (idestado != null) {
                idestado = em.getReference(idestado.getClass(), idestado.getId());
                comdireccion.setIdestado(idestado);
            }
            em.persist(comdireccion);
            if (idestado != null) {
                idestado.getComdireccionList().add(comdireccion);
                idestado = em.merge(idestado);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Comdireccion comdireccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comdireccion persistentComdireccion = em.find(Comdireccion.class, comdireccion.getId());
            Comestadodireccion idestadoOld = persistentComdireccion.getIdestado();
            Comestadodireccion idestadoNew = comdireccion.getIdestado();
            if (idestadoNew != null) {
                idestadoNew = em.getReference(idestadoNew.getClass(), idestadoNew.getId());
                comdireccion.setIdestado(idestadoNew);
            }
            comdireccion = em.merge(comdireccion);
            if (idestadoOld != null && !idestadoOld.equals(idestadoNew)) {
                idestadoOld.getComdireccionList().remove(comdireccion);
                idestadoOld = em.merge(idestadoOld);
            }
            if (idestadoNew != null && !idestadoNew.equals(idestadoOld)) {
                idestadoNew.getComdireccionList().add(comdireccion);
                idestadoNew = em.merge(idestadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comdireccion.getId();
                if (findComdireccion(id) == null) {
                    throw new NonexistentEntityException("The comdireccion with id " + id + " no longer exists.");
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
            Comdireccion comdireccion;
            try {
                comdireccion = em.getReference(Comdireccion.class, id);
                comdireccion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comdireccion with id " + id + " no longer exists.", enfe);
            }
            Comestadodireccion idestado = comdireccion.getIdestado();
            if (idestado != null) {
                idestado.getComdireccionList().remove(comdireccion);
                idestado = em.merge(idestado);
            }
            em.remove(comdireccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Comdireccion> findComdireccionEntities() {
        return findComdireccionEntities(true, -1, -1);
    }

    @Override
    public List<Comdireccion> findComdireccionEntities(int maxResults, int firstResult) {
        return findComdireccionEntities(false, maxResults, firstResult);
    }

    private List<Comdireccion> findComdireccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comdireccion.class));
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
    public Comdireccion findComdireccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comdireccion.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getComdireccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comdireccion> rt = cq.from(Comdireccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
