/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.finaltest.dto;

import java.io.Serializable;

/**
 *
 * @author leolp
 */
public class TiposCuenta implements Serializable {

    private Integer id;

    private String nombre;
    private String descripcion;
    private float taza_interes;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getTaza_interes() {
        return taza_interes;
    }

    public void setTaza_interes(float taza_interes) {
        this.taza_interes = taza_interes;
    }

}
