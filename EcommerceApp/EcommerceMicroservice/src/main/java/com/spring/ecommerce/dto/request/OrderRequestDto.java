package com.spring.ecommerce.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {

    private Integer idUsuario;
    private Integer idProducto;
    private String comentarios;
}
