package com.edutech.javaee.finaltest.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nahum
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.login", query = "SELECT u FROM Usuario u LEFT JOIN FETCH u.cliente c LEFT JOIN FETCH c.listaCuentas WHERE u.codigo = :codigo AND u.password = :password")
    ,
        @NamedQuery(name = "Usuario.buscarCodigo", query = "SELECT u FROM Usuario u LEFT JOIN FETCH u.cliente c LEFT JOIN FETCH c.listaCuentas WHERE u.codigo = :codigo")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioGen")
    @SequenceGenerator(name = "usuarioGen", sequenceName = "usuario_seq", initialValue = 10)
    private Integer id;

    private String codigo;
    private String email;

    private String nombre;
    private String password;
    private String telefono;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<AsignacionRol> listaAsignRoles;

    public Usuario() {
    }

    public Usuario(String codigo, String email, String nombre, String password, String telefono, Cliente cliente) {
        this.codigo = codigo;
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    public Usuario(Integer id, String codigo, String email, String nombre, String password, String telefono, Cliente cliente) {
        this.id = id;
        this.codigo = codigo;
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public List<AsignacionRol> getListaAsignRoles() {
        return listaAsignRoles;
    }

    public void setListaAsignRoles(List<AsignacionRol> listaAsignRoles) {
        this.listaAsignRoles = listaAsignRoles;
    }

}
