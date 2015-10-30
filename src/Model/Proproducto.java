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
@Table(name = "proproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proproducto.findAll", query = "SELECT p FROM Proproducto p"),
    @NamedQuery(name = "Proproducto.findById", query = "SELECT p FROM Proproducto p WHERE p.id = :id"),
    @NamedQuery(name = "Proproducto.findByStridentificador", query = "SELECT p FROM Proproducto p WHERE p.stridentificador = :stridentificador"),
    @NamedQuery(name = "Proproducto.findByStrnombre", query = "SELECT p FROM Proproducto p WHERE p.strnombre = :strnombre"),
    @NamedQuery(name = "Proproducto.findByIntcantidad", query = "SELECT p FROM Proproducto p WHERE p.intcantidad = :intcantidad"),
    @NamedQuery(name = "Proproducto.findByDecpreciocompra", query = "SELECT p FROM Proproducto p WHERE p.decpreciocompra = :decpreciocompra"),
    @NamedQuery(name = "Proproducto.findByDecprecioventa", query = "SELECT p FROM Proproducto p WHERE p.decprecioventa = :decprecioventa"),
    @NamedQuery(name = "Proproducto.findByStrdescripcion", query = "SELECT p FROM Proproducto p WHERE p.strdescripcion = :strdescripcion")})
public class Proproducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "stridentificador")
    private String stridentificador;
    @Basic(optional = false)
    @Column(name = "strnombre")
    private String strnombre;
    @Basic(optional = false)
    @Column(name = "intcantidad")
    private int intcantidad;
    @Basic(optional = false)
    @Column(name = "decpreciocompra")
    private double decpreciocompra;
    @Basic(optional = false)
    @Column(name = "decprecioventa")
    private double decprecioventa;
    @Column(name = "strdescripcion")
    private String strdescripcion;
    @JoinColumn(name = "idproveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proproveedor idproveedor;
    @JoinColumn(name = "idcattipoproducto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cattipoproducto idcattipoproducto;

    public Proproducto() {
    }

    public Proproducto(Integer id) {
        this.id = id;
    }

    public Proproducto(Integer id, String stridentificador, String strnombre, int intcantidad, double decpreciocompra, double decprecioventa) {
        this.id = id;
        this.stridentificador = stridentificador;
        this.strnombre = strnombre;
        this.intcantidad = intcantidad;
        this.decpreciocompra = decpreciocompra;
        this.decprecioventa = decprecioventa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStridentificador() {
        return stridentificador;
    }

    public void setStridentificador(String stridentificador) {
        this.stridentificador = stridentificador;
    }

    public String getStrnombre() {
        return strnombre;
    }

    public void setStrnombre(String strnombre) {
        this.strnombre = strnombre;
    }

    public int getIntcantidad() {
        return intcantidad;
    }

    public void setIntcantidad(int intcantidad) {
        this.intcantidad = intcantidad;
    }

    public double getDecpreciocompra() {
        return decpreciocompra;
    }

    public void setDecpreciocompra(double decpreciocompra) {
        this.decpreciocompra = decpreciocompra;
    }

    public double getDecprecioventa() {
        return decprecioventa;
    }

    public void setDecprecioventa(double decprecioventa) {
        this.decprecioventa = decprecioventa;
    }

    public String getStrdescripcion() {
        return strdescripcion;
    }

    public void setStrdescripcion(String strdescripcion) {
        this.strdescripcion = strdescripcion;
    }

    public Proproveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proproveedor idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Cattipoproducto getIdcattipoproducto() {
        return idcattipoproducto;
    }

    public void setIdcattipoproducto(Cattipoproducto idcattipoproducto) {
        this.idcattipoproducto = idcattipoproducto;
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
        if (!(object instanceof Proproducto)) {
            return false;
        }
        Proproducto other = (Proproducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Proproducto[ id=" + id + " ]";
    }
    
}
