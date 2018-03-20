/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao.interfaces;

import com.edutech.javaee.finaltest.model.Rol;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface RolInterface {

    public Rol buscar(Integer id);

    public Rol guardar(Rol entitty);

    public Rol editar(Rol entitty);

    public Rol eliminar(Rol entitty);

    public List<Rol> listar();
}
