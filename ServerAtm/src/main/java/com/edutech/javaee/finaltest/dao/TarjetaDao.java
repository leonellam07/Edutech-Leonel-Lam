/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.TarjetaDebito;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leolp
 */
public class TarjetaDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    public TarjetaDebito validar(String numero, String pin) {
        return this.em.createQuery("SELECT t FROM TarjetaDebito t WHERE t.numero = :numero AND t.pin = :pin", TarjetaDebito.class)
                .setParameter("numero", numero)
                .setParameter("pin", pin)
                .getSingleResult();
    }
}
