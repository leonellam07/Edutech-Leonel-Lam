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
public class CuentaDao extends GenericDao<Cuenta> {

    public List<Cuenta> listar() {
        return this.em.createNamedQuery("Cuenta.buscarTodo", Cuenta.class)
                .getResultList();
    }

    public List<Cuenta> listaTarjeta(Integer idTarjeta) {
        return this.em.createNamedQuery("Cuenta.buscarTarjeta", Cuenta.class)
                .setParameter("idTarjeta", idTarjeta)
                .getResultList();
    }

    public Cuenta buscarId(Integer idCuenta) {
        return this.em
                .createNamedQuery("Cuenta.buscar", Cuenta.class)
                .setParameter("id", idCuenta)
                .getSingleResult();
    }

}
