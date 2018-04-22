/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource.rest;

import com.edutech.javaee.finaltest.bll.CuentaBll;
import com.edutech.javaee.finaltest.bll.TarjetaDebitoBll;
import com.edutech.javaee.finaltest.model.Cuenta;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
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
@Path("/tarjeta")
public class TarjetaDebitoEndpoint {

    @Inject
    private TarjetaDebitoBll tarBll;
    @Inject
    private CuentaBll ctaBll;

    @GET
    @Path("/validar")
    @Produces({"application/json"})
    public Response validar(@FormParam("numero") String numero, @FormParam("pin") String pin) {
        String id = this.tarBll.validar(numero, pin);
        if (id != null) {
            return Response.ok(id).build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .type(MediaType.TEXT_HTML)
                    .entity("Recurso no encontrado")
                    .build();
        }
    }

    @GET
    @Path("/consulta/{idTarjeta}")
    @Produces({"application/json"})
    public Response consultaCuentas(@PathParam("idTarjeta") Integer idTarjeta) {
        this.ctaBll.
        return Response.ok().build();
    }

  
}
