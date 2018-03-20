/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.UsuarioDao;
import com.edutech.javaee.finaltest.model.Usuario;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class UsuarioBll {

    @Inject
    private UsuarioDao userDao;

    public List<Usuario> Obtenerlistar() {
        return this.userDao.listar();
    }

    public Usuario buscarId(Integer id) {
        return this.userDao.buscar(id);
    }

    public Usuario buscarCodigo(String codigo) {
        return this.userDao.buscar(codigo);
    }

    public Usuario crearRegistro(Usuario entity) {
        return this.userDao.guardar(entity);
    }

    public Usuario editarRegistro(Usuario entity) {
        Usuario usuario = this.userDao.buscar(entity.getId());

        if (usuario != null) {
            usuario.setCodigo(entity.getCodigo());
            usuario.setEmail(entity.getEmail());
            usuario.setNombre(entity.getNombre());
            usuario.setPassword(entity.getPassword());
            usuario.setTelefono(entity.getTelefono());
            this.userDao.editar(usuario);
        }

        return usuario;
    }

    public Usuario eliminarRegistro(Integer id) {
        return this.userDao.eliminar(id);
    }
}
