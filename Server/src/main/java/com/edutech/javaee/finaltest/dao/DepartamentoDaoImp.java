package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Departamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nahum
 */
public class DepartamentoDaoImp implements DepartamentoDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Override
    public Departamento find(Integer id) {
        try {
            return this.em
                    .createNamedQuery("Departamento.findById", Departamento.class)
                    .setParameter("idDepartamento", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Departamento> findAll() {
        return this.em.createNamedQuery("Departamento.findAll").getResultList();
    }

    @Override
    public Departamento save(Departamento entity) {

        this.setChildren(entity);
        this.em.persist(entity);
        return entity;

    }

    @Override
    public Departamento edit(Departamento entity) {

        if (this.find(entity.getId()) != null) {
            this.setChildren(entity);
            this.em.merge(entity);
            return entity;
        }

        return null;

    }

    @Override
    public Departamento remove(Integer id) {
        Departamento departamento = this.find(id);
        this.em.remove(departamento);
        return departamento;
    }

    private void setChildren(Departamento entity) {
        entity.getMunicipios().stream().forEach((municipio) -> {
            municipio.setDepartamento(entity);
        });
    }

}
