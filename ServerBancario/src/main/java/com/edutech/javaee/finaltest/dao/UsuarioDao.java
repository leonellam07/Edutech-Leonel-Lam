/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Usuario;

/**
 *
 * @author leolp
 */
public class UsuarioDao extends GenericDao<Usuario> {

    public Usuario buscarId(Integer idUsuario) {
        return this.em.find(Usuario.class, idUsuario);
    }

}
