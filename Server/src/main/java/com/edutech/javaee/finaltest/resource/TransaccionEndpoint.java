/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource;

import com.edutech.javaee.finaltest.dao.TransaccionDaoImp;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.Transaccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author leolp
 */
@Stateless
@Path("/transaccion")
public class TransaccionEndpoint {

    @Inject
    TransaccionDaoImp tranDao;
    
    

    @GET
    @Path("{id}") //Id de la cuenta
    @Produces({"application/json"})
    public List<Transaccion> buscarTransacciones(@PathParam("id") Integer id) {
        return this.tranDao.findAll(id);
    }

    @GET
    @Produces({"application/json"})
    @Path("total/{id}") //Id de la cuenta
    public Double montoCuenta(@PathParam("id") Integer id) {
        return this.tranDao.Monto(id);
    }

    @POST
    @Path("/deposito")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response depositar(Transaccion entity) {
//        entity.setCuenta(this.);
        this.tranDao.depositar(entity);
        return Response.ok(entity).build();
    }

    @POST
    @Path("/retiro")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response retiro(Transaccion entity) {
        this.tranDao.debitar(entity);
        return Response.ok(entity).build();
    }

    @POST
    @Path("/transferir")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response transferir(Transaccion entity) {
        if (entity.getId_cuenta_trans() == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "No hay cuenta para transferir"))
                    .build();
        }

        this.tranDao.transferir(entity);
        return Response.ok(entity).build();
    }

}
