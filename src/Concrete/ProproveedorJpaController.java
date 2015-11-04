/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concrete;

import Concrete.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Procatstatusproveedor;
import Model.Comestadodireccion;
import Model.Comdatocontacto;
import Model.Cattipoproveedor;
import Model.Proproveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dies
 */
public class ProproveedorJpaController implements Serializable {

    public ProproveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ProproveedorJpaController() {
         this.emf = Persistence.createEntityManagerFactory("ProyectoPuntoVentaPU");
    }
    
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proproveedor proproveedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Procatstatusproveedor idprocatstatusproveedor = proproveedor.getIdprocatstatusproveedor();
            if (idprocatstatusproveedor != null) {
                idprocatstatusproveedor = em.getReference(idprocatstatusproveedor.getClass(), idprocatstatusproveedor.getId());
                proproveedor.setIdprocatstatusproveedor(idprocatstatusproveedor);
            }
            Comestadodireccion idcomdireccion = proproveedor.getIdcomdireccion();
            if (idcomdireccion != null) {
                idcomdireccion = em.getReference(idcomdireccion.getClass(), idcomdireccion.getId());
                proproveedor.setIdcomdireccion(idcomdireccion);
            }
            Comdatocontacto idcomdatocontacto = proproveedor.getIdcomdatocontacto();
            if (idcomdatocontacto != null) {
                idcomdatocontacto = em.getReference(idcomdatocontacto.getClass(), idcomdatocontacto.getId());
                proproveedor.setIdcomdatocontacto(idcomdatocontacto);
            }
            Cattipoproveedor idcattipoproveedor = proproveedor.getIdcattipoproveedor();
            if (idcattipoproveedor != null) {
                idcattipoproveedor = em.getReference(idcattipoproveedor.getClass(), idcattipoproveedor.getId());
                proproveedor.setIdcattipoproveedor(idcattipoproveedor);
            }
            em.persist(proproveedor);
            if (idprocatstatusproveedor != null) {
                idprocatstatusproveedor.getProproveedorList().add(proproveedor);
                idprocatstatusproveedor = em.merge(idprocatstatusproveedor);
            }
            if (idcomdireccion != null) {
                idcomdireccion.getProproveedorList().add(proproveedor);
                idcomdireccion = em.merge(idcomdireccion);
            }
            if (idcomdatocontacto != null) {
                idcomdatocontacto.getProproveedorList().add(proproveedor);
                idcomdatocontacto = em.merge(idcomdatocontacto);
            }
            if (idcattipoproveedor != null) {
                idcattipoproveedor.getProproveedorList().add(proproveedor);
                idcattipoproveedor = em.merge(idcattipoproveedor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proproveedor proproveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proproveedor persistentProproveedor = em.find(Proproveedor.class, proproveedor.getId());
            Procatstatusproveedor idprocatstatusproveedorOld = persistentProproveedor.getIdprocatstatusproveedor();
            Procatstatusproveedor idprocatstatusproveedorNew = proproveedor.getIdprocatstatusproveedor();
            Comestadodireccion idcomdireccionOld = persistentProproveedor.getIdcomdireccion();
            Comestadodireccion idcomdireccionNew = proproveedor.getIdcomdireccion();
            Comdatocontacto idcomdatocontactoOld = persistentProproveedor.getIdcomdatocontacto();
            Comdatocontacto idcomdatocontactoNew = proproveedor.getIdcomdatocontacto();
            Cattipoproveedor idcattipoproveedorOld = persistentProproveedor.getIdcattipoproveedor();
            Cattipoproveedor idcattipoproveedorNew = proproveedor.getIdcattipoproveedor();
            if (idprocatstatusproveedorNew != null) {
                idprocatstatusproveedorNew = em.getReference(idprocatstatusproveedorNew.getClass(), idprocatstatusproveedorNew.getId());
                proproveedor.setIdprocatstatusproveedor(idprocatstatusproveedorNew);
            }
            if (idcomdireccionNew != null) {
                idcomdireccionNew = em.getReference(idcomdireccionNew.getClass(), idcomdireccionNew.getId());
                proproveedor.setIdcomdireccion(idcomdireccionNew);
            }
            if (idcomdatocontactoNew != null) {
                idcomdatocontactoNew = em.getReference(idcomdatocontactoNew.getClass(), idcomdatocontactoNew.getId());
                proproveedor.setIdcomdatocontacto(idcomdatocontactoNew);
            }
            if (idcattipoproveedorNew != null) {
                idcattipoproveedorNew = em.getReference(idcattipoproveedorNew.getClass(), idcattipoproveedorNew.getId());
                proproveedor.setIdcattipoproveedor(idcattipoproveedorNew);
            }
            proproveedor = em.merge(proproveedor);
            if (idprocatstatusproveedorOld != null && !idprocatstatusproveedorOld.equals(idprocatstatusproveedorNew)) {
                idprocatstatusproveedorOld.getProproveedorList().remove(proproveedor);
                idprocatstatusproveedorOld = em.merge(idprocatstatusproveedorOld);
            }
            if (idprocatstatusproveedorNew != null && !idprocatstatusproveedorNew.equals(idprocatstatusproveedorOld)) {
                idprocatstatusproveedorNew.getProproveedorList().add(proproveedor);
                idprocatstatusproveedorNew = em.merge(idprocatstatusproveedorNew);
            }
            if (idcomdireccionOld != null && !idcomdireccionOld.equals(idcomdireccionNew)) {
                idcomdireccionOld.getProproveedorList().remove(proproveedor);
                idcomdireccionOld = em.merge(idcomdireccionOld);
            }
            if (idcomdireccionNew != null && !idcomdireccionNew.equals(idcomdireccionOld)) {
                idcomdireccionNew.getProproveedorList().add(proproveedor);
                idcomdireccionNew = em.merge(idcomdireccionNew);
            }
            if (idcomdatocontactoOld != null && !idcomdatocontactoOld.equals(idcomdatocontactoNew)) {
                idcomdatocontactoOld.getProproveedorList().remove(proproveedor);
                idcomdatocontactoOld = em.merge(idcomdatocontactoOld);
            }
            if (idcomdatocontactoNew != null && !idcomdatocontactoNew.equals(idcomdatocontactoOld)) {
                idcomdatocontactoNew.getProproveedorList().add(proproveedor);
                idcomdatocontactoNew = em.merge(idcomdatocontactoNew);
            }
            if (idcattipoproveedorOld != null && !idcattipoproveedorOld.equals(idcattipoproveedorNew)) {
                idcattipoproveedorOld.getProproveedorList().remove(proproveedor);
                idcattipoproveedorOld = em.merge(idcattipoproveedorOld);
            }
            if (idcattipoproveedorNew != null && !idcattipoproveedorNew.equals(idcattipoproveedorOld)) {
                idcattipoproveedorNew.getProproveedorList().add(proproveedor);
                idcattipoproveedorNew = em.merge(idcattipoproveedorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = proproveedor.getId();
                if (findProproveedor(id) == null) {
                    throw new NonexistentEntityException("The proproveedor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proproveedor proproveedor;
            try {
                proproveedor = em.getReference(Proproveedor.class, id);
                proproveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proproveedor with id " + id + " no longer exists.", enfe);
            }
            Procatstatusproveedor idprocatstatusproveedor = proproveedor.getIdprocatstatusproveedor();
            if (idprocatstatusproveedor != null) {
                idprocatstatusproveedor.getProproveedorList().remove(proproveedor);
                idprocatstatusproveedor = em.merge(idprocatstatusproveedor);
            }
            Comestadodireccion idcomdireccion = proproveedor.getIdcomdireccion();
            if (idcomdireccion != null) {
                idcomdireccion.getProproveedorList().remove(proproveedor);
                idcomdireccion = em.merge(idcomdireccion);
            }
            Comdatocontacto idcomdatocontacto = proproveedor.getIdcomdatocontacto();
            if (idcomdatocontacto != null) {
                idcomdatocontacto.getProproveedorList().remove(proproveedor);
                idcomdatocontacto = em.merge(idcomdatocontacto);
            }
            Cattipoproveedor idcattipoproveedor = proproveedor.getIdcattipoproveedor();
            if (idcattipoproveedor != null) {
                idcattipoproveedor.getProproveedorList().remove(proproveedor);
                idcattipoproveedor = em.merge(idcattipoproveedor);
            }
            em.remove(proproveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proproveedor> findProproveedorEntities() {
        return findProproveedorEntities(true, -1, -1);
    }

    public List<Proproveedor> findProproveedorEntities(int maxResults, int firstResult) {
        return findProproveedorEntities(false, maxResults, firstResult);
    }

    private List<Proproveedor> findProproveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proproveedor.class));
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

    public Proproveedor findProproveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proproveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProproveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proproveedor> rt = cq.from(Proproveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
