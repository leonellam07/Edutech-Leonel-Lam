/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.ClienteDao;
import com.edutech.javaee.finaltest.dao.CuentaDao;
import com.edutech.javaee.finaltest.model.Cuenta;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class CuentaBll {

    @Inject
    private CuentaDao ctaDao;
    @Inject
    private ClienteDao cliDao;

    public List<Cuenta> obtenerLista() {

        List<Cuenta> lista = new ArrayList<>();
        this.ctaDao.buscarTodo().stream().map((cuenta) -> {
            cuenta.setListaTransacciones(null);
            return cuenta;
        }).forEachOrdered((cuenta) -> {
            lista.add(cuenta);
        });

        return lista;
    }

    public Cuenta buscarId(Integer idCuenta) {
        Cuenta cuenta= this.ctaDao.buscarId(idCuenta);
        cuenta.setListaTransacciones(null);
        return cuenta;
    }

    public Cuenta crearRegistro(Cuenta entity) {
        return this.ctaDao.guardar(entity);
    }

    public Cuenta editarRegistro(Cuenta entity) {
        Cuenta cuenta = this.buscarId(entity.getId());

        if (cuenta != null) {
            cuenta.setActivo(entity.isActivo());
            cuenta.setCliente(this.cliDao.buscar(entity.getCliente().getId()));
            cuenta.setFechaApertura(entity.getFechaApertura());
            cuenta.setMoneda(entity.getMoneda());
            cuenta.setTipoCuenta(entity.getTipoCuenta());
            this.ctaDao.editar(cuenta);
        }

        return cuenta;
    }

    public Cuenta eliminarRegistro(Integer id) {
        return this.ctaDao.eliminar(id);
    }

}
