package com.edutech.javaee.finaltest.resource.rest;

import com.edutech.javaee.finaltest.model.Usuario;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.bll.UsuarioBll;
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
 * @author nahum
 */
@Stateless
@Path("/usuarios")
public class UsuarioEndpoint {

    @Inject
    private UsuarioBll userBll;

    @GET
    @Produces({"application/json"})
    public List<Usuario> listar() {
        List<Usuario> usuarios = this.userBll.Obtenerlistar();
        return usuarios;
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscarId(@PathParam("id") Integer id) {
        Usuario usuario = this.userBll.buscarId(id);
        if (usuario == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("{user}")
    @Produces({"application/json"})
    public Response buscarCodigo(@PathParam("codigo") String codigo) {
        Usuario usuario = this.userBll.buscarCodigo(codigo);
        if (usuario == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crear(Usuario entity) {
        return Response.ok(this.userBll.crearRegistro(entity)).build();
    }

    @PUT
    @Produces({"application/json"})
    public Response actualizar(Usuario entity) throws RollbackException {
        Usuario usuario = this.userBll.editarRegistro(entity);
        if (usuario == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(usuario).build();
    }

    @DELETE
    @Path("{user}")
    @Produces({"application/json"})
    public Response eliminar(@PathParam("id") Integer id) {
        Usuario usuario = this.userBll.eliminarRegistro(id);

        if (usuario == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(usuario).build();
    }

}
