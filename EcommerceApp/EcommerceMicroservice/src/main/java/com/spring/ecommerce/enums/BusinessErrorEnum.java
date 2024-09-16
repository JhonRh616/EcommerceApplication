package com.spring.ecommerce.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum BusinessErrorEnum {

    GENERAL_ERROR("Fallo general en la petición", HttpStatus.CONFLICT),
    SIN_STOCK("No es posible realizar la compra, no hay productos disponibles", HttpStatus.CONFLICT);

    private final String message;
    private final HttpStatus httpStatus;
}
