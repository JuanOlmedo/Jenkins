/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp1
 */
@Entity
@Table(name = "detalle_prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePrestamo.findAll", query = "SELECT d FROM DetallePrestamo d"),
    @NamedQuery(name = "DetallePrestamo.findByDeprCodigo", query = "SELECT d FROM DetallePrestamo d WHERE d.deprCodigo = :deprCodigo"),
    @NamedQuery(name = "DetallePrestamo.findByDetalleEstado", query = "SELECT d FROM DetallePrestamo d WHERE d.detalleEstado = :detalleEstado")})
public class DetallePrestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "depr_codigo")
    private Integer deprCodigo;
    @Size(max = 45)
    @Column(name = "detalle_estado")
    private String detalleEstado;
    @JoinColumn(name = "detalle_biblio_facu_dtbf_codigo", referencedColumnName = "dtbf_codigo")
    @ManyToOne(optional = false)
    private DetalleBiblioFacu detalleBiblioFacuDtbfCodigo;
    @JoinColumn(name = "prestamo_pres_codigo", referencedColumnName = "pres_codigo")
    @ManyToOne(optional = false)
    private Prestamo prestamoPresCodigo;

    public DetallePrestamo() {
    }

    public DetallePrestamo(Integer deprCodigo) {
        this.deprCodigo = deprCodigo;
    }

    public Integer getDeprCodigo() {
        return deprCodigo;
    }

    public void setDeprCodigo(Integer deprCodigo) {
        this.deprCodigo = deprCodigo;
    }

    public String getDetalleEstado() {
        return detalleEstado;
    }

    public void setDetalleEstado(String detalleEstado) {
        this.detalleEstado = detalleEstado;
    }

    public DetalleBiblioFacu getDetalleBiblioFacuDtbfCodigo() {
        return detalleBiblioFacuDtbfCodigo;
    }

    public void setDetalleBiblioFacuDtbfCodigo(DetalleBiblioFacu detalleBiblioFacuDtbfCodigo) {
        this.detalleBiblioFacuDtbfCodigo = detalleBiblioFacuDtbfCodigo;
    }

    public Prestamo getPrestamoPresCodigo() {
        return prestamoPresCodigo;
    }

    public void setPrestamoPresCodigo(Prestamo prestamoPresCodigo) {
        this.prestamoPresCodigo = prestamoPresCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deprCodigo != null ? deprCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePrestamo)) {
            return false;
        }
        DetallePrestamo other = (DetallePrestamo) object;
        if ((this.deprCodigo == null && other.deprCodigo != null) || (this.deprCodigo != null && !this.deprCodigo.equals(other.deprCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetallePrestamo[ deprCodigo=" + deprCodigo + " ]";
    }
    
}
