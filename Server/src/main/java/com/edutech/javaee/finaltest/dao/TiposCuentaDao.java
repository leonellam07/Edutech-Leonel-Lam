/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.TiposCuenta;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface TiposCuentaDao {

    public TiposCuenta find(Integer id);

    public List<TiposCuenta> findAll();
}
