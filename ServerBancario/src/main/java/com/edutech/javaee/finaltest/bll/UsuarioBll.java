/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.UsuarioDao;
import com.edutech.javaee.finaltest.dto.TokenUserDto;
import com.edutech.javaee.finaltest.model.Usuario;
import com.edutech.javaee.finaltest.operations.jwtToken;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class UsuarioBll {

    @Inject
    private UsuarioDao userDao;
    @Inject
    private jwtToken tokenEncrypt;

    public List<Usuario> listar() {
        return this.userDao.listar(Usuario.class);
    }

    public Usuario buscarId(Integer id) {
        return this.userDao.buscarId(id);
    }
    
    public Usuario buscarCodigo(String codigo){
        return this.userDao.buscarCodigo(codigo);
    }

    public Usuario crearRegistro(Usuario entity) {
        return this.userDao.guardar(entity);
    }

    public Usuario editarRegistro(Usuario entity) {
        Usuario usuario = this.userDao.buscarId(entity.getId());

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

    public Usuario eliminarRegistro(Integer idUsuario) {
        return this.userDao.eliminar(this.buscarId(idUsuario));
    }

    public TokenUserDto validarLogin(String codigo, String password) {
        Usuario usuario = this.userDao.login(codigo, password);
        return tokenEncrypt.create(usuario);
    }
}
