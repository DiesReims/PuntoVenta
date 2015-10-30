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
@Table(name = "peddetallepedidoproveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peddetallepedidoproveedor.findAll", query = "SELECT p FROM Peddetallepedidoproveedor p"),
    @NamedQuery(name = "Peddetallepedidoproveedor.findById", query = "SELECT p FROM Peddetallepedidoproveedor p WHERE p.id = :id"),
    @NamedQuery(name = "Peddetallepedidoproveedor.findByIdproducto", query = "SELECT p FROM Peddetallepedidoproveedor p WHERE p.idproducto = :idproducto"),
    @NamedQuery(name = "Peddetallepedidoproveedor.findByIdproveedor", query = "SELECT p FROM Peddetallepedidoproveedor p WHERE p.idproveedor = :idproveedor"),
    @NamedQuery(name = "Peddetallepedidoproveedor.findByIntcantidad", query = "SELECT p FROM Peddetallepedidoproveedor p WHERE p.intcantidad = :intcantidad"),
    @NamedQuery(name = "Peddetallepedidoproveedor.findByDecsubtotal", query = "SELECT p FROM Peddetallepedidoproveedor p WHERE p.decsubtotal = :decsubtotal")})
public class Peddetallepedidoproveedor implements Serializable {
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
    @Column(name = "idproveedor")
    private int idproveedor;
    @Basic(optional = false)
    @Column(name = "intcantidad")
    private int intcantidad;
    @Basic(optional = false)
    @Column(name = "decsubtotal")
    private double decsubtotal;
    @JoinColumn(name = "idpedpedidoproveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pedpedidoproveedor idpedpedidoproveedor;

    public Peddetallepedidoproveedor() {
    }

    public Peddetallepedidoproveedor(Integer id) {
        this.id = id;
    }

    public Peddetallepedidoproveedor(Integer id, int idproducto, int idproveedor, int intcantidad, double decsubtotal) {
        this.id = id;
        this.idproducto = idproducto;
        this.idproveedor = idproveedor;
        this.intcantidad = intcantidad;
        this.decsubtotal = decsubtotal;
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

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public int getIntcantidad() {
        return intcantidad;
    }

    public void setIntcantidad(int intcantidad) {
        this.intcantidad = intcantidad;
    }

    public double getDecsubtotal() {
        return decsubtotal;
    }

    public void setDecsubtotal(double decsubtotal) {
        this.decsubtotal = decsubtotal;
    }

    public Pedpedidoproveedor getIdpedpedidoproveedor() {
        return idpedpedidoproveedor;
    }

    public void setIdpedpedidoproveedor(Pedpedidoproveedor idpedpedidoproveedor) {
        this.idpedpedidoproveedor = idpedpedidoproveedor;
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
        if (!(object instanceof Peddetallepedidoproveedor)) {
            return false;
        }
        Peddetallepedidoproveedor other = (Peddetallepedidoproveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Peddetallepedidoproveedor[ id=" + id + " ]";
    }
    
}
