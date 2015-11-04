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
@Table(name = "comdatocontacto")
@NamedQueries({
    @NamedQuery(name = "Comdatocontacto.findAll", query = "SELECT c FROM Comdatocontacto c"),
    @NamedQuery(name = "Comdatocontacto.findById", query = "SELECT c FROM Comdatocontacto c WHERE c.id = :id"),
    @NamedQuery(name = "Comdatocontacto.findByStrnombrecontacto", query = "SELECT c FROM Comdatocontacto c WHERE c.strnombrecontacto = :strnombrecontacto"),
    @NamedQuery(name = "Comdatocontacto.findByStremail", query = "SELECT c FROM Comdatocontacto c WHERE c.stremail = :stremail"),
    @NamedQuery(name = "Comdatocontacto.findByStrtelefonomovil", query = "SELECT c FROM Comdatocontacto c WHERE c.strtelefonomovil = :strtelefonomovil"),
    @NamedQuery(name = "Comdatocontacto.findByStrtelefonohome", query = "SELECT c FROM Comdatocontacto c WHERE c.strtelefonohome = :strtelefonohome")})
public class Comdatocontacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "strnombrecontacto")
    private String strnombrecontacto;
    @Column(name = "stremail")
    private String stremail;
    @Column(name = "strtelefonomovil")
    private String strtelefonomovil;
    @Column(name = "strtelefonohome")
    private String strtelefonohome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcomdatocontacto")
    private List<Proproveedor> proproveedorList;

    public Comdatocontacto() {
    }

    public Comdatocontacto(Integer id) {
        this.id = id;
    }

    public Comdatocontacto(Integer id, String strnombrecontacto) {
        this.id = id;
        this.strnombrecontacto = strnombrecontacto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrnombrecontacto() {
        return strnombrecontacto;
    }

    public void setStrnombrecontacto(String strnombrecontacto) {
        this.strnombrecontacto = strnombrecontacto;
    }

    public String getStremail() {
        return stremail;
    }

    public void setStremail(String stremail) {
        this.stremail = stremail;
    }

    public String getStrtelefonomovil() {
        return strtelefonomovil;
    }

    public void setStrtelefonomovil(String strtelefonomovil) {
        this.strtelefonomovil = strtelefonomovil;
    }

    public String getStrtelefonohome() {
        return strtelefonohome;
    }

    public void setStrtelefonohome(String strtelefonohome) {
        this.strtelefonohome = strtelefonohome;
    }

    public List<Proproveedor> getProproveedorList() {
        return proproveedorList;
    }

    public void setProproveedorList(List<Proproveedor> proproveedorList) {
        this.proproveedorList = proproveedorList;
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
        if (!(object instanceof Comdatocontacto)) {
            return false;
        }
        Comdatocontacto other = (Comdatocontacto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Comdatocontacto[ id=" + id + " ]";
    }
    
}
