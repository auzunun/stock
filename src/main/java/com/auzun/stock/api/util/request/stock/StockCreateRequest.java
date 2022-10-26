package com.auzun.stock.api.util.request.stock;

import com.auzun.stock.dto.StockDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
@ApiModel
public class StockCreateRequest {

    @Valid
    private StockDTO stockDTO;
}
