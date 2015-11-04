/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Dies
 */
@Entity
@Table(name = "comdireccion")
@NamedQueries({
    @NamedQuery(name = "Comdireccion.findAll", query = "SELECT c FROM Comdireccion c"),
    @NamedQuery(name = "Comdireccion.findById", query = "SELECT c FROM Comdireccion c WHERE c.id = :id"),
    @NamedQuery(name = "Comdireccion.findByStrnumero", query = "SELECT c FROM Comdireccion c WHERE c.strnumero = :strnumero"),
    @NamedQuery(name = "Comdireccion.findByStrcalle", query = "SELECT c FROM Comdireccion c WHERE c.strcalle = :strcalle"),
    @NamedQuery(name = "Comdireccion.findByStrcolonia", query = "SELECT c FROM Comdireccion c WHERE c.strcolonia = :strcolonia"),
    @NamedQuery(name = "Comdireccion.findByStrmunicipio", query = "SELECT c FROM Comdireccion c WHERE c.strmunicipio = :strmunicipio")})
public class Comdireccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "strnumero")
    private String strnumero;
    @Basic(optional = false)
    @Column(name = "strcalle")
    private String strcalle;
    @Basic(optional = false)
    @Column(name = "strcolonia")
    private String strcolonia;
    @Basic(optional = false)
    @Column(name = "strmunicipio")
    private String strmunicipio;
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comestadodireccion idestado;

    public Comdireccion() {
    }

    public Comdireccion(Integer id) {
        this.id = id;
    }

    public Comdireccion(Integer id, String strnumero, String strcalle, String strcolonia, String strmunicipio) {
        this.id = id;
        this.strnumero = strnumero;
        this.strcalle = strcalle;
        this.strcolonia = strcolonia;
        this.strmunicipio = strmunicipio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrnumero() {
        return strnumero;
    }

    public void setStrnumero(String strnumero) {
        this.strnumero = strnumero;
    }

    public String getStrcalle() {
        return strcalle;
    }

    public void setStrcalle(String strcalle) {
        this.strcalle = strcalle;
    }

    public String getStrcolonia() {
        return strcolonia;
    }

    public void setStrcolonia(String strcolonia) {
        this.strcolonia = strcolonia;
    }

    public String getStrmunicipio() {
        return strmunicipio;
    }

    public void setStrmunicipio(String strmunicipio) {
        this.strmunicipio = strmunicipio;
    }

    public Comestadodireccion getIdestado() {
        return idestado;
    }

    public void setIdestado(Comestadodireccion idestado) {
        this.idestado = idestado;
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
        if (!(object instanceof Comdireccion)) {
            return false;
        }
        Comdireccion other = (Comdireccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Comdireccion[ id=" + id + " ]";
    }
    
}
