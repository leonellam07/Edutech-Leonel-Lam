/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource.rest;

import com.edutech.javaee.finaltest.bll.ClienteBll;
import com.edutech.javaee.finaltest.bll.RolBll;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.Cliente;
import com.edutech.javaee.finaltest.operations.ImagesManagment;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.RollbackException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author leolp
 */
@Stateless
@Path("/clientes")
public class ClienteEndpoint {

    @Inject
    private ClienteBll cliBll;
    @Inject
    private RolBll rolBll;

    @GET
    @Produces({"application/json"})
    public List<Cliente> lista(@Context SecurityContext context) {
        if (context.isUserInRole("ADMIN")) {
            return this.cliBll.listar();
        } else {
            return null;
        }

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
    public Response crear(@Context SecurityContext context, Cliente entity) throws ParseException {
        if (context.isUserInRole("ADMIN")) {
            return Response.ok(this.cliBll.guardar(entity)).build();
        }

        return Response
                .status(Status.UNAUTHORIZED)
                .entity(new ErrorMessageDto(false, Status.UNAUTHORIZED.getStatusCode(), "No tiene permisos para crear clientes"))
                .build();
    }

    @PUT
    @Produces({"application/json"})
    public Response editar(@Context SecurityContext context, Cliente entity) throws RollbackException {

        if (context.isUserInRole("ADMIN")) {
            Cliente cliente = this.cliBll.editar(entity);
            if (cliente == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                        .build();
            }

            return Response.ok(cliente).build();
        }

        return Response
                .status(Status.UNAUTHORIZED)
                .entity(new ErrorMessageDto(false, Status.UNAUTHORIZED.getStatusCode(), "No tiene permisos para modificar clientes"))
                .build();

    }

    @DELETE
    @Path("{id}")
    @Produces({"application/json"})
    public Response eliminar(@Context SecurityContext context, @PathParam("id") Integer id) {

        if (context.isUserInRole("ADMIN")) {
            Cliente cliente = this.cliBll.eliminarRegistro(id);

            if (cliente == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                        .build();
            }

            return Response.ok(cliente).build();
        }

        return Response
                .status(Status.UNAUTHORIZED)
                .entity(new ErrorMessageDto(false, Status.UNAUTHORIZED.getStatusCode(), "No tiene permisos para eliminar clientes"))
                .build();
    }

    @GET
    @Path("imagen/{idCliente}")
    public Response descargarFoto(@PathParam("idCliente") Integer id) {
        if (id == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        Cliente cliente = cliBll.buscarId(id);

        if (cliente == null || cliente.getMymeType() == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        Response.ResponseBuilder rb = Response.ok(cliente.getImagen());
        rb.type(cliente.getMymeType());
        rb.header("Content-disposition", "inline; filename=" + cliente.getNombreImagen());
        return rb.build();
    }

    @POST
    @Path("imagen/{idCliente}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response subirFoto(@Context HttpServletRequest request, @Context SecurityContext context, @PathParam("idCliente") Integer idCliente) {
        try {
            Cliente cliente = this.cliBll.buscarId(idCliente);

            ServletFileUpload upload = new ServletFileUpload();
            FileItemIterator fileIterator = upload.getItemIterator(request);
            while (fileIterator.hasNext()) {
                FileItemStream item = fileIterator.next();

                if (item.getContentType() != null) {
                    cliente.setNombreImagen(item.getName());
                    cliente.setMymeType(item.getContentType());
                    cliente.setImagen(ImagesManagment.readFully(item.openStream(), 1000000, true));
                }
            }
            this.cliBll.editar(cliente);
        } catch (IOException | FileUploadException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorMessageDto(true, 500, "Hubo un error al cargar el archivo")).build();
        }

        return Response.ok(new ErrorMessageDto(true, 200, "Archivo subido con éxito")).build();
    }
}
