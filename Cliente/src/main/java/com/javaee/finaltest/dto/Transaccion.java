/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.finaltest.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author leolp
 */
public class Transaccion implements Serializable {

    private Integer id;

    private Cuenta cuenta;

    private Date fecha;

    private float monto;
    
    private String tipoTransaccion;
    private String detalle;

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
