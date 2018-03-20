/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao.interfaces;

import com.edutech.javaee.finaltest.model.Cuenta;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface CuentaInterface {

    public Cuenta buscar(Integer id);

    public List<Cuenta> buscarTodo();

    public Cuenta guardar(Cuenta entity);

    public Cuenta editar(Cuenta entity);

    public Cuenta eliminar(Integer id);

}
