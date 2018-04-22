/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource.rest;

import com.edutech.javaee.finaltest.bll.CuentaBll;
import com.edutech.javaee.finaltest.bll.TarjetaDebitoBll;
import com.edutech.javaee.finaltest.bll.TransaccionBll;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.Cuenta;
import com.edutech.javaee.finaltest.model.Transaccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    @Inject
    private TransaccionBll tranBll;

    @POST
    @Path("/validar")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validar(@FormParam("numero") String numero, @FormParam("pin") String pin) {

        if (numero != null && pin != null) {

            String id = this.tarBll.validar(numero, pin);

            if (id != null) {
                JsonObjectBuilder json = Json.createObjectBuilder();
                json.add("mensaje", "Login valido");
                json.add("id", id);
                return Response.ok(json.build()).build();
            }
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity(new ErrorMessageDto(false, 401, "Usuario o clave inválidos")).build();

    }

    @GET
    @Path("/consulta/{numero}")
    @Produces({"application/json"})
    public List<Cuenta> consultaCuentas(@PathParam("numero") String numero) {
        return this.ctaBll.listarTarjeta(numero);
    }

    @POST
    @Path("/deposito")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response depositar(Transaccion entity) {
        Transaccion respuesta = this.tranBll.depositar(entity);
        if (respuesta != null) {
            return Response.ok(entity).build();
        }
        return Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .type(MediaType.TEXT_HTML)
                .entity("Imposible realizar operacion")
                .build();
    }

    @POST
    @Path("/debito")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response debito(Transaccion entity) {
        Transaccion respuesta = this.tranBll.debitar(entity);
        if (respuesta != null) {
            return Response.ok(entity).build();
        }
        return Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .type(MediaType.TEXT_HTML)
                .entity("Imposible realizar operacion")
                .build();
    }

    @POST
    @Path("/transferir")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response transferir(Transaccion entity) {
        if (entity.getIdCuentaTrans() == null || entity.getCuenta() == null) {
            return Response
                    .status(Response.Status.NOT_ACCEPTABLE)
                    .type(MediaType.TEXT_HTML)
                    .entity("No hay cuenta para transferir")
                    .build();
        }

        Transaccion respuesta = this.tranBll.debitar(entity);
        if (respuesta != null) {
            return Response.ok(entity).build();
        }

        return Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .type(MediaType.TEXT_HTML)
                .entity("Imposible realizar operacion")
                .build();
    }
}
