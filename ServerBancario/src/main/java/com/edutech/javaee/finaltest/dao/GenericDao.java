/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author leolp
 * @param <T>
 */
public class GenericDao<T> {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    private Class<T> entityClass;

    public GenericDao() {
        entityClass = null;
    }

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T guardar(T entity) {
        this.em.persist(entity);
        return entity;
    }

    public T editar(T entity) {
        this.em.merge(entity);
        return entity;
    }

    public T eliminar(T entity) {
        this.em.remove(entity);
        return entity;
    }

    public List<T> listar(Class<T> entityClass) {
        this.entityClass = entityClass;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(this.entityClass);
        Root<T> rootEntry = cq.from(this.entityClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        return em.createQuery(all).getResultList();
    }

}
