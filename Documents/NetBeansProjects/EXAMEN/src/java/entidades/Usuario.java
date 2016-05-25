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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUserCodigo", query = "SELECT u FROM Usuario u WHERE u.userCodigo = :userCodigo"),
    @NamedQuery(name = "Usuario.findByUserNombre", query = "SELECT u FROM Usuario u WHERE u.userNombre = :userNombre"),
    @NamedQuery(name = "Usuario.findByUserApellido", query = "SELECT u FROM Usuario u WHERE u.userApellido = :userApellido"),
    @NamedQuery(name = "Usuario.findByUserMail", query = "SELECT u FROM Usuario u WHERE u.userMail = :userMail"),
    @NamedQuery(name = "Usuario.findByUserTelefono", query = "SELECT u FROM Usuario u WHERE u.userTelefono = :userTelefono"),
    @NamedQuery(name = "Usuario.findByUserDierccion", query = "SELECT u FROM Usuario u WHERE u.userDierccion = :userDierccion"),
    @NamedQuery(name = "Usuario.findByUserUsername", query = "SELECT u FROM Usuario u WHERE u.userUsername = :userUsername"),
    @NamedQuery(name = "Usuario.findByUserPassword", query = "SELECT u FROM Usuario u WHERE u.userPassword = :userPassword")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_codigo")
    private Integer userCodigo;
    @Size(max = 45)
    @Column(name = "user_nombre")
    private String userNombre;
    @Size(max = 45)
    @Column(name = "user_apellido")
    private String userApellido;
    @Size(max = 45)
    @Column(name = "user_mail")
    private String userMail;
    @Size(max = 45)
    @Column(name = "user_telefono")
    private String userTelefono;
    @Size(max = 45)
    @Column(name = "user_dierccion")
    private String userDierccion;
    @Size(max = 45)
    @Column(name = "user_username")
    private String userUsername;
    @Size(max = 45)
    @Column(name = "user_password")
    private String userPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioUserCodigo")
    private Collection<Prestamo> prestamoCollection;
    @JoinColumn(name = "tipo_usuario_tius_codigo", referencedColumnName = "tius_codigo")
    @ManyToOne(optional = false)
    private TipoUsuario tipoUsuarioTiusCodigo;

    public Usuario() {
    }

    public Usuario(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    public Integer getUserCodigo() {
        return userCodigo;
    }

    public void setUserCodigo(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    public String getUserNombre() {
        return userNombre;
    }

    public void setUserNombre(String userNombre) {
        this.userNombre = userNombre;
    }

    public String getUserApellido() {
        return userApellido;
    }

    public void setUserApellido(String userApellido) {
        this.userApellido = userApellido;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserTelefono() {
        return userTelefono;
    }

    public void setUserTelefono(String userTelefono) {
        this.userTelefono = userTelefono;
    }

    public String getUserDierccion() {
        return userDierccion;
    }

    public void setUserDierccion(String userDierccion) {
        this.userDierccion = userDierccion;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    public TipoUsuario getTipoUsuarioTiusCodigo() {
        return tipoUsuarioTiusCodigo;
    }

    public void setTipoUsuarioTiusCodigo(TipoUsuario tipoUsuarioTiusCodigo) {
        this.tipoUsuarioTiusCodigo = tipoUsuarioTiusCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCodigo != null ? userCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.userCodigo == null && other.userCodigo != null) || (this.userCodigo != null && !this.userCodigo.equals(other.userCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ userCodigo=" + userCodigo + " ]";
    }
    
}
