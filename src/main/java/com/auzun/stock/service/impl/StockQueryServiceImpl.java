package com.auzun.stock.service.impl;

import com.auzun.stock.api.exception.StockNotFoundException;
import com.auzun.stock.dto.StockResponseDTO;
import com.auzun.stock.repository.StockRepository;
import com.auzun.stock.service.StockQueryService;
import com.auzun.stock.domain.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class StockQueryServiceImpl implements StockQueryService {

    private final StockRepository repository;

    public StockQueryServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public StockResponseDTO getStock(Long id) {
        Optional<Stock> stock = repository.findById(id);
        if (stock.isEmpty()) {
            throw new StockNotFoundException(id);
        }

        return new StockResponseDTO(stock.get());
    }

    @Override
    public List<StockResponseDTO> getStocks() {
        Iterable<Stock> stocks = repository.findAll();

        List<StockResponseDTO> returnList = new ArrayList<>();
        stocks.forEach(e -> returnList.add(new StockResponseDTO(e)));

        return returnList;
    }

    @Override
    public Page<StockResponseDTO> getStocks(Pageable pageable) {
        Page<Stock> entityResult = repository.findAll(pageable);
        return entityResult.map(StockResponseDTO::new);
    }
}
