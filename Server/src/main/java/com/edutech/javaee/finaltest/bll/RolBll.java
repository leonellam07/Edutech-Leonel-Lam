/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.RolDao;
import com.edutech.javaee.finaltest.model.Rol;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.PathParam;

/**
 *
 * @author leolp
 */
public class RolBll {

    @Inject
    RolDao dao;

    public List<Rol> obtenerLista() {
        return this.dao.listar();
    }

    public Rol buscarId(@PathParam("id") Integer id) {
        return this.dao.buscar(id);
    }
}
