package com.spring.ecommerce.controller.advice;

import com.spring.ecommerce.dto.response.ResponseErrorModel;
import com.spring.ecommerce.exception.CustomApplicationException;
import com.spring.ecommerce.util.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EcommerceAppControllerAdvice {

    @ExceptionHandler(CustomApplicationException.class)
    public @ResponseBody ResponseEntity<ResponseErrorModel> handleCustomApplicationException(CustomApplicationException e) {
        return ResponseBuilder.buildErrorResponse(
                e.getHttpStatus().value(),
                e.getHttpStatus().getReasonPhrase(),
                e.getBusinessMessage(),
                e,
                e.getHttpStatus()
        );
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody ResponseEntity<ResponseErrorModel> handleException(Exception e) {
        return ResponseBuilder.buildErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage(),
                e,
                HttpStatus.CONFLICT
        );
    }
}
