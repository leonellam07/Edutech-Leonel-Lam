package com.edutech.javaee.finaltest.dto;

import java.io.Serializable;

/**
 *
 * @author nahum
 */
public class ParametroSistemaDto implements Serializable {

    private Integer id;
    private String nombre;
    private String valor;

    public ParametroSistemaDto() {
    }

    public ParametroSistemaDto(Integer id, String nombre, String valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
