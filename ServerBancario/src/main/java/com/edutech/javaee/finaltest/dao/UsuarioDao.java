/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Usuario;
import javax.persistence.NoResultException;

/**
 *
 * @author leolp
 */
public class UsuarioDao extends GenericDao<Usuario> {

    public Usuario buscarId(Integer idUsuario) {
        try {
            return this.em.find(Usuario.class, idUsuario);
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Usuario buscarCodigo(String codigo) {
        try {
            return this.em.createNamedQuery("Usuario.buscarCodigo", Usuario.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Usuario login(String codigo, String password) {
        try {
            return this.em.createNamedQuery("Usuario.login", Usuario.class)
                    .setParameter("codigo", codigo)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
