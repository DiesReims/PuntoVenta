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
@Table(name = "venventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venventa.findAll", query = "SELECT v FROM Venventa v"),
    @NamedQuery(name = "Venventa.findById", query = "SELECT v FROM Venventa v WHERE v.id = :id"),
    @NamedQuery(name = "Venventa.findByStrfolio", query = "SELECT v FROM Venventa v WHERE v.strfolio = :strfolio"),
    @NamedQuery(name = "Venventa.findByDtefechaventa", query = "SELECT v FROM Venventa v WHERE v.dtefechaventa = :dtefechaventa"),
    @NamedQuery(name = "Venventa.findByDectotal", query = "SELECT v FROM Venventa v WHERE v.dectotal = :dectotal")})
public class Venventa implements Serializable {
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
    @Column(name = "dtefechaventa")
    @Temporal(TemporalType.DATE)
    private Date dtefechaventa;
    @Basic(optional = false)
    @Column(name = "dectotal")
    private double dectotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvenventa")
    private List<Vendetalleventa> vendetalleventaList;

    public Venventa() {
    }

    public Venventa(Integer id) {
        this.id = id;
    }

    public Venventa(Integer id, String strfolio, Date dtefechaventa, double dectotal) {
        this.id = id;
        this.strfolio = strfolio;
        this.dtefechaventa = dtefechaventa;
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

    public Date getDtefechaventa() {
        return dtefechaventa;
    }

    public void setDtefechaventa(Date dtefechaventa) {
        this.dtefechaventa = dtefechaventa;
    }

    public double getDectotal() {
        return dectotal;
    }

    public void setDectotal(double dectotal) {
        this.dectotal = dectotal;
    }

    @XmlTransient
    public List<Vendetalleventa> getVendetalleventaList() {
        return vendetalleventaList;
    }

    public void setVendetalleventaList(List<Vendetalleventa> vendetalleventaList) {
        this.vendetalleventaList = vendetalleventaList;
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
        if (!(object instanceof Venventa)) {
            return false;
        }
        Venventa other = (Venventa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Venventa[ id=" + id + " ]";
    }
    
}
