package com.auzun.stock.service;

import com.auzun.stock.dto.StockDTO;

import java.math.BigDecimal;

public interface StockCommandService {
    Long saveStock(StockDTO dto);
    Long updateStockPrice(Long id, BigDecimal price);
    Long deleteStock(Long id);
}
