package com.auzun.stock.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class StockDTO {
    @NotEmpty
    @Size(max = 150, message = "name can not be emtpy")
    private String name;
    @Digits(integer = 14, fraction = 2, message = "Allowed integer 14 and fraction is 2")
    @ApiModelProperty(example = "10.15")
    private BigDecimal currentPrice;
    @ApiModelProperty(example = "12.11.2022")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateTest;
}
