/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.TarjetaDebitoDao;
import com.edutech.javaee.finaltest.model.TarjetaDebito;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class TarjetaDebitoBll {

    @Inject
    private TarjetaDebitoDao tarDao;

    public String validar(String numero, String pin) {
        TarjetaDebito tarjeta = this.tarDao.validar(numero, pin);
        if (tarjeta != null) {
            return tarjeta.getId().toString();
        }

        return null;
    }

}
