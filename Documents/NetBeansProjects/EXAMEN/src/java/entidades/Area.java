/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp1
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByAreaCodigo", query = "SELECT a FROM Area a WHERE a.areaCodigo = :areaCodigo"),
    @NamedQuery(name = "Area.findByAreaNombre", query = "SELECT a FROM Area a WHERE a.areaNombre = :areaNombre")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "area_codigo")
    private Integer areaCodigo;
    @Size(max = 45)
    @Column(name = "area_nombre")
    private String areaNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaAreaCodigo")
    private Collection<Bibliografia> bibliografiaCollection;

    public Area() {
    }

    public Area(Integer areaCodigo) {
        this.areaCodigo = areaCodigo;
    }

    public Integer getAreaCodigo() {
        return areaCodigo;
    }

    public void setAreaCodigo(Integer areaCodigo) {
        this.areaCodigo = areaCodigo;
    }

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }

    @XmlTransient
    public Collection<Bibliografia> getBibliografiaCollection() {
        return bibliografiaCollection;
    }

    public void setBibliografiaCollection(Collection<Bibliografia> bibliografiaCollection) {
        this.bibliografiaCollection = bibliografiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaCodigo != null ? areaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areaCodigo == null && other.areaCodigo != null) || (this.areaCodigo != null && !this.areaCodigo.equals(other.areaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Area[ areaCodigo=" + areaCodigo + " ]";
    }
    
}
