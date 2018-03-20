/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao.interfaces;

import com.edutech.javaee.finaltest.model.Cliente;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface ClienteInterface {

    public Cliente buscar(Integer id);

    public List<Cliente> listar();

    public Cliente guardar(Cliente entity);

    public Cliente editar(Cliente entity);

    public Cliente eliminar(Integer id);

}
