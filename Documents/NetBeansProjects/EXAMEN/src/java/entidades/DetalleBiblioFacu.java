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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "detalle_biblio_facu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleBiblioFacu.findAll", query = "SELECT d FROM DetalleBiblioFacu d"),
    @NamedQuery(name = "DetalleBiblioFacu.findByDtbfCodigo", query = "SELECT d FROM DetalleBiblioFacu d WHERE d.dtbfCodigo = :dtbfCodigo"),
    @NamedQuery(name = "DetalleBiblioFacu.findByDtbfStock", query = "SELECT d FROM DetalleBiblioFacu d WHERE d.dtbfStock = :dtbfStock"),
    @NamedQuery(name = "DetalleBiblioFacu.findByDtbfEstado", query = "SELECT d FROM DetalleBiblioFacu d WHERE d.dtbfEstado = :dtbfEstado")})
public class DetalleBiblioFacu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dtbf_codigo")
    private Integer dtbfCodigo;
    @Size(max = 45)
    @Column(name = "dtbf_stock")
    private String dtbfStock;
    @Size(max = 45)
    @Column(name = "dtbf_estado")
    private String dtbfEstado;
    @JoinColumn(name = "bibliografia_bibl_codigo", referencedColumnName = "bibl_codigo")
    @ManyToOne(optional = false)
    private Bibliografia bibliografiaBiblCodigo;
    @JoinColumn(name = "facultad_facu_codigo", referencedColumnName = "facu_codigo")
    @ManyToOne(optional = false)
    private Facultad facultadFacuCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleBiblioFacuDtbfCodigo")
    private Collection<DetallePrestamo> detallePrestamoCollection;

    public DetalleBiblioFacu() {
    }

    public DetalleBiblioFacu(Integer dtbfCodigo) {
        this.dtbfCodigo = dtbfCodigo;
    }

    public Integer getDtbfCodigo() {
        return dtbfCodigo;
    }

    public void setDtbfCodigo(Integer dtbfCodigo) {
        this.dtbfCodigo = dtbfCodigo;
    }

    public String getDtbfStock() {
        return dtbfStock;
    }

    public void setDtbfStock(String dtbfStock) {
        this.dtbfStock = dtbfStock;
    }

    public String getDtbfEstado() {
        return dtbfEstado;
    }

    public void setDtbfEstado(String dtbfEstado) {
        this.dtbfEstado = dtbfEstado;
    }

    public Bibliografia getBibliografiaBiblCodigo() {
        return bibliografiaBiblCodigo;
    }

    public void setBibliografiaBiblCodigo(Bibliografia bibliografiaBiblCodigo) {
        this.bibliografiaBiblCodigo = bibliografiaBiblCodigo;
    }

    public Facultad getFacultadFacuCodigo() {
        return facultadFacuCodigo;
    }

    public void setFacultadFacuCodigo(Facultad facultadFacuCodigo) {
        this.facultadFacuCodigo = facultadFacuCodigo;
    }

    @XmlTransient
    public Collection<DetallePrestamo> getDetallePrestamoCollection() {
        return detallePrestamoCollection;
    }

    public void setDetallePrestamoCollection(Collection<DetallePrestamo> detallePrestamoCollection) {
        this.detallePrestamoCollection = detallePrestamoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtbfCodigo != null ? dtbfCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleBiblioFacu)) {
            return false;
        }
        DetalleBiblioFacu other = (DetalleBiblioFacu) object;
        if ((this.dtbfCodigo == null && other.dtbfCodigo != null) || (this.dtbfCodigo != null && !this.dtbfCodigo.equals(other.dtbfCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleBiblioFacu[ dtbfCodigo=" + dtbfCodigo + " ]";
    }
    
}
