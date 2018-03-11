/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource;

import com.edutech.javaee.finaltest.dao.ClienteDaoImp;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.Cliente;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.RollbackException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/clientes")
public class ClienteEndpoint {

    @Inject
    private ClienteDaoImp cliDao;

    @GET
    @Produces({"application/json"})
    public List<Cliente> findAll() {
        return this.cliDao.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response findById(@PathParam("id") Integer id) {
        Cliente cliente = this.cliDao.find(id);
        if (cliente == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(cliente, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create(Cliente entity) throws ParseException {
        this.cliDao.save(entity);
        return Response.ok(entity).build();
    }

    @PUT
    @Produces({"application/json"})
    public Response update(Cliente entity) throws RollbackException {
        Cliente cliente = this.cliDao.edit(entity);

        if (cliente == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(cliente).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({"application/json"})
    public Response delete(@PathParam("id") Integer id) {
        Cliente cliente = this.cliDao.remove(id);

        if (cliente == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(cliente).build();
    }

}
