/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Departamento;
import java.util.List;

/**
 *
 * @author leolp
 */
public class DepartamentoDao extends GenericDao<Departamento> {

    public List<Departamento> listar() {
        return this.em
                .createNamedQuery("Departamento.buscarTodo", Departamento.class)
                .getResultList();
    }

    public Departamento buscarId(Integer idDepartamento) {
        return this.em
                .createNamedQuery("Departamento.buscar", Departamento.class)
                .setParameter("idDepartamento", idDepartamento)
                .getSingleResult();
    }

}
