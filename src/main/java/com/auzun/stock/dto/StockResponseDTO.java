package com.auzun.stock.dto;

import com.auzun.stock.domain.Stock;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
public class StockResponseDTO {
    private Long id;
    private String name;
    private BigDecimal currentPrice;
    private Instant lastUpdate;

    public StockResponseDTO() {}

    public StockResponseDTO(Stock stock) {
        this.id = stock.getId();
        this.name = stock.getName();
        this.currentPrice = stock.getCurrentPrice();
        this.lastUpdate = stock.getLastUpdate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockResponseDTO)) return false;
        StockResponseDTO that = (StockResponseDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) &&
                Objects.equals(currentPrice, that.currentPrice) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, currentPrice, lastUpdate);
    }
}
