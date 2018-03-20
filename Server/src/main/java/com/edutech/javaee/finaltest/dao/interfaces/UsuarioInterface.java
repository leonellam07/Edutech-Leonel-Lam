/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao.interfaces;

import com.edutech.javaee.finaltest.model.Usuario;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface UsuarioInterface {

    public Usuario buscar(Integer id);

    public Usuario buscar(String codigo);

    public List<Usuario> listar();

    public Usuario guardar(Usuario entity);

    public Usuario editar(Usuario entity);

    public Usuario eliminar(Integer id);
}
