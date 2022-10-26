package com.auzun.stock.service;

import com.auzun.stock.TestDataFactory;
import com.auzun.stock.domain.Stock;
import com.auzun.stock.dto.StockResponseDTO;
import com.auzun.stock.repository.StockRepository;
import com.auzun.stock.service.impl.StockQueryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StockQueryServiceImplTest {

    @Mock
    private StockRepository repository;
    @InjectMocks
    private StockQueryServiceImpl queryService;

    @Test
    public void getStockTest() {
        Optional<Stock> stock = Optional.of(TestDataFactory.stock());
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(stock);
        Assertions.assertEquals(stock.get().getId(), queryService.getStock(1L).getId());
    }

    @Test
    public void getStocksTest() {
        Mockito.when(queryService.getStocks()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(0, queryService.getStocks().size());
    }

    @Test
    public void getStocksPageable() {
        List<Stock> stockList = List.of(TestDataFactory.stock());
        Page<Stock> stockPage = new PageImpl<>(stockList);
        Mockito.when(repository.findAll(Mockito.any(Pageable.class))).thenReturn(stockPage);
        Page<StockResponseDTO> stockResponsePage = queryService.getStocks(PageRequest.of(1,10));
        Assertions.assertEquals(stockPage.getTotalElements(), stockResponsePage.getTotalElements());
    }
}
