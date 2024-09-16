package com.spring.ecommerce.util;

import com.spring.ecommerce.dto.response.ErrorDetail;
import com.spring.ecommerce.dto.response.GeneralResponse;
import com.spring.ecommerce.dto.response.HeaderResponse;
import com.spring.ecommerce.dto.response.ResponseErrorModel;
import com.spring.ecommerce.enums.BusinessErrorEnum;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Builder
public class ResponseBuilder {

    private ResponseBuilder() {}

    public static <T> ResponseEntity<GeneralResponse<T>> buildResponseOk(T entity) {
        HeaderResponse headerResponse = new HeaderResponse(HttpStatus.OK.value(), "Petición ejecutada correctamente");
        return ResponseEntity.ok(new GeneralResponse<>(headerResponse, entity));
    }


    public static <T> ResponseEntity<GeneralResponse<T>> buildResponseOk(T entity, BusinessErrorEnum businessError) {
        return new ResponseEntity<>(
                new GeneralResponse<>(getHeader(businessError), entity),
                businessError.getHttpStatus()
        );
    }

    public static ResponseEntity<ResponseErrorModel> buildErrorResponse(int returnCode,
                                                                        String message,
                                                                        String detailMessage,
                                                                        Exception e,
                                                                        HttpStatus httpStatus) {
        return new ResponseEntity<>(
                new ResponseErrorModel(
                        new HeaderResponse(returnCode, message),
                        new ErrorDetail(detailMessage, e.getLocalizedMessage(), new Date())
                ),
                httpStatus
        );
    }

    private static HeaderResponse getHeader(BusinessErrorEnum businessError) {
        return new HeaderResponse(businessError.getHttpStatus().value(), businessError.getMessage());
    }
}
