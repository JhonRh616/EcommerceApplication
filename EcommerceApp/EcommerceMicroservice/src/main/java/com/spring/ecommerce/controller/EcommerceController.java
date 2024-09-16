package com.spring.ecommerce.controller;

import com.spring.ecommerce.dto.OrdenDto;
import com.spring.ecommerce.dto.request.OrderRequestDto;
import com.spring.ecommerce.dto.response.GeneralResponse;
import com.spring.ecommerce.dto.response.HeaderResponse;
import com.spring.ecommerce.entity.Usuario;
import com.spring.ecommerce.enums.BusinessErrorEnum;
import com.spring.ecommerce.enums.ResponseEnum;
import com.spring.ecommerce.exception.CustomApplicationException;
import com.spring.ecommerce.service.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/ecommerce/")
@CrossOrigin("*")
public class EcommerceController {

    @Autowired
    private EcommerceService ecomerceService;

    @GetMapping("/hello")
    public String hello() {
        throw new CustomApplicationException(BusinessErrorEnum.GENERAL_ERROR, new Exception("Hola"));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return new ResponseEntity<>(ecomerceService.getAllUsuarios(), HttpStatus.OK);
    }

    @PostMapping("/crear-orden")
    public ResponseEntity<GeneralResponse<String>> createOrder(@RequestBody OrderRequestDto order) {
        ecomerceService.createOrder(order);

        return new ResponseEntity<>(
                new GeneralResponse<>(
                        new HeaderResponse(
                                ResponseEnum.CREATED_ORDER.getCode(),
                                ResponseEnum.CREATED_ORDER.getMessage()
                        ),
                        ResponseEnum.CREATED_ORDER.getMessage()),
                ResponseEnum.CREATED_ORDER.getHttpStatus());
    }

    @GetMapping("/listar-ordenes")
    public ResponseEntity<GeneralResponse<List<OrdenDto>>> listorders() {

        return new ResponseEntity<>(
                new GeneralResponse<>(
                        new HeaderResponse(
                                ResponseEnum.LISTED_ORDER.getCode(),
                                ResponseEnum.LISTED_ORDER.getMessage()
                        ),
                        ecomerceService.getAllOrders()),
                ResponseEnum.LISTED_ORDER.getHttpStatus());
    }

}
