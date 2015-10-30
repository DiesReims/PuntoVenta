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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dies
 */
@Entity
@Table(name = "vendetalleventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendetalleventa.findAll", query = "SELECT v FROM Vendetalleventa v"),
    @NamedQuery(name = "Vendetalleventa.findById", query = "SELECT v FROM Vendetalleventa v WHERE v.id = :id"),
    @NamedQuery(name = "Vendetalleventa.findByIdproducto", query = "SELECT v FROM Vendetalleventa v WHERE v.idproducto = :idproducto"),
    @NamedQuery(name = "Vendetalleventa.findByIntcantidad", query = "SELECT v FROM Vendetalleventa v WHERE v.intcantidad = :intcantidad"),
    @NamedQuery(name = "Vendetalleventa.findByDectotal", query = "SELECT v FROM Vendetalleventa v WHERE v.dectotal = :dectotal")})
public class Vendetalleventa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "idproducto")
    private int idproducto;
    @Basic(optional = false)
    @Column(name = "intcantidad")
    private int intcantidad;
    @Basic(optional = false)
    @Column(name = "dectotal")
    private double dectotal;
    @JoinColumn(name = "idvenventa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Venventa idvenventa;

    public Vendetalleventa() {
    }

    public Vendetalleventa(Integer id) {
        this.id = id;
    }

    public Vendetalleventa(Integer id, int idproducto, int intcantidad, double dectotal) {
        this.id = id;
        this.idproducto = idproducto;
        this.intcantidad = intcantidad;
        this.dectotal = dectotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIntcantidad() {
        return intcantidad;
    }

    public void setIntcantidad(int intcantidad) {
        this.intcantidad = intcantidad;
    }

    public double getDectotal() {
        return dectotal;
    }

    public void setDectotal(double dectotal) {
        this.dectotal = dectotal;
    }

    public Venventa getIdvenventa() {
        return idvenventa;
    }

    public void setIdvenventa(Venventa idvenventa) {
        this.idvenventa = idvenventa;
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
        if (!(object instanceof Vendetalleventa)) {
            return false;
        }
        Vendetalleventa other = (Vendetalleventa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Vendetalleventa[ id=" + id + " ]";
    }
    
}
