/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Cuenta;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface CuentaDao {

    public Cuenta find(Integer id);

    public List<Cuenta> findAll();

    public Cuenta save(Cuenta entity);

    public Cuenta edit(Cuenta entity);

    public Cuenta remove(Integer id);

}
