/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Transaccion;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface TransaccionDao {

    public List<Transaccion> findAll(Integer id);

    public Transaccion depositar(Transaccion entity);

    public Transaccion transferir(Transaccion entity);

    public Transaccion debitar(Transaccion entity);

}
