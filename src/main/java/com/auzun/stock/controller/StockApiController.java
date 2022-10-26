package com.auzun.stock.controller;

import com.auzun.stock.api.constants.ApiEndpoints;
import com.auzun.stock.api.constants.ApiGroups;
import com.auzun.stock.api.exception.StockNotFoundException;
import com.auzun.stock.api.util.request.stock.StockCreateRequest;
import com.auzun.stock.dto.StockResponseDTO;
import com.auzun.stock.service.StockCommandService;
import com.auzun.stock.service.StockQueryService;
import com.auzun.stock.api.util.request.stock.StockUpdatePriceRequest;
import com.auzun.stock.api.util.response.ResponseOfCustomException;
import com.auzun.stock.api.util.response.ResponseOfGet;
import com.auzun.stock.api.util.response.ResponseOfGetList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(value = ApiGroups.StockApi.NAME)
@RequestMapping(value = ApiEndpoints.API_BASE_URL, produces = ApiEndpoints.RESPONSE_CONTENT_TYPE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class StockApiController {

    private final StockCommandService stockCommandService;
    private final StockQueryService stockQueryService;

    public StockApiController(StockCommandService stockCommandService,
                              StockQueryService stockQueryService) {
        this.stockCommandService = stockCommandService;
        this.stockQueryService = stockQueryService;
    }

    @GetMapping(value = "/stocks/all", consumes = MediaType.ALL_VALUE)
    @ApiOperation(value = "Get All Stocks", notes = "Get a List of Stocks")
    public ResponseOfGetList<StockResponseDTO> getListOfStocks() {
        return new ResponseOfGetList<>(stockQueryService.getStocks());
    }

    @GetMapping(value = "/stocks", consumes = MediaType.ALL_VALUE)
    @ApiOperation(value = "Get Stocks with Pagination", notes = "Get List of Stocks with Pagination")
    public Page<StockResponseDTO> getListOfStocksPageable(Pageable pageable) {
        return stockQueryService.getStocks(pageable);
    }

    @PostMapping(value = "/stocks", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Stock", notes = "Create Stock")
    public Long createStock(@Valid @RequestBody StockCreateRequest request) {
        return stockCommandService.saveStock(request.getStockDTO());
    }

    @GetMapping(value = "/stocks/{id}", consumes = MediaType.ALL_VALUE)
    @ApiOperation(value = "Get Stock", notes = "Get Stock using Id")
    public ResponseOfGet<StockResponseDTO> getStock(@PathVariable(name = "id") Long id) {
        return new ResponseOfGet<>(stockQueryService.getStock(id));
    }

    @PatchMapping(value = "/stocks/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Stock Price", notes = "Update Stock Price")
    public Long updateStockPrice(@PathVariable(name = "id") Long id,
                                 @Valid @RequestBody StockUpdatePriceRequest request) {
        return stockCommandService.updateStockPrice(id, request.getPrice());
    }

    @DeleteMapping(value = "/stocks/{id}", consumes = MediaType.ALL_VALUE)
    @ApiOperation(value = "Delete Stock", notes = "Delete Stock using Id")
    public Long deleteStock(@PathVariable(name = "id") Long id) {
        return stockCommandService.deleteStock(id);
    }

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseOfCustomException handleStockNotFound(StockNotFoundException e) {
        return new ResponseOfCustomException(e.getMessage(), "404");
    }
}
