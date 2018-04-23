/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author leolp
 */
public class CuentaDto {

    private Integer id;
    private String moneda;
    private Date fechaApertura;
    private boolean activo;
    private ClienteDto cliente;
    private TiposCuentaDto tipoCuenta;
    private List<TransaccionDto> listaTransacciones;
    private Double totalCuenta;

    public CuentaDto() {
    }

    public CuentaDto(String moneda, Date fechaApertura, boolean activo, ClienteDto cliente, TiposCuentaDto tipoCuenta) {
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
    
    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public TiposCuentaDto getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TiposCuentaDto tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public List<TransaccionDto> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<TransaccionDto> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public Double getTotalCuenta() {
        return totalCuenta;
    }

    public void setTotalCuenta(Double totalCuenta) {
        this.totalCuenta = totalCuenta;
    }

}
