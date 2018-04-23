/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource;

import com.edutech.javaee.finaltest.dto.CuentaDto;
import com.edutech.javaee.finaltest.dto.TransaccionDto;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author leolp
 */
@Stateless
@Path("/tarjeta")
public class tarjeta {

    @GET
    @Path("/prueba")
    @Produces(MediaType.APPLICATION_JSON)
    public Response prueba() {

        JsonObjectBuilder json = Json.createObjectBuilder();
        json.add("prueba", "test");
        return Response.ok(json.build()).build();
    }

    @POST
    @Path("/validar")
    @Consumes(value = {MediaType.APPLICATION_FORM_URLENCODED})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response validarTarjeta(@FormParam("numero") String numero, @FormParam("pin") String pin) {
        Client client = ClientBuilder.newClient();
        Form form = new Form();
        form.param("numero", numero).param("pin", pin);

        Response response = client
                .target("http://localhost:8081/bancared/api/tarjeta/validar")
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.form(form), Response.class);

        JsonObject json = response.readEntity(JsonObject.class);

        return Response.ok(json).build();
    }

    @GET
    @Path("/consulta/{numeroTarjeta}")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<CuentaDto> consultar(@PathParam("numeroTarjeta") String numeroTarjeta) {
        Client client = ClientBuilder.newClient();

        List<CuentaDto> lista = client
                .target("http://localhost:8081/bancared/api/tarjeta/consulta/" + numeroTarjeta)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<CuentaDto>>() {
                });

        return lista;
    }

    @POST
    @Path("/debitar")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response debitar(TransaccionDto transaccion) {
        Client client = ClientBuilder.newClient();

        Response response = client
                .target("http://localhost:8081/bancared/api/tarjeta/debito")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(transaccion, MediaType.APPLICATION_JSON));

        JsonObject json = response.readEntity(JsonObject.class);

        return Response.ok(json).build();
    }

    @POST
    @Path("/depositar")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response depositar(TransaccionDto transaccion) {

        Client client = ClientBuilder.newClient();

        Response response = client
                .target("http://localhost:8081/bancared/api/tarjeta/deposito")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(transaccion, MediaType.APPLICATION_JSON));

        JsonObject json = response.readEntity(JsonObject.class);

        return Response.ok(json).build();
    }

    @POST
    @Path("/transferir")
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response transferir(TransaccionDto transaccion) {
        Client client = ClientBuilder.newClient();

        Response response = client
                .target("http://localhost:8081/bancared/api/tarjeta/transferir")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(transaccion, MediaType.APPLICATION_JSON));

        JsonObject json = response.readEntity(JsonObject.class);

        return Response.ok(json).build();
    }

}
