/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Abstract.ICatTipoProducto;
import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Cattipoproducto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Proproducto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dies
 */
public class CattipoproductoJpaController implements Serializable, ICatTipoProducto {

    public CattipoproductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Cattipoproducto cattipoproducto) {
        if (cattipoproducto.getProproductoList() == null) {
            cattipoproducto.setProproductoList(new ArrayList<Proproducto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proproducto> attachedProproductoList = new ArrayList<Proproducto>();
            for (Proproducto proproductoListProproductoToAttach : cattipoproducto.getProproductoList()) {
                proproductoListProproductoToAttach = em.getReference(proproductoListProproductoToAttach.getClass(), proproductoListProproductoToAttach.getId());
                attachedProproductoList.add(proproductoListProproductoToAttach);
            }
            cattipoproducto.setProproductoList(attachedProproductoList);
            em.persist(cattipoproducto);
            for (Proproducto proproductoListProproducto : cattipoproducto.getProproductoList()) {
                Cattipoproducto oldIdcattipoproductoOfProproductoListProproducto = proproductoListProproducto.getIdcattipoproducto();
                proproductoListProproducto.setIdcattipoproducto(cattipoproducto);
                proproductoListProproducto = em.merge(proproductoListProproducto);
                if (oldIdcattipoproductoOfProproductoListProproducto != null) {
                    oldIdcattipoproductoOfProproductoListProproducto.getProproductoList().remove(proproductoListProproducto);
                    oldIdcattipoproductoOfProproductoListProproducto = em.merge(oldIdcattipoproductoOfProproductoListProproducto);
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
    public void edit(Cattipoproducto cattipoproducto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cattipoproducto persistentCattipoproducto = em.find(Cattipoproducto.class, cattipoproducto.getId());
            List<Proproducto> proproductoListOld = persistentCattipoproducto.getProproductoList();
            List<Proproducto> proproductoListNew = cattipoproducto.getProproductoList();
            List<String> illegalOrphanMessages = null;
            for (Proproducto proproductoListOldProproducto : proproductoListOld) {
                if (!proproductoListNew.contains(proproductoListOldProproducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proproducto " + proproductoListOldProproducto + " since its idcattipoproducto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Proproducto> attachedProproductoListNew = new ArrayList<Proproducto>();
            for (Proproducto proproductoListNewProproductoToAttach : proproductoListNew) {
                proproductoListNewProproductoToAttach = em.getReference(proproductoListNewProproductoToAttach.getClass(), proproductoListNewProproductoToAttach.getId());
                attachedProproductoListNew.add(proproductoListNewProproductoToAttach);
            }
            proproductoListNew = attachedProproductoListNew;
            cattipoproducto.setProproductoList(proproductoListNew);
            cattipoproducto = em.merge(cattipoproducto);
            for (Proproducto proproductoListNewProproducto : proproductoListNew) {
                if (!proproductoListOld.contains(proproductoListNewProproducto)) {
                    Cattipoproducto oldIdcattipoproductoOfProproductoListNewProproducto = proproductoListNewProproducto.getIdcattipoproducto();
                    proproductoListNewProproducto.setIdcattipoproducto(cattipoproducto);
                    proproductoListNewProproducto = em.merge(proproductoListNewProproducto);
                    if (oldIdcattipoproductoOfProproductoListNewProproducto != null && !oldIdcattipoproductoOfProproductoListNewProproducto.equals(cattipoproducto)) {
                        oldIdcattipoproductoOfProproductoListNewProproducto.getProproductoList().remove(proproductoListNewProproducto);
                        oldIdcattipoproductoOfProproductoListNewProproducto = em.merge(oldIdcattipoproductoOfProproductoListNewProproducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cattipoproducto.getId();
                if (findCattipoproducto(id) == null) {
                    throw new NonexistentEntityException("The cattipoproducto with id " + id + " no longer exists.");
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
            Cattipoproducto cattipoproducto;
            try {
                cattipoproducto = em.getReference(Cattipoproducto.class, id);
                cattipoproducto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cattipoproducto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Proproducto> proproductoListOrphanCheck = cattipoproducto.getProproductoList();
            for (Proproducto proproductoListOrphanCheckProproducto : proproductoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cattipoproducto (" + cattipoproducto + ") cannot be destroyed since the Proproducto " + proproductoListOrphanCheckProproducto + " in its proproductoList field has a non-nullable idcattipoproducto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cattipoproducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Cattipoproducto> findCattipoproductoEntities() {
        return findCattipoproductoEntities(true, -1, -1);
    }

    @Override
    public List<Cattipoproducto> findCattipoproductoEntities(int maxResults, int firstResult) {
        return findCattipoproductoEntities(false, maxResults, firstResult);
    }

    private List<Cattipoproducto> findCattipoproductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cattipoproducto.class));
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
    public Cattipoproducto findCattipoproducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cattipoproducto.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getCattipoproductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cattipoproducto> rt = cq.from(Cattipoproducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
