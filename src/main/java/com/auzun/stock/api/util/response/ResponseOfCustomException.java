package com.auzun.stock.api.util.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class ResponseOfCustomException {
    private String message;
    private String code;

    public ResponseOfCustomException(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
