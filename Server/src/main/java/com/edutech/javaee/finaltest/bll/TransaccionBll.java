/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.CuentaDao;
import com.edutech.javaee.finaltest.dao.TransaccionDao;
import com.edutech.javaee.finaltest.model.Cuenta;
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
        Double total = this.tranDao.monto(entity.getId());

        if (total - entity.getMonto() > 0) {
            entity.setMonto(0 - entity.getMonto());
            this.tranDao.guardar(entity);
            return entity;
        }

        return null;
    }

    public Transaccion transferir(Transaccion entity) {
        Double total = this.tranDao.monto(entity.getId());
        if (total - entity.getMonto() > 0) {
            entity.setMonto(0 - entity.getMonto());

            Cuenta cuenta = this.ctaDao.buscar(entity.getIdCuentaTrans());
            if (cuenta == null) {
                return null;
            }

            Transaccion transferencia = new Transaccion(
                    cuenta,
                    entity.getMonto(),
                    entity.getTipoTransaccion(),
                    entity.getDetalle(),
                    entity.getIdCuentaTrans()
            );
            entity.setMonto(0 - entity.getMonto());

            this.tranDao.guardar(transferencia);
            this.tranDao.guardar(entity);
            return entity;
        }

        return null;
    }

    public Transaccion depositar(Transaccion entity) {
        this.tranDao.guardar(entity);
        return entity;
    }

}
