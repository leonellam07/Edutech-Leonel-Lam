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
public class DepartamentoDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    public Departamento buscar(Integer id) {
        try {
            return this.em
                    .createNamedQuery("Departamento.buscar", Departamento.class)
                    .setParameter("idDepartamento", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<Departamento> listar() {
        return this.em.createNamedQuery("Departamento.buscarTodo").getResultList();
    }

    public Departamento guardar(Departamento entity) {

        this.setChildren(entity);
        this.em.persist(entity);
        return entity;

    }

    public Departamento editar(Departamento entity) {

        if (this.buscar(entity.getId()) != null) {
            this.setChildren(entity);
            this.em.merge(entity);
            return entity;
        }

        return null;

    }

    public Departamento eliminar(Integer id) {
        Departamento departamento = this.buscar(id);
        this.em.remove(departamento);
        return departamento;
    }

    private void setChildren(Departamento entity) {
        entity.getMunicipios().stream().forEach((municipio) -> {
            municipio.setDepartamento(entity);
        });
    }

}
