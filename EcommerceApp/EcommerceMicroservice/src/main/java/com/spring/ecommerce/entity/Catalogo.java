package com.spring.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "catalogo")
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo")
    private Integer idCatalogo;
    @Column(name = "nombre_catalogo")
    private String nombreCatalogo;
    @Column(name = "tipo_catalogo")
    private String tipoCatalogo;
    @Column(name = "valor_catalogo")
    private String valorCatalogo;
}
