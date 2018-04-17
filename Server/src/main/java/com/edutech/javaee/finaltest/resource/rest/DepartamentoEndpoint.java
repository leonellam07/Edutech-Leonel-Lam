package com.edutech.javaee.finaltest.resource.rest;

import com.edutech.javaee.finaltest.model.Departamento;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.bll.DepartamentoBll;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author nahum
 */
@Stateless
@Path("/departamentos")
public class DepartamentoEndpoint {

    @Inject
    private DepartamentoBll deptoBll;

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response buscarId(@PathParam("id") Integer id) {
        Departamento departamento = this.deptoBll.buscarId(id);
        if (departamento == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(departamento).build();
    }

    @GET
    @Produces({"application/json"})
    public List<Departamento> lista() {
        return this.deptoBll.obtenerLista();
    }

}
