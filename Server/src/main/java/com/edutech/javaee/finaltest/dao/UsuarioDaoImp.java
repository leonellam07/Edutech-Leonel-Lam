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
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Override
    public Usuario find(Integer id) {
        try {
            return this.em
                    .createQuery("SELECT u FROM Usuario u JOIN FETCH u.rol WHERE u.id = :parametro", Usuario.class)
                    .setParameter("parametro", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Usuario> findAll() {
        return this.em
                .createQuery("SELECT u FROM Usuario u JOIN FETCH u.rol JOIN FETCH u.cliente", Usuario.class)
                .getResultList();
    }

    @Override
    public Usuario save(Usuario entity) {
        this.em.persist(entity);
        return entity;
    }

    @Override
    public Usuario edit(Usuario entity) {
        Usuario usuario = this.find(entity.getId());
        if (usuario != null) {
            usuario.setCodigo(entity.getCodigo());
            usuario.setEmail(entity.getEmail());
            usuario.setNombre(entity.getNombre());
            usuario.setPassword(entity.getPassword());
            usuario.setTelefono(entity.getTelefono());
            this.em.merge(usuario);
        }
        return usuario;
    }

    @Override
    public Usuario remove(Integer id) {
        Usuario usuario = this.find(id);
        this.em.remove(usuario);
        return usuario;
    }
}
