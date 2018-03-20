/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Cuenta;
import com.edutech.javaee.finaltest.model.Transaccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.edutech.javaee.finaltest.dao.interfaces.TransaccionInterface;

/**
 *
 * @author leolp
 */
public class TransaccionDao implements TransaccionInterface {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Override
    public List<Transaccion> listaTransacciones(Integer id) {
        return this.em.createQuery("SELECT u FROM Transaccion u WHERE u.cuenta.id = :id", Transaccion.class)
                .setParameter("id", id)
                .getResultList();
    }

    public Double monto(Integer id) {
        return this.em.createNamedQuery("Transaccion.findMonto", Double.class)
                .setParameter("idcuenta", id)
                .getSingleResult();
    }

    @Override
    public Transaccion guardar(Transaccion entity) {
        this.em.persist(entity);
        return entity;
    }

}
