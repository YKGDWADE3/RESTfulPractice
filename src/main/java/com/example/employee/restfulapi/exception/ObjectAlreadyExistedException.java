package com.example.employee.restfulapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ObjectAlreadyExistedException extends RuntimeException {

    public ObjectAlreadyExistedException(long Id) {
        super("object with id '" + Id + "' already exists.");
    }
}