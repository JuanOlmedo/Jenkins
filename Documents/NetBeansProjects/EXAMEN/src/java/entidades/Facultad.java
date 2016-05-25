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
@Table(name = "facultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f"),
    @NamedQuery(name = "Facultad.findByFacuCodigo", query = "SELECT f FROM Facultad f WHERE f.facuCodigo = :facuCodigo"),
    @NamedQuery(name = "Facultad.findByFacuNombre", query = "SELECT f FROM Facultad f WHERE f.facuNombre = :facuNombre")})
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "facu_codigo")
    private Integer facuCodigo;
    @Size(max = 45)
    @Column(name = "facu_nombre")
    private String facuNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultadFacuCodigo")
    private Collection<DetalleBiblioFacu> detalleBiblioFacuCollection;

    public Facultad() {
    }

    public Facultad(Integer facuCodigo) {
        this.facuCodigo = facuCodigo;
    }

    public Integer getFacuCodigo() {
        return facuCodigo;
    }

    public void setFacuCodigo(Integer facuCodigo) {
        this.facuCodigo = facuCodigo;
    }

    public String getFacuNombre() {
        return facuNombre;
    }

    public void setFacuNombre(String facuNombre) {
        this.facuNombre = facuNombre;
    }

    @XmlTransient
    public Collection<DetalleBiblioFacu> getDetalleBiblioFacuCollection() {
        return detalleBiblioFacuCollection;
    }

    public void setDetalleBiblioFacuCollection(Collection<DetalleBiblioFacu> detalleBiblioFacuCollection) {
        this.detalleBiblioFacuCollection = detalleBiblioFacuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facuCodigo != null ? facuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.facuCodigo == null && other.facuCodigo != null) || (this.facuCodigo != null && !this.facuCodigo.equals(other.facuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Facultad[ facuCodigo=" + facuCodigo + " ]";
    }
    
}
