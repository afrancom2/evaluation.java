package com.banco.bci.evaluationjava.utils;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseEnum {
    OK(200, HttpStatus.OK, "OK"),
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "BAD REQUEST"),
    NOT_USERS_EMAIL(401, HttpStatus.BAD_REQUEST, "El correo ya esta registrado");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
