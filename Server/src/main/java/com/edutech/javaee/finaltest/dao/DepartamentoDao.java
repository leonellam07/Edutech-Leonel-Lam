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
public interface DepartamentoDao {

    public Departamento find(Integer id);

    public List<Departamento> findAll();

    public Departamento save(Departamento entity);

    public Departamento edit(Departamento entity);

    public Departamento remove(Integer id);

}
