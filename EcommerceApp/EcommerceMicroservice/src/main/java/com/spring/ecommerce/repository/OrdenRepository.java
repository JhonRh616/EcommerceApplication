package com.spring.ecommerce.repository;

import com.spring.ecommerce.dto.OrdenDto;
import com.spring.ecommerce.entity.Orden;
import com.spring.ecommerce.projection.OrdenProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {

    @Query(value = "SELECT o.id_orden AS idOrden, CONCAT(u.nombre_usuario, ' ', u.apellido_usuario) AS nombreUsuario, " +
            "p.nombre_producto AS nombreProducto, p.valor_producto AS valorProducto, o.comentarios_orden AS comentariosOrden " +
            "FROM orden o " +
            "INNER JOIN usuario u ON u.id_usuario = o.id_usuario " +
            "INNER JOIN producto p ON p.id_producto = o.id_producto", nativeQuery = true)
    List<OrdenProjection> getAllOrdenes();

}
