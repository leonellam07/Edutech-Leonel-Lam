/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Cliente;
import com.edutech.javaee.finaltest.model.Municipio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leolp
 */
public class ClienteDaoImp implements ClienteDao {
    
    @PersistenceContext(unitName = "primary")
    EntityManager em;
    
    @Override
    public Cliente find(Integer id) {
        try {
            return this.em
                    .createQuery("SELECT u FROM Cliente u JOIN FETCH u.muni  WHERE u.id = :parametro", Cliente.class)
                    .setParameter("parametro", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    @Override
    public List<Cliente> findAll() {
        return this.em
                .createQuery("SELECT u FROM Cliente u JOIN FETCH u.muni  ", Cliente.class)
                .getResultList();
    }
    
    @Override
    public Cliente save(Cliente entity) {
        System.err.println(entity);
        this.em.persist(entity);
        return entity;
    }
    
    @Override
    public Cliente edit(Cliente entity) {
        Cliente cliente = this.find(entity.getId());
        if (cliente != null) {
            cliente.setDireccion(entity.getDireccion());
            cliente.setFechaNacimiento(entity.getFechaNacimiento());
            cliente.setMuni(entity.getMuni());
            cliente.setNit(entity.getNit());
            cliente.setNombre(entity.getNombre());
            cliente.setMuni(this.em.find(Municipio.class, entity.getMuni().getId()));
            this.em.merge(cliente);
        }
        return cliente;
    }
    
    @Override
    public Cliente remove(Integer id) {
        Cliente cliente = this.find(id);
        this.em.remove(cliente);
        return cliente;
    }
    
}
