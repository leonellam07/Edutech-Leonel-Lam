package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Rol;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nahum
 */
public class RolDaoImp implements RolDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Override
    public List<Rol> findAll() {
        return this.em
                .createQuery("SELECT r FROM Rol r ", Rol.class)
                .getResultList();
    }

    @Override
    public Rol find(Integer id) {
        try {
            return this.em
                    .createQuery("SELECT r FROM Rol r WHERE r.id = :id", Rol.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
