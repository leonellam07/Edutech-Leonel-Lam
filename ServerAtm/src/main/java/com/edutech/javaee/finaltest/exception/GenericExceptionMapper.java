package com.edutech.javaee.finaltest.exception;

import com.edutech.javaee.finaltest.dto.ErrorMessageDto;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author nahum
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable exception) {
        int errorCode = 500;
        String message = exception.getMessage();
        if (exception instanceof WebApplicationException) {
            Response res = ((WebApplicationException)exception).getResponse(); 
            errorCode = res.getStatus();
        }
        
        ErrorMessageDto dto = new ErrorMessageDto(false, errorCode, message);
        return Response
                .status(errorCode)
                .entity(dto)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
}
