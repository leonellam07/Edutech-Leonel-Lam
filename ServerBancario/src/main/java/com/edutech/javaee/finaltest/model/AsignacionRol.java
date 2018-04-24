/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.model;

import com.edutech.javaee.finaltest.model.key.AsignacionRolPK;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author leolp
 */
@Entity
@Table(name = "ASIGNACION_ROL")
@IdClass(AsignacionRolPK.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQueries({
    @NamedQuery(name = "AsignacionRol.buscar", query = "SELECT DISTINCT u FROM AsignacionRol u LEFT JOIN FETCH u.usuario LEFT JOIN FETCH u.rol  WHERE u.usuario.id = :idUsuario")
    ,
    @NamedQuery(name = "AsignacionRol.buscarTodo", query = "SELECT DISTINCT u FROM AsignacionRol u LEFT JOIN FETCH u.usuario LEFT JOIN FETCH u.rol ")
})
public class AsignacionRol implements Serializable {

    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    private Rol rol;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAsignacion;

    private String descripcion;

    public AsignacionRol() {
    }

    public AsignacionRol(Usuario usuario, Rol rol, String descripcion) {
        this.usuario = usuario;
        this.rol = rol;
        this.fechaAsignacion = new Date();
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
