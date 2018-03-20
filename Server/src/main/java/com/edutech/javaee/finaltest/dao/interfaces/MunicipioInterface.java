/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.dao.interfaces;

import com.edutech.javaee.finaltest.model.Municipio;
import java.util.List;

/**
 *
 * @author leolp
 */
public interface MunicipioInterface {

    public List<Municipio> listar();

    public Municipio buscar(int id);

}
