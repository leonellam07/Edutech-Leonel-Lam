package com.edutech.javaee.finaltest.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author nahum
 */
@Entity
@Table(name = "USUARIO")
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

    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Rol rol;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    public Usuario(Integer id, String codigo, String nombre, String telefono, String email) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = null;
    }

    public Usuario() {
    }

    public Usuario(String codigo, String email, String nombre, String telefono, Rol rol) {
        this.codigo = codigo;
        this.email = email;
        this.nombre = nombre;
        this.password = null;
        this.telefono = telefono;
        this.rol = rol;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
