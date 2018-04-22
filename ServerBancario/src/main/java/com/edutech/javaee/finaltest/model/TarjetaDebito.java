/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leolp
 */
@Entity
@Table(name = "TARJETA_DEBITO")
@NamedQueries(
        @NamedQuery(name = "TarjetaDebito.consultar", query = "SELECT t FROM TarjetaDebito t WHERE t.numero = :numero AND t.pin = :pin")
)
public class TarjetaDebito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tardebGen")
    @SequenceGenerator(name = "tardebGen", sequenceName = "tardeb_seq", initialValue = 10)
    private Integer id;

    private String descripcion;
    private Double limitexDia;
    private String pin;

    @Column(unique = true)
    private String numero;

    @Temporal(TemporalType.DATE)
    private Date fechaExpiracion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getLimitexDia() {
        return limitexDia;
    }

    public void setLimitexDia(Double limitexDia) {
        this.limitexDia = limitexDia;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}
