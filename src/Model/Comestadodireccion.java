/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Dies
 */
@Entity
@Table(name = "comestadodireccion")
@NamedQueries({
    @NamedQuery(name = "Comestadodireccion.findAll", query = "SELECT c FROM Comestadodireccion c"),
    @NamedQuery(name = "Comestadodireccion.findById", query = "SELECT c FROM Comestadodireccion c WHERE c.id = :id"),
    @NamedQuery(name = "Comestadodireccion.findByStrvalor", query = "SELECT c FROM Comestadodireccion c WHERE c.strvalor = :strvalor"),
    @NamedQuery(name = "Comestadodireccion.findByStrdescripcion", query = "SELECT c FROM Comestadodireccion c WHERE c.strdescripcion = :strdescripcion")})
public class Comestadodireccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "strvalor")
    private String strvalor;
    @Column(name = "strdescripcion")
    private String strdescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcomdireccion")
    private List<Proproveedor> proproveedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<Comdireccion> comdireccionList;

    public Comestadodireccion() {
    }

    public Comestadodireccion(Integer id) {
        this.id = id;
    }

    public Comestadodireccion(Integer id, String strvalor) {
        this.id = id;
        this.strvalor = strvalor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrvalor() {
        return strvalor;
    }

    public void setStrvalor(String strvalor) {
        this.strvalor = strvalor;
    }

    public String getStrdescripcion() {
        return strdescripcion;
    }

    public void setStrdescripcion(String strdescripcion) {
        this.strdescripcion = strdescripcion;
    }

    public List<Proproveedor> getProproveedorList() {
        return proproveedorList;
    }

    public void setProproveedorList(List<Proproveedor> proproveedorList) {
        this.proproveedorList = proproveedorList;
    }

    public List<Comdireccion> getComdireccionList() {
        return comdireccionList;
    }

    public void setComdireccionList(List<Comdireccion> comdireccionList) {
        this.comdireccionList = comdireccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comestadodireccion)) {
            return false;
        }
        Comestadodireccion other = (Comestadodireccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Comestadodireccion[ id=" + id + " ]";
    }
    
}
