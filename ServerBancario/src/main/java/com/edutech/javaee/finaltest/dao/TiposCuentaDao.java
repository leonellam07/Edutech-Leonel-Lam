/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.TiposCuenta;

/**
 *
 * @author leolp
 */
public class TiposCuentaDao extends GenericDao<TiposCuenta> {

    public TiposCuenta buscarId(Integer idTipoCuenta) {
        return this.em.find(TiposCuenta.class, idTipoCuenta);
    }
}
