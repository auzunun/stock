package com.auzun.stock.controller;

import com.auzun.stock.TestDataFactory;
import com.auzun.stock.api.util.request.stock.StockCreateRequest;
import com.auzun.stock.api.util.request.stock.StockUpdatePriceRequest;
import com.auzun.stock.dto.StockResponseDTO;
import com.auzun.stock.service.StockCommandService;
import com.auzun.stock.service.StockQueryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StockApiControllerTest {

    @Mock
    private StockCommandService stockCommandService;
    @Mock
    private StockQueryService stockQueryService;
    @InjectMocks
    private StockApiController stockApiController;

    @Test
    public void getListOfStocksTest() {
        List<StockResponseDTO> stockResponseList = new ArrayList<>();
        stockResponseList.add(TestDataFactory.stockResponseDTO());
        Mockito.when(stockQueryService.getStocks()).thenReturn(stockResponseList);
        int count = stockApiController.getListOfStocks().getResultList().size();
        Assertions.assertEquals(1, count);
    }

    @Test
    public void saveStockTest() {
        StockCreateRequest request = TestDataFactory.stockCreateRequest();
        Mockito.when(stockCommandService.saveStock(request.getStockDTO())).thenReturn(1L);
        long savedId = stockApiController.createStock(request);
        Assertions.assertEquals(1, savedId);
    }

    @Test
    public void getStockByIdTest() {
        StockResponseDTO responseDTO = TestDataFactory.stockResponseDTO();
        Mockito.when(stockQueryService.getStock(Mockito.anyLong())).thenReturn(responseDTO);
        Assertions.assertEquals(responseDTO, stockApiController.getStock(1L).getResult());
    }

    @Test
    public void updateStockPriceTest() {
        Mockito.when(stockCommandService.updateStockPrice(Mockito.anyLong(), Mockito.any(BigDecimal.class)))
                .thenReturn(1L);
        StockUpdatePriceRequest request = TestDataFactory.stockUpdatePriceRequest();
        long updatedId = stockApiController.updateStockPrice(1L, request);
        Assertions.assertEquals(1, updatedId);
    }

    @Test
    public void deleteStockTest() {
        Mockito.when(stockCommandService.deleteStock(Mockito.anyLong())).thenReturn(1L);
        long deletedId = stockCommandService.deleteStock(1L);
        Assertions.assertEquals(1, deletedId);
    }

    @Test
    public void getListOfStocksPageableTest() {
        Page<StockResponseDTO> resultPage = Mockito.mock(Page.class);
        Mockito.when(stockQueryService.getStocks(Mockito.any(Pageable.class))).thenReturn(resultPage);
        stockApiController.getListOfStocksPageable(PageRequest.of(1,10));
    }
}
