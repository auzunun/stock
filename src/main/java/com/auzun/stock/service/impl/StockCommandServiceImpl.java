package com.auzun.stock.service.impl;

import com.auzun.stock.api.exception.StockNotFoundException;
import com.auzun.stock.dto.StockDTO;
import com.auzun.stock.repository.StockRepository;
import com.auzun.stock.service.StockCommandService;
import com.auzun.stock.domain.Stock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class StockCommandServiceImpl implements StockCommandService {

    private final StockRepository repository;

    public StockCommandServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long saveStock(StockDTO dto) {
        Stock stock = new Stock();
        stock.setName(dto.getName());
        stock.setCurrentPrice(dto.getCurrentPrice());
        stock.setLastUpdate(Instant.now());
        stock.setDeleted(false);

        return repository.save(stock).getId();
    }

    @Override
    public Long updateStockPrice(Long id, BigDecimal price) {
        Optional<Stock> currentStock = repository.findById(id);
        if (currentStock.isEmpty()) {
            throw new StockNotFoundException(id);
        }

        Stock stock = currentStock.get();
        stock.setCurrentPrice(price);
        stock.setLastUpdate(Instant.now());

        return repository.save(stock).getId();
    }

    @Override
    public Long deleteStock(Long id) {
        Optional<Stock> currentStock = repository.findById(id);
        if (currentStock.isEmpty()) {
            throw new StockNotFoundException(id);
        }

        Stock stock = currentStock.get();
        stock.setDeleted(true);

        return repository.save(stock).getId();
    }
}
