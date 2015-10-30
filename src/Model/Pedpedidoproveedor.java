/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dies
 */
@Entity
@Table(name = "pedpedidoproveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedpedidoproveedor.findAll", query = "SELECT p FROM Pedpedidoproveedor p"),
    @NamedQuery(name = "Pedpedidoproveedor.findById", query = "SELECT p FROM Pedpedidoproveedor p WHERE p.id = :id"),
    @NamedQuery(name = "Pedpedidoproveedor.findByStrfolio", query = "SELECT p FROM Pedpedidoproveedor p WHERE p.strfolio = :strfolio"),
    @NamedQuery(name = "Pedpedidoproveedor.findByDtefechapedido", query = "SELECT p FROM Pedpedidoproveedor p WHERE p.dtefechapedido = :dtefechapedido"),
    @NamedQuery(name = "Pedpedidoproveedor.findByDectotal", query = "SELECT p FROM Pedpedidoproveedor p WHERE p.dectotal = :dectotal")})
public class Pedpedidoproveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "strfolio")
    private String strfolio;
    @Basic(optional = false)
    @Column(name = "dtefechapedido")
    @Temporal(TemporalType.DATE)
    private Date dtefechapedido;
    @Basic(optional = false)
    @Column(name = "dectotal")
    private double dectotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpedpedidoproveedor")
    private List<Pedpagospedidoproveedor> pedpagospedidoproveedorList;
    @JoinColumn(name = "idcatstatuspedido", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Catstatuspedido idcatstatuspedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpedpedidoproveedor")
    private List<Peddetallepedidoproveedor> peddetallepedidoproveedorList;

    public Pedpedidoproveedor() {
    }

    public Pedpedidoproveedor(Integer id) {
        this.id = id;
    }

    public Pedpedidoproveedor(Integer id, String strfolio, Date dtefechapedido, double dectotal) {
        this.id = id;
        this.strfolio = strfolio;
        this.dtefechapedido = dtefechapedido;
        this.dectotal = dectotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrfolio() {
        return strfolio;
    }

    public void setStrfolio(String strfolio) {
        this.strfolio = strfolio;
    }

    public Date getDtefechapedido() {
        return dtefechapedido;
    }

    public void setDtefechapedido(Date dtefechapedido) {
        this.dtefechapedido = dtefechapedido;
    }

    public double getDectotal() {
        return dectotal;
    }

    public void setDectotal(double dectotal) {
        this.dectotal = dectotal;
    }

    @XmlTransient
    public List<Pedpagospedidoproveedor> getPedpagospedidoproveedorList() {
        return pedpagospedidoproveedorList;
    }

    public void setPedpagospedidoproveedorList(List<Pedpagospedidoproveedor> pedpagospedidoproveedorList) {
        this.pedpagospedidoproveedorList = pedpagospedidoproveedorList;
    }

    public Catstatuspedido getIdcatstatuspedido() {
        return idcatstatuspedido;
    }

    public void setIdcatstatuspedido(Catstatuspedido idcatstatuspedido) {
        this.idcatstatuspedido = idcatstatuspedido;
    }

    @XmlTransient
    public List<Peddetallepedidoproveedor> getPeddetallepedidoproveedorList() {
        return peddetallepedidoproveedorList;
    }

    public void setPeddetallepedidoproveedorList(List<Peddetallepedidoproveedor> peddetallepedidoproveedorList) {
        this.peddetallepedidoproveedorList = peddetallepedidoproveedorList;
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
        if (!(object instanceof Pedpedidoproveedor)) {
            return false;
        }
        Pedpedidoproveedor other = (Pedpedidoproveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pedpedidoproveedor[ id=" + id + " ]";
    }
    
}
