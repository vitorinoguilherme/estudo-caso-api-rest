package org.example.project.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MyApplicationExceptionHandler implements ExceptionMapper<MyApplicationException> {

    @Override
    public Response toResponse(MyApplicationException exception) {
        return Response.status(exception.getStatusCode()).entity(exception.getMessage()).build();
    }


}
