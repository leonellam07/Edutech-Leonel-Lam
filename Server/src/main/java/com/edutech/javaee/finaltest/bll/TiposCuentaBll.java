/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.TiposCuentaDao;
import com.edutech.javaee.finaltest.model.TiposCuenta;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class TiposCuentaBll {

    @Inject
    private TiposCuentaDao tpcDao;

    public List<TiposCuenta> obtenerLista() {
        return this.tpcDao.listar();
    }

    public TiposCuenta buscarId(Integer id) {
        return this.tpcDao.buscar(id);
    }

}
