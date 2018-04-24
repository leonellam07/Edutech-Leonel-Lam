package com.edutech.javaee.finaltest.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nahum
 */
@Entity
@Table(name = "ROL")
public class Rol implements Serializable {

    @Id
    private Integer id;

    private String nombre;
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rol")
    private List<AsignacionRol> listaAsignRoles;

    public Rol() {
    }

    public Rol(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Rol(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<AsignacionRol> getListaAsignRoles() {
        return listaAsignRoles;
    }

    public void setListaAsignRoles(List<AsignacionRol> listaAsignRoles) {
        this.listaAsignRoles = listaAsignRoles;
    }

}
