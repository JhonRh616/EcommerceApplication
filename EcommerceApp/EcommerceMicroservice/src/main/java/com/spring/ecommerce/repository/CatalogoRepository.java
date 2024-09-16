package com.spring.ecommerce.repository;

import com.spring.ecommerce.entity.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {

    Catalogo findByNombreCatalogoAndTipoCatalogo(String nombre, String tipo);
}
