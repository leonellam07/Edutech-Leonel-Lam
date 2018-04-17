/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.AsignacionRol;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leolp
 */
public class AsignacionRolDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    public List<AsignacionRol> buscar(Integer id) {
        return this.em
                .createNamedQuery("AsignacionRol.buscar", AsignacionRol.class)
                .setParameter("idAsignacionRol", id)
                .getResultList();
    }

    public List<AsignacionRol> listar() {
        return this.em
                .createNamedQuery("AsignacionRol.buscarTodo", AsignacionRol.class)
                .getResultList();
    }

    public AsignacionRol guardar(AsignacionRol entity) {
        this.em.persist(entity);
        return entity;
    }


    public AsignacionRol eliminar(AsignacionRol asignacion) {
        this.em.remove(asignacion);
        return asignacion;
    }
}
