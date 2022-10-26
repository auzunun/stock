package com.auzun.stock.api.util.request.stock;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@ApiModel
public class StockUpdatePriceRequest {
    @NotNull
    @Digits(integer = 14, fraction = 2, message = "Allowed integer 14 and fraction is 2")
    private BigDecimal price;
}
