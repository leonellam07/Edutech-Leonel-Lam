/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.resource;

import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.TiposCuenta;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.edutech.javaee.finaltest.bll.TiposCuentaBll;

/**
 *
 * @author leolp
 */
@Stateless
@Path("/tiposcuenta")
public class TiposCuentaEndpoint {

    @Inject
    private TiposCuentaBll tpcBll;

    @GET
    @Produces({"application/json"})
    public List<TiposCuenta> listar() {
        return this.tpcBll.obtenerLista();
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscarId(@PathParam("id") Integer id) {
        TiposCuenta tipocuenta = this.tpcBll.buscarId(id);
        if (tipocuenta == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(tipocuenta, MediaType.APPLICATION_JSON).build();
    }

}
