/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leolp
 */
public class ClienteDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    public Cliente buscar(Integer id) {
        try {
            return this.em
                    .createNamedQuery("Cliente.buscar", Cliente.class)
                    .setParameter("idCliente", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            nre.printStackTrace();
            return null;
        }
    }

    public List<Cliente> listar() {
        return this.em
                .createNamedQuery("Cliente.buscarTodo", Cliente.class)
                .getResultList();
    }

    public Cliente guardar(Cliente entity) {
        this.em.persist(entity);
        return entity;
    }

    public Cliente editar(Cliente entity) {
        return this.em.merge(entity);

    }

    public Cliente eliminar(Integer id) {
        Cliente cliente = this.buscar(id);
        this.em.remove(cliente);
        return cliente;
    }

}
