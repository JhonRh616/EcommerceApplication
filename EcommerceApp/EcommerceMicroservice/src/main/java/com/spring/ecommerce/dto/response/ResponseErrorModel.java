package com.spring.ecommerce.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Response with Error")
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorModel {

    private HeaderResponse errorHeader;
    private ErrorDetail errorDetail;
}
