/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Transaccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leolp
 */
public class TransaccionDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    public List<Transaccion> listaTransacciones(Integer id) {
        return this.em.createQuery("SELECT DISTINCT u FROM Transaccion u WHERE u.cuenta.id = :id", Transaccion.class)
                .setParameter("id", id)
                .getResultList();
    }

    public Double monto(Integer id) {
        return this.em.createNamedQuery("Transaccion.findMonto", Double.class)
                .setParameter("idcuenta", id)
                .getSingleResult();
    }

    public Transaccion guardar(Transaccion entity) {
        this.em.persist(entity);
        return entity;
    }

}
