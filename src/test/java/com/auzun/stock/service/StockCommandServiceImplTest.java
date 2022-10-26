package com.auzun.stock.service;

import com.auzun.stock.TestDataFactory;
import com.auzun.stock.domain.Stock;
import com.auzun.stock.repository.StockRepository;
import com.auzun.stock.service.impl.StockCommandServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StockCommandServiceImplTest {

    @Mock
    private StockRepository repository;
    @InjectMocks
    private StockCommandServiceImpl commandService;

    @Test
    public void saveStockTest() {
        Stock stock = TestDataFactory.stock();
        Mockito.when(repository.save(Mockito.any(Stock.class))).thenReturn(stock);
        Assertions.assertEquals(stock.getId(), commandService.saveStock(TestDataFactory.stockDTO()));
    }

    @Test
    public void updateStockPriceTest() {
        Stock stock = TestDataFactory.stock();
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Mockito.when(repository.save(Mockito.any(Stock.class))).thenReturn(stock);
        BigDecimal updatePrice = new BigDecimal(15);
        commandService.updateStockPrice(stock.getId(), updatePrice);
        Assertions.assertEquals(updatePrice, stock.getCurrentPrice());
    }

    @Test
    public void deleteStockTest() {
        Stock stock = TestDataFactory.stock();
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Mockito.when(repository.save(Mockito.any(Stock.class))).thenReturn(stock);
        commandService.deleteStock(1L);
        Assertions.assertTrue(stock.getDeleted());
    }
}
