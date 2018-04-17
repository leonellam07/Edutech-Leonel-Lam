/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Municipio;

/**
 *
 * @author leolp
 */
public class MunicipioDao extends GenericDao<Municipio> {

    public Municipio buscar(int idMunicipio) {
        return this.em
                .createQuery("SELECT m FROM Municipio m WHERE m.id = :id", Municipio.class)
                .setParameter("id", idMunicipio)
                .getSingleResult();
    }
}
