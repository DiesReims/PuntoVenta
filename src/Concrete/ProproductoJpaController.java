/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.IProProducto;
import Concrete.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Proproveedor;
import Model.Cattipoproducto;
import Model.Proproducto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dies
 */
public class ProproductoJpaController implements IProProducto {

    public ProproductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ProproductoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Proproducto proproducto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
        
            Cattipoproducto idcattipoproducto = proproducto.getIdcattipoproducto();
            if (idcattipoproducto != null) {
                idcattipoproducto = em.getReference(idcattipoproducto.getClass(), idcattipoproducto.getId());
                proproducto.setIdcattipoproducto(idcattipoproducto);
            }
            em.persist(proproducto);
          
            if (idcattipoproducto != null) {
                idcattipoproducto.getProproductoList().add(proproducto);
                idcattipoproducto = em.merge(idcattipoproducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Proproducto proproducto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proproducto persistentProproducto = em.find(Proproducto.class, proproducto.getId());

            Cattipoproducto idcattipoproductoOld = persistentProproducto.getIdcattipoproducto();
            Cattipoproducto idcattipoproductoNew = proproducto.getIdcattipoproducto();
            
            if (idcattipoproductoNew != null) {
                idcattipoproductoNew = em.getReference(idcattipoproductoNew.getClass(), idcattipoproductoNew.getId());
                proproducto.setIdcattipoproducto(idcattipoproductoNew);
            }
            proproducto = em.merge(proproducto);          
            if (idcattipoproductoOld != null && !idcattipoproductoOld.equals(idcattipoproductoNew)) {
                idcattipoproductoOld.getProproductoList().remove(proproducto);
                idcattipoproductoOld = em.merge(idcattipoproductoOld);
            }
            if (idcattipoproductoNew != null && !idcattipoproductoNew.equals(idcattipoproductoOld)) {
                idcattipoproductoNew.getProproductoList().add(proproducto);
                idcattipoproductoNew = em.merge(idcattipoproductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = proproducto.getId();
                if (findProproducto(id) == null) {
                    throw new NonexistentEntityException("The proproducto with id " + id + " no longer exists.");
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
            Proproducto proproducto;
            try {
                proproducto = em.getReference(Proproducto.class, id);
                proproducto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proproducto with id " + id + " no longer exists.", enfe);
            }
            Cattipoproducto idcattipoproducto = proproducto.getIdcattipoproducto();
            if (idcattipoproducto != null) {
                idcattipoproducto.getProproductoList().remove(proproducto);
                idcattipoproducto = em.merge(idcattipoproducto);
            }
            em.remove(proproducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Proproducto> findProproductoEntities() {
        return findProproductoEntities(true, -1, -1);
    }

    @Override
    public List<Proproducto> findProproductoEntities(int maxResults, int firstResult) {
        return findProproductoEntities(false, maxResults, firstResult);
    }

    private List<Proproducto> findProproductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proproducto.class));
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
    public Proproducto findProproducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proproducto.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getProproductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proproducto> rt = cq.from(Proproducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
