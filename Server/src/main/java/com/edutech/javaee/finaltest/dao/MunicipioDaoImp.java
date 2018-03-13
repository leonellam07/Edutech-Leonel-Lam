/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Municipio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leolp
 */
public class MunicipioDaoImp implements MunicipioDao {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Override
    public List<Municipio> findAll() {
        return this.em
                .createQuery("SELECT m FROM Municipio m ", Municipio.class)
                .getResultList();
    }

    @Override
    public Municipio findById(int id) {
        return this.em
                .createQuery("SELECT m FROM Municipio m WHERE m.id = :id", Municipio.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
