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
@Table(name = "transacciones")
public class Transacciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Integer idTransaccion;
    @Column(name = "fecha_transaccion")
    private Timestamp fechaTransaccion;
    @Column(name = "tipo_transaccion")
    private Integer tipoTransaccion;
    @Column(name = "id_orden")
    private Integer idOrden;

}
