/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "TRANSACCION")
@NamedQueries({
    @NamedQuery(name = "Transaccion.findMonto", query = "Select SUM(d.monto) from Transaccion d WHERE d.cuenta.id = :idcuenta")
})
public class Transaccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactGen")
    @SequenceGenerator(name = "transactGen", sequenceName = "transact_seq", initialValue = 10)
    private Integer id;

    @JoinColumn(name = "id_cuenta", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuenta cuenta;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private float monto;
    
    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;
    private String detalle;

    @Transient
    private Integer idCuentaTrans;

    public Transaccion() {
    }

    public Transaccion(Cuenta cuenta,float monto, String tipo_transaccion, String detalle) {
        this.cuenta = cuenta;
        this.fecha = new Date();
        this.monto = monto;
        this.tipoTransaccion = tipo_transaccion;
        this.detalle = detalle;
    }

    public Transaccion(Cuenta cuenta, float monto, String tipoTransaccion, String detalle, Integer idCuentaTrans) {
        this.cuenta = cuenta;
        this.fecha = new Date();
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
        this.detalle = detalle;
        this.idCuentaTrans = idCuentaTrans;
    }

    
    @XmlTransient
    public Cuenta getCuenta() {
        return cuenta;
    }

    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getId_cuenta_trans() {
        return idCuentaTrans;
    }

    public void setIdCuentaTrans(Integer idCuentaTrans) {
        this.idCuentaTrans = idCuentaTrans;
    }

}
