/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.AsignacionRol;
import java.util.List;

/**
 *
 * @author leolp
 */
public class AsignacionRolDao extends GenericDao<AsignacionRol> {

    public List<AsignacionRol> listaXUsuario(Integer idUsuario) {
        return this.em
                .createNamedQuery("AsignacionRol.buscar", AsignacionRol.class)
                .setParameter("idUsuario", idUsuario)
                .getResultList();
    }
    
     public List<AsignacionRol> listar() {
        return this.em
                .createNamedQuery("AsignacionRol.buscarTodo", AsignacionRol.class)
                .getResultList();
    }

}
