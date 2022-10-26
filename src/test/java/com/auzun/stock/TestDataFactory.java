package com.auzun.stock;

import com.auzun.stock.api.util.request.stock.StockCreateRequest;
import com.auzun.stock.api.util.request.stock.StockUpdatePriceRequest;
import com.auzun.stock.domain.Stock;
import com.auzun.stock.dto.StockDTO;
import com.auzun.stock.dto.StockResponseDTO;

import java.math.BigDecimal;
import java.time.Instant;

public class TestDataFactory {

    public static Stock stock() {
        Stock stock = new Stock();
        stock.setId(1L);
        stock.setName("Pen");
        stock.setCurrentPrice(new BigDecimal(10));
        stock.setDeleted(false);
        return stock;
    }

    public static StockDTO stockDTO() {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setName("Pen");
        stockDTO.setCurrentPrice(new BigDecimal(10));
        return stockDTO;
    }

    public static StockResponseDTO stockResponseDTO() {
        StockResponseDTO responseDTO = new StockResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setName("Pen");
        responseDTO.setCurrentPrice(new BigDecimal(10));
        responseDTO.setLastUpdate(Instant.now());
        return responseDTO;
    }

    public static StockCreateRequest stockCreateRequest() {
        StockCreateRequest request = new StockCreateRequest();
        request.setStockDTO(stockDTO());
        return request;
    }

    public static StockUpdatePriceRequest stockUpdatePriceRequest() {
        StockUpdatePriceRequest updatePriceRequest = new StockUpdatePriceRequest();
        updatePriceRequest.setPrice(new BigDecimal(10));
        return updatePriceRequest;
    }
}
