/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.TarjetaDebito;

/**
 *
 * @author leolp
 */
public class TarjetaDebitoDao extends GenericDao<TarjetaDebito> {

    public TarjetaDebito validar(String numero, String pin) {
        return this.em.createNamedQuery("TarjetaDebito.consultar", TarjetaDebito.class)
                .setParameter("numero", numero)
                .setParameter("pin", pin)
                .getSingleResult();
    }

}
