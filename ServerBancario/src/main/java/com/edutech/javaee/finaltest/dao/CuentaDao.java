/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Cuenta;

/**
 *
 * @author leolp
 */
public class CuentaDao extends GenericDao<Cuenta> {

    public Cuenta buscarId(Integer idCuenta) {
        return this.em
                .createNamedQuery("Cuenta.buscar", Cuenta.class)
                .setParameter("id", idCuenta)
                .getSingleResult();
    }
}
