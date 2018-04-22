/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.TarjetaDao;
import com.edutech.javaee.finaltest.dto.TokenUserDto;
import com.edutech.javaee.finaltest.dto.UsuarioDto;
import com.edutech.javaee.finaltest.model.TarjetaDebito;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class TarjetaBll {

    @Inject
    TarjetaDao tarDao;

    public TokenUserDto validar(String numero, String pin) {
        TarjetaDebito tarjeta = this.tarDao.validar(numero, pin);
        if (tarjeta != null) {
            UsuarioDto usuario = //enlace
        }
    }

}
