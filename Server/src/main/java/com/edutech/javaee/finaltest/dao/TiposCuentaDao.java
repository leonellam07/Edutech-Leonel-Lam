/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.TiposCuenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leolp
 */
public class TiposCuentaDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    public TiposCuenta buscar(Integer id) {
        try {
            return this.em
                    .createQuery("SELECT u FROM TiposCuenta u WHERE u.id = :parametro", TiposCuenta.class)
                    .setParameter("parametro", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<TiposCuenta> listar() {
        return this.em
                .createQuery("SELECT u FROM TiposCuenta u", TiposCuenta.class)
                .getResultList();
    }

}
