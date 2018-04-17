/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Rol;

/**
 *
 * @author leolp
 */
public class RolDao extends GenericDao<Rol> {

    public Rol buscarId(Integer idRol) {
        return this.em.find(Rol.class, idRol);
    }
}
