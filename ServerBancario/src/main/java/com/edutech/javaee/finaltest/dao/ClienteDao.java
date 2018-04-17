/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Cliente;

/**
 *
 * @author leolp
 */
public class ClienteDao extends GenericDao<Cliente> {

    public Cliente buscarId(Integer idCliente) {
        return this.em.find(Cliente.class, idCliente);
    }

}
