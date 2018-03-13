package com.javaee.finaltest.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author nahum
 */
public class Departamento implements Serializable {

    private Integer id;

    private String codigo;
    private String nombre;
    List<Municipio> municipios;

    public Departamento() {
    }

    public Departamento(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
}
