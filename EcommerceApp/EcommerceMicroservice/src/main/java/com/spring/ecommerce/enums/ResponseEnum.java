package com.spring.ecommerce.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseEnum {

    CREATED_ORDER(0,"Orden creada con éxito", HttpStatus.CREATED),
    LISTED_ORDER(0,"Ordenes listadas con éxito", HttpStatus.OK);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;
}
