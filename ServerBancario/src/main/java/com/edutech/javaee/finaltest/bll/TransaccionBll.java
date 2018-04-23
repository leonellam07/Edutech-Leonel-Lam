/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.CuentaDao;
import com.edutech.javaee.finaltest.dao.TransaccionDao;
import com.edutech.javaee.finaltest.model.Cuenta;
import com.edutech.javaee.finaltest.model.TipoTransaccion;
import com.edutech.javaee.finaltest.model.Transaccion;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class TransaccionBll {

    @Inject
    private TransaccionDao tranDao;
    @Inject
    private CuentaDao ctaDao;

    public Transaccion debitar(Transaccion entity) {
        entity.setTipoTransaccion(new TipoTransaccion(1, null, null));
        entity.setIdCuentaxTransferir(null);
        Double total = this.tranDao.total(entity.getCuenta().getId());
        if (total - entity.getMonto() > 0) {
            entity.setMonto(0 - entity.getMonto());
            this.tranDao.guardar(entity);
            return entity;
        }

        return null;
    }

    public Transaccion transferir(Transaccion entity) {
        entity.setTipoTransaccion(new TipoTransaccion(3, null, null));
        entity.setDetalle("Transferencia de la cuenta:{" + entity.getCuenta().getId() + "}, " + entity.getDetalle());
        Double total = this.tranDao.total(entity.getCuenta().getId());
        if (total - entity.getMonto() > 0) {

            Cuenta cuenta = this.ctaDao.buscarId(entity.getIdCuentaxTransferir());
            if (cuenta == null) {
                return null;
            }

            Transaccion transferencia = new Transaccion(
                    cuenta,
                    entity.getMonto(),
                    new TipoTransaccion(2, null, null),
                    "Transferencia de la cuenta:{" + entity.getCuenta().getId() + "}, " + entity.getDetalle(),
                    entity.getIdCuentaxTransferir()
            );
            this.tranDao.guardar(transferencia);

            entity.setMonto(0 - entity.getMonto());
            this.tranDao.guardar(entity);

            return entity;
        }

        return null;
    }

    public Transaccion depositar(Transaccion entity) {
        entity.setTipoTransaccion(new TipoTransaccion(2, null, null));
        entity.setIdCuentaxTransferir(null);
        this.tranDao.guardar(entity);
        return entity;
    }
}
