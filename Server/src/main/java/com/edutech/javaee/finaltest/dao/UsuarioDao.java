package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nahum
 */
public class UsuarioDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    public Usuario buscar(Integer id) {
        try {
            return this.em
                    .createQuery("SELECT u FROM Usuario u  JOIN FETCH u.cliente WHERE u.id = :idUsuario", Usuario.class)
                    .setParameter("idUsuario", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public Usuario buscar(String codigo) {
        try {
            return this.em
                    .createQuery("SELECT u FROM Usuario u JOIN FETCH u.cliente WHERE u.codigo = :codigo", Usuario.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<Usuario> listar() {
        return this.em
                .createQuery("SELECT u FROM Usuario u JOIN FETCH u.cliente", Usuario.class)
                .getResultList();
    }

    public Usuario guardar(Usuario entity) {
        this.em.persist(entity);
        return entity;
    }

    public Usuario editar(Usuario entity) {
        Usuario usuario = this.em.merge(entity);
        return usuario;
    }

    public Usuario eliminar(Integer id) {
        Usuario usuario = this.buscar(id);
        this.em.remove(usuario);
        return usuario;
    }

}
