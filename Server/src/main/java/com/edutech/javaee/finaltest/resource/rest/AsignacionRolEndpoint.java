/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource.rest;

import com.edutech.javaee.finaltest.bll.AsignacionRolBll;

import com.edutech.javaee.finaltest.model.AsignacionRol;
import com.edutech.javaee.finaltest.model.Usuario;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/asignacionrol")
public class AsignacionRolEndpoint {

    @Inject
    private AsignacionRolBll asigRolBll;

    @GET
    @Produces({"application/json"})
    public List<AsignacionRol> lista() {
       return asigRolBll.listaRoles();
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public List<AsignacionRol> buscarId(@PathParam("id") Integer id) {
        return this.asigRolBll.rolesUsuario(id);
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response guardar(AsignacionRol entity) throws ParseException {
        return Response.ok(this.asigRolBll.guardar(entity)).build();
    }

    @DELETE
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response eliminar(AsignacionRol entity) throws ParseException {
        return Response.ok(this.asigRolBll.eliminar(entity)).build();
    }
}
