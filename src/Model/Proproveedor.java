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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Dies
 */
@Entity
@Table(name = "proproveedor")
@NamedQueries({
    @NamedQuery(name = "Proproveedor.findAll", query = "SELECT p FROM Proproveedor p"),
    @NamedQuery(name = "Proproveedor.findById", query = "SELECT p FROM Proproveedor p WHERE p.id = :id"),
    @NamedQuery(name = "Proproveedor.findByStrrazonsocial", query = "SELECT p FROM Proproveedor p WHERE p.strrazonsocial = :strrazonsocial"),
    @NamedQuery(name = "Proproveedor.findByStrnombrecompania", query = "SELECT p FROM Proproveedor p WHERE p.strnombrecompania = :strnombrecompania"),
    @NamedQuery(name = "Proproveedor.findByStrrfc", query = "SELECT p FROM Proproveedor p WHERE p.strrfc = :strrfc")})
public class Proproveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "strrazonsocial")
    private String strrazonsocial;
    @Basic(optional = false)
    @Column(name = "strnombrecompania")
    private String strnombrecompania;
    @Basic(optional = false)
    @Column(name = "strrfc")
    private String strrfc;
    @Basic(optional = false)
    @Lob
    @Column(name = "imgfotocompania")
    private byte[] imgfotocompania;
    @JoinColumn(name = "idprocatstatusproveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Procatstatusproveedor idprocatstatusproveedor;
    @JoinColumn(name = "idcomdireccion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comestadodireccion idcomdireccion;
    @JoinColumn(name = "idcomdatocontacto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comdatocontacto idcomdatocontacto;
    @JoinColumn(name = "idcattipoproveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cattipoproveedor idcattipoproveedor;

    public Proproveedor() {
    }

    public Proproveedor(Integer id) {
        this.id = id;
    }

    public Proproveedor(Integer id, String strrazonsocial, String strnombrecompania, String strrfc, byte[] imgfotocompania) {
        this.id = id;
        this.strrazonsocial = strrazonsocial;
        this.strnombrecompania = strnombrecompania;
        this.strrfc = strrfc;
        this.imgfotocompania = imgfotocompania;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrrazonsocial() {
        return strrazonsocial;
    }

    public void setStrrazonsocial(String strrazonsocial) {
        this.strrazonsocial = strrazonsocial;
    }

    public String getStrnombrecompania() {
        return strnombrecompania;
    }

    public void setStrnombrecompania(String strnombrecompania) {
        this.strnombrecompania = strnombrecompania;
    }

    public String getStrrfc() {
        return strrfc;
    }

    public void setStrrfc(String strrfc) {
        this.strrfc = strrfc;
    }

    public byte[] getImgfotocompania() {
        return imgfotocompania;
    }

    public void setImgfotocompania(byte[] imgfotocompania) {
        this.imgfotocompania = imgfotocompania;
    }

    public Procatstatusproveedor getIdprocatstatusproveedor() {
        return idprocatstatusproveedor;
    }

    public void setIdprocatstatusproveedor(Procatstatusproveedor idprocatstatusproveedor) {
        this.idprocatstatusproveedor = idprocatstatusproveedor;
    }

    public Comestadodireccion getIdcomdireccion() {
        return idcomdireccion;
    }

    public void setIdcomdireccion(Comestadodireccion idcomdireccion) {
        this.idcomdireccion = idcomdireccion;
    }

    public Comdatocontacto getIdcomdatocontacto() {
        return idcomdatocontacto;
    }

    public void setIdcomdatocontacto(Comdatocontacto idcomdatocontacto) {
        this.idcomdatocontacto = idcomdatocontacto;
    }

    public Cattipoproveedor getIdcattipoproveedor() {
        return idcattipoproveedor;
    }

    public void setIdcattipoproveedor(Cattipoproveedor idcattipoproveedor) {
        this.idcattipoproveedor = idcattipoproveedor;
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
        if (!(object instanceof Proproveedor)) {
            return false;
        }
        Proproveedor other = (Proproveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Proproveedor[ id=" + id + " ]";
    }
    
}
