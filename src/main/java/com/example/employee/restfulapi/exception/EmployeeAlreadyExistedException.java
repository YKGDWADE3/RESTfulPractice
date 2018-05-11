package com.example.employee.restfulapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeAlreadyExistedException extends RuntimeException {

    public EmployeeAlreadyExistedException(long employeeId) {
        super("employee with id '" + employeeId + "' already exists.");
    }
}