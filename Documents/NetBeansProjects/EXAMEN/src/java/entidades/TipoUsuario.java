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
@Table(name = "tipo_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t"),
    @NamedQuery(name = "TipoUsuario.findByTiusCodigo", query = "SELECT t FROM TipoUsuario t WHERE t.tiusCodigo = :tiusCodigo"),
    @NamedQuery(name = "TipoUsuario.findByTiusNombre", query = "SELECT t FROM TipoUsuario t WHERE t.tiusNombre = :tiusNombre"),
    @NamedQuery(name = "TipoUsuario.findByTiusTiempoReserva", query = "SELECT t FROM TipoUsuario t WHERE t.tiusTiempoReserva = :tiusTiempoReserva"),
    @NamedQuery(name = "TipoUsuario.findByTiusTiempoEntrega", query = "SELECT t FROM TipoUsuario t WHERE t.tiusTiempoEntrega = :tiusTiempoEntrega"),
    @NamedQuery(name = "TipoUsuario.findByTiusValorMulta", query = "SELECT t FROM TipoUsuario t WHERE t.tiusValorMulta = :tiusValorMulta")})
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tius_codigo")
    private Integer tiusCodigo;
    @Size(max = 45)
    @Column(name = "tius_nombre")
    private String tiusNombre;
    @Size(max = 45)
    @Column(name = "tius_tiempo_reserva")
    private String tiusTiempoReserva;
    @Size(max = 45)
    @Column(name = "tius_tiempo_entrega")
    private String tiusTiempoEntrega;
    @Size(max = 45)
    @Column(name = "tius_valor_multa")
    private String tiusValorMulta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuarioTiusCodigo")
    private Collection<Usuario> usuarioCollection;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer tiusCodigo) {
        this.tiusCodigo = tiusCodigo;
    }

    public Integer getTiusCodigo() {
        return tiusCodigo;
    }

    public void setTiusCodigo(Integer tiusCodigo) {
        this.tiusCodigo = tiusCodigo;
    }

    public String getTiusNombre() {
        return tiusNombre;
    }

    public void setTiusNombre(String tiusNombre) {
        this.tiusNombre = tiusNombre;
    }

    public String getTiusTiempoReserva() {
        return tiusTiempoReserva;
    }

    public void setTiusTiempoReserva(String tiusTiempoReserva) {
        this.tiusTiempoReserva = tiusTiempoReserva;
    }

    public String getTiusTiempoEntrega() {
        return tiusTiempoEntrega;
    }

    public void setTiusTiempoEntrega(String tiusTiempoEntrega) {
        this.tiusTiempoEntrega = tiusTiempoEntrega;
    }

    public String getTiusValorMulta() {
        return tiusValorMulta;
    }

    public void setTiusValorMulta(String tiusValorMulta) {
        this.tiusValorMulta = tiusValorMulta;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiusCodigo != null ? tiusCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.tiusCodigo == null && other.tiusCodigo != null) || (this.tiusCodigo != null && !this.tiusCodigo.equals(other.tiusCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoUsuario[ tiusCodigo=" + tiusCodigo + " ]";
    }
    
}
