/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dto;

import java.util.Date;

/**
 *
 * @author leolp
 */
public class TransaccionDto {

    private Integer id;
    private CuentaDto cuenta;
    private Date fecha;
    private float monto;
    private TipoTransaccionDto tipoTransaccion;
    private String detalle;
    private Integer idCuentaxTransferir;

    public TransaccionDto() {
    }

    public TransaccionDto(Integer id, CuentaDto cuenta, Date fecha, float monto, TipoTransaccionDto tipoTransaccion, String detalle, Integer idCuentaxTransferir) {
        this.id = id;
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
        this.detalle = detalle;
        this.idCuentaxTransferir = idCuentaxTransferir;
    }

    public TransaccionDto(CuentaDto cuenta, float monto, TipoTransaccionDto tipoTransaccion, String detalle, Integer idCuentaxTransferir) {
        this.cuenta = cuenta;
        this.fecha = new Date();
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
        this.detalle = detalle;
        this.idCuentaxTransferir = idCuentaxTransferir;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CuentaDto getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaDto cuenta) {
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

    public TipoTransaccionDto getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccionDto tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getIdCuentaxTransferir() {
        return idCuentaxTransferir;
    }

    public void setIdCuentaxTransferir(Integer idCuentaxTransferir) {
        this.idCuentaxTransferir = idCuentaxTransferir;
    }

}
