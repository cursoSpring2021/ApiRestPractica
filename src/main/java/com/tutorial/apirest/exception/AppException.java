package com.tutorial.apirest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class AppException extends RuntimeException {
    private final HttpStatus status;

    public AppException(String mensaje, HttpStatus status) {
        super(mensaje);
        this.status = status;
    }

}
