/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.finaltest.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author leolp
 */
public class Cuenta implements Serializable {

    private Integer id;

    private String moneda;

    private Date fechaApertura;

    private boolean activo;

    private Cliente cliente;

    private TiposCuenta tipoCuenta;
    
    private List<Transaccion> listaTransacciones;

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


}
