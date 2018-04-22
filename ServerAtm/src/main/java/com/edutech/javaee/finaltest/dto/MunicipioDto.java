package com.edutech.javaee.finaltest.dto;

/**
 *
 * @author nahum
 */
public class MunicipioDto {

    private Integer id;
    private String codigo;
    private String nombre;
    private DepartamentoDto departamento;

    public MunicipioDto() {
    }

    public MunicipioDto(String codigo, String nombre, DepartamentoDto departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamento = departamento;
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

    public DepartamentoDto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDto departamento) {
        this.departamento = departamento;
    }

}
