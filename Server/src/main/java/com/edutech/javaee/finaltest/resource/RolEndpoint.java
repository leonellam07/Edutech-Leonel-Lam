package com.edutech.javaee.finaltest.resource;

import com.edutech.javaee.finaltest.dao.RolDaoImp;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.Rol;
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

/**
 *
 * @author nahum
 */
@Stateless
@Path("/roles")
public class RolEndpoint {

    @Inject
    RolDaoImp dao;

    @GET
    @Produces({"application/json"})
    public List<Rol> findAll() {
        return this.dao.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response findById(@PathParam("id") Integer id) {
        Rol rol = this.dao.find(id);
        if (rol == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(rol, MediaType.APPLICATION_JSON).build();
    }

}
