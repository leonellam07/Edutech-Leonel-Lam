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
public interface ClienteDao {

    public Cliente find(Integer id);

    public List<Cliente> findAll();

    public Cliente save(Cliente entity);

    public Cliente edit(Cliente entity);

    public Cliente remove(Integer id);

}
