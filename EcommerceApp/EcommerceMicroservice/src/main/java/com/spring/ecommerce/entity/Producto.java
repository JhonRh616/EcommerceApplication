package com.spring.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "valor_producto")
    private Integer valorProducto;
    @Column(name = "cantidad_disponible")
    private Integer cantidadDisponible;
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    @Column(name = "id_tipo_producto")
    private Integer idTipoProducto;
}
