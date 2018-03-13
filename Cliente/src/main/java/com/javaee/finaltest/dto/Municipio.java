package com.javaee.finaltest.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nahum
 */
public class Municipio implements Serializable {

    private Integer id;

    private String codigo;
    private String nombre;

    private Departamento departamento;

    public Municipio() {
    }

    public Municipio(Integer id, String codigo, String nombre, Departamento departamento) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public Municipio(String codigo, String nombre, Departamento departamento) {
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

    @XmlTransient
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
