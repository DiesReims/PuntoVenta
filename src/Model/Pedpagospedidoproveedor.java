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
@Table(name = "pedpagospedidoproveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedpagospedidoproveedor.findAll", query = "SELECT p FROM Pedpagospedidoproveedor p"),
    @NamedQuery(name = "Pedpagospedidoproveedor.findById", query = "SELECT p FROM Pedpagospedidoproveedor p WHERE p.id = :id"),
    @NamedQuery(name = "Pedpagospedidoproveedor.findByIdcattipopago", query = "SELECT p FROM Pedpagospedidoproveedor p WHERE p.idcattipopago = :idcattipopago"),
    @NamedQuery(name = "Pedpagospedidoproveedor.findByDecmontopago", query = "SELECT p FROM Pedpagospedidoproveedor p WHERE p.decmontopago = :decmontopago")})
public class Pedpagospedidoproveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "idcattipopago")
    private int idcattipopago;
    @Basic(optional = false)
    @Column(name = "decmontopago")
    private double decmontopago;
    @JoinColumn(name = "idpedpedidoproveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pedpedidoproveedor idpedpedidoproveedor;

    public Pedpagospedidoproveedor() {
    }

    public Pedpagospedidoproveedor(Integer id) {
        this.id = id;
    }

    public Pedpagospedidoproveedor(Integer id, int idcattipopago, double decmontopago) {
        this.id = id;
        this.idcattipopago = idcattipopago;
        this.decmontopago = decmontopago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdcattipopago() {
        return idcattipopago;
    }

    public void setIdcattipopago(int idcattipopago) {
        this.idcattipopago = idcattipopago;
    }

    public double getDecmontopago() {
        return decmontopago;
    }

    public void setDecmontopago(double decmontopago) {
        this.decmontopago = decmontopago;
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
        if (!(object instanceof Pedpagospedidoproveedor)) {
            return false;
        }
        Pedpagospedidoproveedor other = (Pedpagospedidoproveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pedpagospedidoproveedor[ id=" + id + " ]";
    }
    
}
