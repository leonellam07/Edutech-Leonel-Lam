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
        return this.em.createNamedQuery("Transaccion.ultimasTransc", Transaccion.class)
                .setParameter("idCuenta", idCuenta)
                .getResultList();
    }

    public Double total(Integer idCuenta) {
        return this.em.createNamedQuery("Transaccion.montoTotal", Double.class)
                .setParameter("idcuenta", idCuenta)
                .getSingleResult();
    }

}
