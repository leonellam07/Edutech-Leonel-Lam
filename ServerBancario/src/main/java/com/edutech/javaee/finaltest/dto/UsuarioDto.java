package com.edutech.javaee.finaltest.dto;

import java.io.Serializable;

/**
 *
 * @author nahum
 */
public class UsuarioDto implements Serializable {

    private Integer id;
    private String codigo;
    private String email;
    private String nombre;
    private String password;
    private String telefono;
    private ClienteDto cliente;

    public UsuarioDto() {
    }

    public UsuarioDto(String codigo, String email, String nombre, String password, String telefono, ClienteDto cliente) {
        this.codigo = codigo;
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    public UsuarioDto(Integer id, String codigo, String email, String nombre, String password, String telefono, ClienteDto cliente) {
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

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

}
