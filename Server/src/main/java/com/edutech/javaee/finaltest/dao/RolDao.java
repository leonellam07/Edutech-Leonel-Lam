/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao;

import com.edutech.javaee.finaltest.model.Rol;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface RolDao {

    public Rol find(Integer id);

    public List<Rol> findAll();

}