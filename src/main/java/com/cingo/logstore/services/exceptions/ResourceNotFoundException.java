package com.cingo.logstore.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ResourceNotFoundException(Object message) {
        super("Error =  " + message);
    }

}
