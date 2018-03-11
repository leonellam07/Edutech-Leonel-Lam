/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Cuenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leolp
 */
public class CuentaDaoImp implements CuentaDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Override
    public Cuenta find(Integer id) {
        try {
            return this.em
                    .createQuery("SELECT DISTINCT u FROM Cuenta u WHERE u.id = :id", Cuenta.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Cuenta> findAll() {
        return this.em
                .createQuery("SELECT DISTINCT u FROM Cuenta u ", Cuenta.class)
                .getResultList();
    }

    @Override
    public Cuenta save(Cuenta entity) {
        this.em.persist(entity);
        return entity;
    }

    @Override
    public Cuenta edit(Cuenta entity) {
        Cuenta cuenta = this.find(entity.getId());
        if (cuenta != null) {
            cuenta.setCliente(entity.getCliente());
            cuenta.setFechaApertura(entity.getFechaApertura());
            cuenta.setMoneda(entity.getMoneda());
            this.em.merge(cuenta);
        }
        return cuenta;
    }

    @Override
    public Cuenta remove(Integer id) {
        Cuenta cuenta = this.find(id);
        this.em.remove(cuenta);
        return cuenta;
    }

}
