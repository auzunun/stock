package com.auzun.stock.repository;

import com.auzun.stock.domain.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface StockRepository extends PagingAndSortingRepository<Stock, Long> {
}
