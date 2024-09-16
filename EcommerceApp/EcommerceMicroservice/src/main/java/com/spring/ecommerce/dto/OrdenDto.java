package com.spring.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrdenDto {

    private Integer idOrden;
    private String nombreUsuario;
    private String nombreProducto;
    private Double valorProducto;
    private String comentariosOrden;

}
