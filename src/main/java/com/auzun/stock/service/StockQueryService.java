package com.auzun.stock.service;

import com.auzun.stock.dto.StockResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockQueryService {
    StockResponseDTO getStock(Long id);
    List<StockResponseDTO> getStocks();
    Page<StockResponseDTO> getStocks(Pageable pageable);
}
