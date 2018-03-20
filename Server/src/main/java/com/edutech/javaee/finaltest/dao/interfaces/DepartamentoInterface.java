/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao.interfaces;

import com.edutech.javaee.finaltest.model.Departamento;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface DepartamentoInterface {

    public Departamento buscar(Integer id);

    public List<Departamento> listar();

    public Departamento guardar(Departamento entity);

    public Departamento editar(Departamento entity);

    public Departamento eliminar(Integer id);

}
