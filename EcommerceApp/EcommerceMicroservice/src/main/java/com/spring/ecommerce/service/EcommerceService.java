package com.spring.ecommerce.service;

import com.spring.ecommerce.dto.OrdenDto;
import com.spring.ecommerce.dto.request.OrderRequestDto;
import com.spring.ecommerce.entity.Usuario;

import java.util.List;

public interface EcommerceService {

    List<Usuario> getAllUsuarios();
    void createOrder(OrderRequestDto order);
    List<OrdenDto> getAllOrders();
}
