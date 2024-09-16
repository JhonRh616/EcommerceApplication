package com.spring.ecommerce.repository;

import com.spring.ecommerce.entity.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesRepository extends JpaRepository<Transacciones, Integer> {
}
