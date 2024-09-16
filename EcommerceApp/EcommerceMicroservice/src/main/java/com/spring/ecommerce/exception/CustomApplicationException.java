package com.spring.ecommerce.exception;

import com.spring.ecommerce.enums.BusinessErrorEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomApplicationException extends RuntimeException {

    private final int businessCode;
    private final String businessMessage;
    private final HttpStatus httpStatus;

    public CustomApplicationException(BusinessErrorEnum businessErrorEnum, Exception e) {
        super(e);
        this.businessCode = businessErrorEnum.getHttpStatus().value();
        this.businessMessage = businessErrorEnum.getMessage();
        this.httpStatus = businessErrorEnum.getHttpStatus();
        //logger.error(businessErrorEnum.getMessage(), e);
    }

    public CustomApplicationException(BusinessErrorEnum businessErrorEnum) {
        this.businessCode = businessErrorEnum.getHttpStatus().value();
        this.businessMessage = businessErrorEnum.getMessage();
        this.httpStatus = businessErrorEnum.getHttpStatus();
        //logger.error(businessErrorEnum.getMessage(), e);
    }
}
