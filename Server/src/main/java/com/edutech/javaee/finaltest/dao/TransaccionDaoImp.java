/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Cuenta;
import com.edutech.javaee.finaltest.model.Transaccion;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leolp
 */
public class TransaccionDaoImp implements TransaccionDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Override
    public List<Transaccion> findAll(Integer id) {
        return this.em.createQuery("SELECT u FROM Transaccion u WHERE u.cuenta.id = :id", Transaccion.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public Transaccion depositar(Transaccion entity) {
        this.em.persist(entity);
        return entity;
    }

    @Override
    public Transaccion transferir(Transaccion entity) {
        float total = this.em.createNamedQuery("Transaccion.findMonto", Float.class)
                .setParameter("idcuenta", entity.getCuenta().getId())
                .getSingleResult();
        if (total > 0) {
            return null;
        }

        total = total - entity.getMonto();

        if (total > 0) {
            Cuenta cuenta = this.em.find(Cuenta.class, entity.getId_cuenta_trans());
            if (cuenta == null) {
                return null;
            }
            Transaccion transferencia = new Transaccion(cuenta, entity.getMonto(), entity.getTipoTransaccion(), entity.getDetalle());
            entity.setMonto(0 - entity.getMonto());

            this.em.persist(transferencia);
            this.em.persist(entity);

            return entity;
        }

        return null;
    }

    @Override
    public Transaccion debitar(Transaccion entity) {
        float total = this.em.createNamedQuery("Transaccion.findMonto", Float.class)
                .setParameter("idcuenta", entity.getCuenta().getId())
                .getSingleResult();
        if (total > 0) {
            return null;
        }

        total = total - entity.getMonto();
        if (total > 0) {
            entity.setMonto(0 - entity.getMonto());
            this.em.persist(entity);
            return entity;
        }

        return null;
    }

}
