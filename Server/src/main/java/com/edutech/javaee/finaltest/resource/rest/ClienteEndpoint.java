/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource.rest;

import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.bll.ClienteBll;
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
    private ClienteBll cliBll;

    @GET
    @Produces({"application/json"})
    public List<Cliente> lista() {
        return this.cliBll.obtenerLista();
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscarId(@PathParam("id") Integer id) {

        Cliente cliente = this.cliBll.buscarId(id);
        if (cliente == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Cliente no encontrado"))
                    .build();
        }

        return Response.ok(cliente, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crear(Cliente entity) throws ParseException {
        return Response.ok(this.cliBll.crearRegistro(entity)).build();
    }

    @PUT
    @Produces({"application/json"})
    public Response editar(Cliente entity) throws RollbackException {

        Cliente cliente = this.cliBll.editarRegistro(entity);
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
    public Response eliminar(@PathParam("id") Integer id) {
        Cliente cliente = this.cliBll.eliminarRegistro(id);

        if (cliente == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(cliente).build();
    }

}
