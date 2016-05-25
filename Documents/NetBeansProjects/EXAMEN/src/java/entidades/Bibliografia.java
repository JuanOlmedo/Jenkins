/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp1
 */
@Entity
@Table(name = "bibliografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliografia.findAll", query = "SELECT b FROM Bibliografia b"),
    @NamedQuery(name = "Bibliografia.findByBiblCodigo", query = "SELECT b FROM Bibliografia b WHERE b.biblCodigo = :biblCodigo"),
    @NamedQuery(name = "Bibliografia.findByBiblTitulo", query = "SELECT b FROM Bibliografia b WHERE b.biblTitulo = :biblTitulo"),
    @NamedQuery(name = "Bibliografia.findByBiblEditorial", query = "SELECT b FROM Bibliografia b WHERE b.biblEditorial = :biblEditorial"),
    @NamedQuery(name = "Bibliografia.findByBiblFechaPublicacion", query = "SELECT b FROM Bibliografia b WHERE b.biblFechaPublicacion = :biblFechaPublicacion"),
    @NamedQuery(name = "Bibliografia.findByBiblIdioma", query = "SELECT b FROM Bibliografia b WHERE b.biblIdioma = :biblIdioma"),
    @NamedQuery(name = "Bibliografia.findByBiblDescripcion", query = "SELECT b FROM Bibliografia b WHERE b.biblDescripcion = :biblDescripcion")})
public class Bibliografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bibl_codigo")
    private Integer biblCodigo;
    @Size(max = 45)
    @Column(name = "bibl_titulo")
    private String biblTitulo;
    @Size(max = 45)
    @Column(name = "bibl_editorial")
    private String biblEditorial;
    @Column(name = "bibl_fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date biblFechaPublicacion;
    @Size(max = 45)
    @Column(name = "bibl_idioma")
    private String biblIdioma;
    @Size(max = 45)
    @Column(name = "bibl_descripcion")
    private String biblDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bibliografiaBiblCodigo")
    private Collection<DetalleBiblioFacu> detalleBiblioFacuCollection;
    @JoinColumn(name = "autor_autor_codigo", referencedColumnName = "autor_codigo")
    @ManyToOne(optional = false)
    private Autor autorAutorCodigo;
    @JoinColumn(name = "area_area_codigo", referencedColumnName = "area_codigo")
    @ManyToOne(optional = false)
    private Area areaAreaCodigo;
    @JoinColumn(name = "tipo_bibliografia_tibi_codigo", referencedColumnName = "tibi_codigo")
    @ManyToOne(optional = false)
    private TipoBibliografia tipoBibliografiaTibiCodigo;

    public Bibliografia() {
    }

    public Bibliografia(Integer biblCodigo) {
        this.biblCodigo = biblCodigo;
    }

    public Integer getBiblCodigo() {
        return biblCodigo;
    }

    public void setBiblCodigo(Integer biblCodigo) {
        this.biblCodigo = biblCodigo;
    }

    public String getBiblTitulo() {
        return biblTitulo;
    }

    public void setBiblTitulo(String biblTitulo) {
        this.biblTitulo = biblTitulo;
    }

    public String getBiblEditorial() {
        return biblEditorial;
    }

    public void setBiblEditorial(String biblEditorial) {
        this.biblEditorial = biblEditorial;
    }

    public Date getBiblFechaPublicacion() {
        return biblFechaPublicacion;
    }

    public void setBiblFechaPublicacion(Date biblFechaPublicacion) {
        this.biblFechaPublicacion = biblFechaPublicacion;
    }

    public String getBiblIdioma() {
        return biblIdioma;
    }

    public void setBiblIdioma(String biblIdioma) {
        this.biblIdioma = biblIdioma;
    }

    public String getBiblDescripcion() {
        return biblDescripcion;
    }

    public void setBiblDescripcion(String biblDescripcion) {
        this.biblDescripcion = biblDescripcion;
    }

    @XmlTransient
    public Collection<DetalleBiblioFacu> getDetalleBiblioFacuCollection() {
        return detalleBiblioFacuCollection;
    }

    public void setDetalleBiblioFacuCollection(Collection<DetalleBiblioFacu> detalleBiblioFacuCollection) {
        this.detalleBiblioFacuCollection = detalleBiblioFacuCollection;
    }

    public Autor getAutorAutorCodigo() {
        return autorAutorCodigo;
    }

    public void setAutorAutorCodigo(Autor autorAutorCodigo) {
        this.autorAutorCodigo = autorAutorCodigo;
    }

    public Area getAreaAreaCodigo() {
        return areaAreaCodigo;
    }

    public void setAreaAreaCodigo(Area areaAreaCodigo) {
        this.areaAreaCodigo = areaAreaCodigo;
    }

    public TipoBibliografia getTipoBibliografiaTibiCodigo() {
        return tipoBibliografiaTibiCodigo;
    }

    public void setTipoBibliografiaTibiCodigo(TipoBibliografia tipoBibliografiaTibiCodigo) {
        this.tipoBibliografiaTibiCodigo = tipoBibliografiaTibiCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biblCodigo != null ? biblCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliografia)) {
            return false;
        }
        Bibliografia other = (Bibliografia) object;
        if ((this.biblCodigo == null && other.biblCodigo != null) || (this.biblCodigo != null && !this.biblCodigo.equals(other.biblCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bibliografia[ biblCodigo=" + biblCodigo + " ]";
    }
    
}
