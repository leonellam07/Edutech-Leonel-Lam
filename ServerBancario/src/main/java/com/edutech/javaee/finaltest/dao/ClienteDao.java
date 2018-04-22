/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Cliente;
import java.util.List;

/**
 *
 * @author leolp
 */
public class ClienteDao extends GenericDao<Cliente> {

    public List<Cliente> listar() {
        return this.em.createNamedQuery("Cliente.buscarTodo", Cliente.class)
                .getResultList();
    }

    public Cliente buscarId(Integer idCliente) {
        return this.em.createNamedQuery("Cliente.buscar",Cliente.class)
                .setParameter("idCliente", idCliente)
                .getSingleResult();
    }

}
