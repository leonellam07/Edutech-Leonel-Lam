/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Transaccion;
import java.util.List;

/**
 *
 * @author leolp
 */
public class TransaccionDao extends GenericDao<Transaccion> {

    public List<Transaccion> listaTransacciones(Integer idCuenta) {
        return this.em.createQuery("SELECT DISTINCT u FROM Transaccion u WHERE u.cuenta.id = :id", Transaccion.class)
                .setParameter("id", idCuenta)
                .getResultList();
    }

    public Double total(Integer idCuenta) {
        return this.em.createNamedQuery("Transaccion.findMonto", Double.class)
                .setParameter("idcuenta", idCuenta)
                .getSingleResult();
    }

}
