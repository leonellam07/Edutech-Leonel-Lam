/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource;

import com.edutech.javaee.finaltest.dao.CuentaDaoImp;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.Cuenta;
import com.edutech.javaee.finaltest.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author leolp
 */
@Stateless
@Path("/cuentas")
public class CuentaEnpoint {

    @Inject
    private CuentaDaoImp dao;

    @GET
    @Produces({"application/json"})
    public List<Cuenta> findAll() {
        return this.dao.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response findBy(@PathParam("id") Integer id) {
        Cuenta cuenta = this.dao.find(id);
        if (cuenta == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }
        
        return Response.ok(cuenta, MediaType.APPLICATION_JSON).build();
    }

}
