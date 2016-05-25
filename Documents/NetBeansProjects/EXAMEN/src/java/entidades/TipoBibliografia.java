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
@Table(name = "tipo_bibliografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoBibliografia.findAll", query = "SELECT t FROM TipoBibliografia t"),
    @NamedQuery(name = "TipoBibliografia.findByTibiCodigo", query = "SELECT t FROM TipoBibliografia t WHERE t.tibiCodigo = :tibiCodigo"),
    @NamedQuery(name = "TipoBibliografia.findByTibiNombre", query = "SELECT t FROM TipoBibliografia t WHERE t.tibiNombre = :tibiNombre")})
public class TipoBibliografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tibi_codigo")
    private Integer tibiCodigo;
    @Size(max = 45)
    @Column(name = "tibi_nombre")
    private String tibiNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBibliografiaTibiCodigo")
    private Collection<Bibliografia> bibliografiaCollection;

    public TipoBibliografia() {
    }

    public TipoBibliografia(Integer tibiCodigo) {
        this.tibiCodigo = tibiCodigo;
    }

    public Integer getTibiCodigo() {
        return tibiCodigo;
    }

    public void setTibiCodigo(Integer tibiCodigo) {
        this.tibiCodigo = tibiCodigo;
    }

    public String getTibiNombre() {
        return tibiNombre;
    }

    public void setTibiNombre(String tibiNombre) {
        this.tibiNombre = tibiNombre;
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
        hash += (tibiCodigo != null ? tibiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoBibliografia)) {
            return false;
        }
        TipoBibliografia other = (TipoBibliografia) object;
        if ((this.tibiCodigo == null && other.tibiCodigo != null) || (this.tibiCodigo != null && !this.tibiCodigo.equals(other.tibiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoBibliografia[ tibiCodigo=" + tibiCodigo + " ]";
    }
    
}
