package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import com.edutech.javaee.finaltest.dao.interfaces.UsuarioInterface;

/**
 *
 * @author nahum
 */
public class UsuarioDao implements UsuarioInterface {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Override
    public Usuario buscar(Integer id) {
        try {
            return this.em
                    .createQuery("SELECT u FROM Usuario u JOIN FETCH u.rol JOIN FETCH u.cliente WHERE u.id = :idUsuario", Usuario.class)
                    .setParameter("idUsuario", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Usuario buscar(String codigo) {
        try {
            return this.em
                    .createQuery("SELECT u FROM Usuario u JOIN FETCH u.rol WHERE u.codigo = :codigo", Usuario.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Usuario> listar() {
        return this.em
                .createQuery("SELECT u FROM Usuario u JOIN FETCH u.rol JOIN FETCH u.cliente", Usuario.class)
                .getResultList();
    }

    @Override
    public Usuario guardar(Usuario entity) {
        this.em.persist(entity);
        return entity;
    }

    @Override
    public Usuario editar(Usuario entity) {
        Usuario usuario = this.em.merge(entity);
        return usuario;
    }

    @Override
    public Usuario eliminar(Integer id) {
        Usuario usuario = this.buscar(id);
        this.em.remove(usuario);
        return usuario;
    }

}
