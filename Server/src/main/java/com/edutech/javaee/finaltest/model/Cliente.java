/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leolp
 */
@Entity
@Table(name = "CLIENTE")
@NamedQueries({
    @NamedQuery(name = "Cliente.buscar", query = "SELECT DISTINCT u FROM Cliente u JOIN FETCH u.muni JOIN FETCH u.listaCuentas WHERE u.id = :idCliente")
    ,
    @NamedQuery(name = "Cliente.buscarTodo", query = "SELECT DISTINCT u FROM Cliente u JOIN FETCH u.muni")
})
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clienteGen")
    @SequenceGenerator(name = "clienteGen", sequenceName = "cliente_seq", initialValue = 10)
    private Integer id;

    private String nombre;
    private String direccion;

    @OneToOne
    @JoinColumn(name = "id_muni", referencedColumnName = "ID")
    private Municipio muni;

    private String nit;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Cuenta> listaCuentas;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, Municipio muni, String nit, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.muni = muni;
        this.nit = nit;
        this.fechaNacimiento = fecha_nacimiento;
    }

    public Cliente(Integer id, String nombre, String direccion, Municipio muni, String nit, Date fechaNacimiento, List<Cuenta> listaCuentas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.muni = muni;
        this.nit = nit;
        this.fechaNacimiento = fechaNacimiento;
        this.listaCuentas = listaCuentas;
    }

    //@XmlTransient
    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Municipio getMuni() {
        return muni;
    }

    public void setMuni(Municipio muni) {
        this.muni = muni;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
