/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource.rest;

import com.edutech.javaee.finaltest.bll.CuentaBll;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.Cuenta;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Path("/cuentas")
public class CuentaEndpoint {

    @Inject
    private CuentaBll ctaBll;

    @GET
    @Produces({"application/json"})
    public List<Cuenta> lista() {
        return ctaBll.listar();
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscarId(@PathParam("id") Integer id) {
        Cuenta cuenta = this.ctaBll.buscarId(id);
        if (cuenta == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(cuenta, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crear(Cuenta entity) throws ParseException {
        Cuenta cuenta = this.ctaBll.guardar(entity);
        if (cuenta == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(cuenta).build();
    }

    @PUT
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response editar(Cuenta entity) throws ParseException {
        Cuenta cuenta = this.ctaBll.editar(entity);
        if (cuenta == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(cuenta).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({"application/json"})
    public Response eliminar(@PathParam("id") Integer id) {
        Cuenta cuenta = this.ctaBll.eliminar(id);
        if (cuenta == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(cuenta).build();
    }
}
