/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.AsignacionRolDao;
import com.edutech.javaee.finaltest.model.AsignacionRol;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class AsignacionRolBll {

    @Inject
    private AsignacionRolDao asgRolDao;

    public List<AsignacionRol> lista() {
        return this.asgRolDao.listar();
    }

    public List<AsignacionRol> listaRolesXUsuario(Integer idUsuario) {
          return this.asgRolDao.listaXUsuario(idUsuario);
    }

    public AsignacionRol guardar(AsignacionRol asignacion) {
        return this.asgRolDao.guardar(asignacion);
    }

    public AsignacionRol eliminar(AsignacionRol asignacion) {
        return this.asgRolDao.guardar(asignacion);
    }

}
