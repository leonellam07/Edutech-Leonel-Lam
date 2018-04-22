package com.edutech.javaee.finaltest.dto;

import java.util.List;

/**
 *
 * @author nahum
 */
public class DepartamentoDto {

    private Integer id;
    private String codigo;
    private String nombre;
    List<MunicipioDto> municipios;

    public DepartamentoDto() {
    }

    public DepartamentoDto(Integer id, String codigo, String nombre) {
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

    public List<MunicipioDto> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<MunicipioDto> municipios) {
        this.municipios = municipios;
    }
}
