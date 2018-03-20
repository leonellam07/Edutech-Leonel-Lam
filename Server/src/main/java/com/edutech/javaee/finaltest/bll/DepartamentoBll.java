/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.bll;

import com.edutech.javaee.finaltest.dao.DepartamentoDao;
import com.edutech.javaee.finaltest.model.Departamento;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author leolp
 */
public class DepartamentoBll {

    @Inject
    DepartamentoDao deptoDao;
    
    
    public List<Departamento> obtenerLista(){
        return this.deptoDao.listar();
    }
    
    public Departamento buscarId(Integer id){
        return this.deptoDao.buscar(id);
    }
    
}
