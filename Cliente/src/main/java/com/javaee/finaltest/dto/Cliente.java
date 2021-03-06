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
public class Cliente implements Serializable {

    private Integer id;

    private String nombre;
    private String direccion;

    private Municipio muni;

    private String nit;
    private Date fechaNacimiento;

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
