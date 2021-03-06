package org.example.project.exceptions;

import jakarta.ws.rs.core.Response.Status;

import java.io.Serializable;

public class MyApplicationException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;
    private Status statusCode;

    public MyApplicationException(String message, Status statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public MyApplicationException(String message, Exception exception) {
        super(message, exception);
    }

    public Status getStatusCode() {
        return statusCode;
    }
}
