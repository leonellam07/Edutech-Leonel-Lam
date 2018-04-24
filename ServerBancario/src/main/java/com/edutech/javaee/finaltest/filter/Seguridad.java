/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edutech.javaee.finaltest.filter;

import com.edutech.javaee.finaltest.bll.AsignacionRolBll;
import com.edutech.javaee.finaltest.bll.UsuarioBll;
import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import com.edutech.javaee.finaltest.model.AsignacionRol;
import com.edutech.javaee.finaltest.model.Usuario;
import com.edutech.javaee.finaltest.operations.jwtToken;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author leolp
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class Seguridad implements ContainerRequestFilter, ContainerResponseFilter {

    @Context
    private UriInfo uriInfo;
    @Inject
    private UsuarioBll userBll;
    @Inject
    private jwtToken tokenDesencrypt;
    @Inject
    private AsignacionRolBll asigRolBll;

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {

        if(requestContext.getHeaders().isEmpty()){
            errorAutenticacion(requestContext);
        }
        
        boolean isPublicRequest = false;
        boolean debug = false;

        String[] publicPaths = new String[]{
            "usuarios/login",
            "departamentos",
            "tarjeta"
        };

        for (String path : publicPaths) {
            if (uriInfo.getAbsolutePath().toString().contains(path)) {
                isPublicRequest = true;
                break;
            }
        }

        if (isPublicRequest || debug) {
            return;
        }

        String token = requestContext.getHeaderString("Authorization");

        String codigo = this.tokenDesencrypt.decoded(token);
        if (codigo != null) {
            final Usuario usuario = userBll.buscarCodigo(codigo);
            if (usuario != null) {

                final List<AsignacionRol> roles = this.asigRolBll.listaRolesXUsuario(usuario.getId());

                final SecurityContext securityContext = requestContext.getSecurityContext();
                requestContext.setSecurityContext(new SecurityContext() {
                    @Override
                    public Principal getUserPrincipal() {
                        return usuario::getNombre;
                    }

                    @Override
                    public boolean isUserInRole(String role) {
                        boolean rol_existe = false;
                        for (AsignacionRol rol : roles) {
                            if (rol.getRol().getNombre().equals(role)) {
                                rol_existe = true;
                                break;
                            }
                        }
                        return rol_existe;
                    }

                    @Override
                    public boolean isSecure() {
                        return uriInfo.getAbsolutePath().toString().startsWith("https");
                    }

                    @Override
                    public String getAuthenticationScheme() {
                        return "Token-Based-Auth-Scheme";
                    }
                });
                return;
            }
        }

        errorAutenticacion(requestContext);
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

    }

    private void errorAutenticacion(ContainerRequestContext requestContext) {
        requestContext.abortWith(
                Response
                        .status(401)
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .entity(new ErrorMessageDto(
                                false,
                                401,
                                "No tiene autorizacion para realizar la peticion",
                                requestContext.getUriInfo().getPath()
                        ))
                        .build());
    }

}
