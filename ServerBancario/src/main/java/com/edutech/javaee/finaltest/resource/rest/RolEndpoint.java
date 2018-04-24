package com.edutech.javaee.finaltest.resource.rest;

import com.edutech.javaee.finaltest.bll.AsignacionRolBll;
import com.edutech.javaee.finaltest.bll.RolBll;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.AsignacionRol;
import com.edutech.javaee.finaltest.model.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author nahum
 */
@Stateless
@Path("/roles")
public class RolEndpoint {

    @Inject
    RolBll rolBll;

    @Inject
    AsignacionRolBll asgRolBll;

    @GET
    @Produces({"application/json"})
    public List<Rol> lista(@Context SecurityContext context) {
        if (context.isUserInRole("ADMIN")) {
            return this.rolBll.obtenerLista();
        }
        return null;
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscarId(@Context SecurityContext context, @PathParam("id") Integer id) {
        if (context.isUserInRole("ADMIN")) {
            Rol rol = this.rolBll.buscarId(id);
            if (rol == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                        .build();
            }

            return Response.ok(rol, MediaType.APPLICATION_JSON).build();
        }

        return Response
                .status(Response.Status.UNAUTHORIZED)
                .entity(new ErrorMessageDto(false, Response.Status.UNAUTHORIZED.getStatusCode(), "No tiene permisos para leer roles"))
                .build();
    }

    @GET
    @Path("/asignacion/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AsignacionRol> buscarAsignacionUsuario(@Context SecurityContext context, @PathParam("idUsuario") Integer idUsuario) {

        if (context.isUserInRole("ADMIN")) {
            return asgRolBll.listaRolesXUsuario(idUsuario);
        }

        return null;
    }

    @GET
    @Path("/asignacion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AsignacionRol> buscarAsignacionUsuario(@Context SecurityContext context) {

        if (context.isUserInRole("ADMIN")) {
            return asgRolBll.lista();
        }

        return null;
    }
}
