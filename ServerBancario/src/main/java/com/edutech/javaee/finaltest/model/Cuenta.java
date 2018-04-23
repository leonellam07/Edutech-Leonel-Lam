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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leolp
 */
@Entity
@Table(name = "CUENTA")
@NamedQueries({
    @NamedQuery(name = "Cuenta.buscar", query = "SELECT DISTINCT u FROM Cuenta u LEFT JOIN FETCH u.cliente LEFT JOIN FETCH u.tipoCuenta LEFT JOIN FETCH u.listaTransacciones WHERE u.id = :id")
    ,
    @NamedQuery(name = "Cuenta.buscarTodo", query = "SELECT DISTINCT u FROM Cuenta u LEFT JOIN FETCH u.cliente LEFT JOIN FETCH u.tipoCuenta")
    ,
    @NamedQuery(name = "Cuenta.buscarTarjeta", query = "SELECT DISTINCT u FROM Cuenta u LEFT JOIN FETCH u.cliente LEFT JOIN FETCH u.tipoCuenta LEFT JOIN FETCH u.listaTransacciones WHERE u.cliente.tarjetaDebito.numero = :numero")
})
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuentaGen")
    @SequenceGenerator(name = "cuentaGen", sequenceName = "cuenta_seq", initialValue = 10)
    private Integer id;

    private String moneda;

    @Column(name = "fecha_apertura")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;

    private boolean activo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_tipoCuenta", referencedColumnName = "id")
    private TiposCuenta tipoCuenta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta", fetch = FetchType.LAZY)
    private List<Transaccion> listaTransacciones;

    @Transient
    private Double totalCuenta;

    public Cuenta() {
    }

    public Cuenta(Integer id, String moneda, Date fechaApertura, boolean activo, Cliente cliente, TiposCuenta tipoCuenta) {
        this.id = id;
        this.moneda = moneda;
        this.fechaApertura = fechaApertura;
        this.activo = activo;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
    }

    public Cuenta(String moneda, Date fechaApertura, boolean activo, Cliente cliente, TiposCuenta tipoCuenta) {
        this.moneda = moneda;
        this.fechaApertura = fechaApertura;
        this.activo = activo;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TiposCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TiposCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public Double getTotalCuenta() {
        return totalCuenta;
    }

    public void setTotalCuenta(Double totalCuenta) {
        this.totalCuenta = totalCuenta;
    }

}
