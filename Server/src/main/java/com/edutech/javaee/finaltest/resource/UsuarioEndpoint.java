package com.edutech.javaee.finaltest.resource;

import com.edutech.javaee.finaltest.dao.RolDaoImp;
import com.edutech.javaee.finaltest.dao.UsuarioDaoImp;
import com.edutech.javaee.finaltest.model.Usuario;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    UsuarioDaoImp usuarioDao;
    @Inject
    RolDaoImp rolDao;

    private static final String FILE_PATH = "c:\\home\\upload\\";

    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) throws IOException {
        OutputStream out;
        int read;
        byte[] bytes = new byte[1024];
        out = new FileOutputStream(new File(uploadedFileLocation));
        while ((read = uploadedInputStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    }

    @GET
    @Produces({"application/json"})
    public List<Usuario> findAll() {
        List<Usuario> usuarios = this.usuarioDao.findAll();
        System.out.println(usuarios);
        return usuarios;
    }

    @GET
    @Path("{user}")
    @Produces({"application/json"})
    public Response findById(@PathParam("user") String user) {
        Usuario usuario = this.usuarioDao.find(user);
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
    public Response create(Usuario entity) {
        Usuario usuario = new Usuario(
                entity.getCodigo(),
                entity.getEmail(),
                entity.getNombre(),
                entity.getTelefono(),
                this.rolDao.find(entity.getRol().getId())
        );
        this.usuarioDao.save(usuario);
        return Response.ok(usuario).build();
    }

    @PUT
    @Produces({"application/json"})
    public Response update(Usuario entity) throws RollbackException {
        Usuario usuario = this.usuarioDao.edit(entity);
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
    public Response delete(@PathParam("id") String user) {
        Usuario usuario = this.usuarioDao.remove(user);

        if (usuario == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessageDto(false, 404, "Recurso no encontrado"))
                    .build();
        }

        return Response.ok(usuario).build();
    }

}
