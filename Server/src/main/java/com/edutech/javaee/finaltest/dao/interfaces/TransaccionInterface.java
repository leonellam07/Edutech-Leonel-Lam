/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao.interfaces;

import com.edutech.javaee.finaltest.model.Transaccion;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface TransaccionInterface {

    public List<Transaccion> listaTransacciones(Integer id);

    public Transaccion guardar(Transaccion entity);

}
