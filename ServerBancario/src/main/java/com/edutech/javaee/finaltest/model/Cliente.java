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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leolp
 */
@Entity
@Table(name = "CLIENTE")
@NamedQueries({
    @NamedQuery(name = "Cliente.buscar", query = "SELECT DISTINCT u FROM Cliente u LEFT JOIN FETCH u.muni LEFT JOIN FETCH u.tarjetaDebito LEFT JOIN FETCH u.listaCuentas c  LEFT JOIN FETCH  c.tipoCuenta WHERE u.id = :idCliente")
    ,
    @NamedQuery(name = "Cliente.buscarTodo", query = "SELECT DISTINCT u FROM Cliente u LEFT JOIN FETCH u.muni LEFT JOIN FETCH u.tarjetaDebito ")
})
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clienteGen")
    @SequenceGenerator(name = "clienteGen", sequenceName = "cliente_seq", initialValue = 10)
    private Integer id;

    private String nombre;
    private String direccion;
    private String nit;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_muni", referencedColumnName = "ID")
    private Municipio muni;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Cuenta> listaCuentas;

    @OneToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tarjetaDebito", referencedColumnName = "ID")
    private TarjetaDebito tarjetaDebito;

    @Lob
    private byte[] imagen;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, String nit, Municipio muni, Date fechaNacimiento, List<Cuenta> listaCuentas, TarjetaDebito tarjetaDebito) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.muni = muni;
        this.fechaNacimiento = fechaNacimiento;
        this.listaCuentas = listaCuentas;
        this.tarjetaDebito = tarjetaDebito;
    }

    public Cliente(String nombre, String direccion, String nit, Municipio muni, Date fechaNacimiento, TarjetaDebito tarjetaDebito) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.muni = muni;
        this.fechaNacimiento = fechaNacimiento;
        this.tarjetaDebito = tarjetaDebito;
    }

    public Cliente(Integer id, String nombre, String direccion, String nit, Municipio muni, Date fechaNacimiento, List<Cuenta> listaCuentas, TarjetaDebito tarjetaDebito) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.muni = muni;
        this.fechaNacimiento = fechaNacimiento;
        this.listaCuentas = listaCuentas;
        this.tarjetaDebito = tarjetaDebito;
    }

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

    public TarjetaDebito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public void setTarjetaDebito(TarjetaDebito tarjetaDebito) {
        this.tarjetaDebito = tarjetaDebito;
    }

    @XmlTransient
    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

}
