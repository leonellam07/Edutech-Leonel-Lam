/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Usuario;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface UsuarioDao {

    public Usuario find(String id);

    public List<Usuario> findAll();

    public Usuario save(Usuario entity);

    public Usuario edit(Usuario entity);

    public Usuario remove(String user);
}
