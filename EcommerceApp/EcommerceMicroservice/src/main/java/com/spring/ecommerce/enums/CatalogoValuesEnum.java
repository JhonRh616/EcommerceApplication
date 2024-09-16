package com.spring.ecommerce.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CatalogoValuesEnum {

    TRANSACTION_CREATED("ESTADO_TRANSACCION", "TRANSACCION_CREADA");

    private final String tipo;
    private final String nombre;
}
