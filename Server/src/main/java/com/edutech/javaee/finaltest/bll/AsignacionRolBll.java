/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.AsignacionRolDao;
import com.edutech.javaee.finaltest.model.AsignacionRol;
import com.edutech.javaee.finaltest.model.Rol;
import com.edutech.javaee.finaltest.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class AsignacionRolBll {

    @Inject
    private AsignacionRolDao asgRolDao;

    public List<AsignacionRol> listaRoles() {
        List<AsignacionRol> lista = new ArrayList<>();

        for (AsignacionRol rol : this.asgRolDao.listar()) {
            AsignacionRol dtoRol = new AsignacionRol(
                    new Usuario(
                            rol.getUsuario().getId(),
                            rol.getUsuario().getCodigo(),
                            null,
                            rol.getUsuario().getNombre(),
                            null,
                            null,
                            null
                    ),
                    new Rol(
                            rol.getRol().getId(),
                            rol.getRol().getNombre(),
                            null
                    ),
                    rol.getDescripcion()
            );

            lista.add(dtoRol);
        }

        return lista;
    }

    public List<AsignacionRol> rolesUsuario(Integer id) {
        List<AsignacionRol> lista = new ArrayList<>();

        for (AsignacionRol rol : this.asgRolDao.buscar(id)) {
            AsignacionRol dtoRol = new AsignacionRol(
                    new Usuario(
                            rol.getUsuario().getId(),
                            rol.getUsuario().getCodigo(),
                            null,
                            rol.getUsuario().getNombre(),
                            null,
                            null,
                            null
                    ),
                    new Rol(
                            rol.getRol().getId(),
                            rol.getRol().getNombre(),
                            null
                    ),
                    rol.getDescripcion()
            );

            lista.add(dtoRol);
        }

        return lista;
    }

    public AsignacionRol guardar(AsignacionRol asignacion) {
        return this.asgRolDao.guardar(asignacion);
    }

    public AsignacionRol eliminar(AsignacionRol asignacion) {
        return this.asgRolDao.guardar(asignacion);
    }

}
