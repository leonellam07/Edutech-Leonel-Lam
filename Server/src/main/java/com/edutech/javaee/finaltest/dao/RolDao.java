package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Rol;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import com.edutech.javaee.finaltest.dao.interfaces.RolInterface;

/**
 *
 * @author nahum
 */
public class RolDao implements RolInterface {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Override
    public List<Rol> listar() {
        return this.em
                .createQuery("SELECT r FROM Rol r ", Rol.class)
                .getResultList();
    }

    @Override
    public Rol buscar(Integer id) {
        try {
            return this.em
                    .createQuery("SELECT r FROM Rol r WHERE r.id = :id", Rol.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Rol guardar(Rol entitty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol editar(Rol entitty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol eliminar(Rol entitty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
