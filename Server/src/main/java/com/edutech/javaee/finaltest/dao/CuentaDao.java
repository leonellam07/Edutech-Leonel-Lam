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
public class CuentaDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    public Cuenta buscar(Integer id) {
        try {
            return this.em
                    .createQuery("SELECT DISTINCT u FROM Cuenta u JOIN FETCH u.cliente JOIN FETCH u.tipoCuenta LEFT JOIN FETCH u.listaTransacciones WHERE u.id = :id", Cuenta.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<Cuenta> buscarTodo() {
        return this.em
                .createQuery("SELECT DISTINCT u FROM Cuenta u JOIN FETCH u.cliente JOIN FETCH u.tipoCuenta ", Cuenta.class)
                .getResultList();
    }

    public Cuenta guardar(Cuenta entity) {
        this.em.persist(entity);
        return entity;
    }

    public Cuenta editar(Cuenta entity) {
        Cuenta cuenta = this.buscar(entity.getId());
        if (cuenta != null) {
            cuenta.setCliente(entity.getCliente());
            cuenta.setFechaApertura(entity.getFechaApertura());
            cuenta.setMoneda(entity.getMoneda());
            this.em.merge(cuenta);
        }
        return cuenta;
    }

    public Cuenta eliminar(Integer id) {
        Cuenta cuenta = this.buscar(id);
        this.em.remove(cuenta);
        return cuenta;
    }

}
