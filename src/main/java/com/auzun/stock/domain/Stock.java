package com.auzun.stock.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Entity
@Getter
@Setter
@Where(clause = "deleted = false")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @Size(max = 150)
    private String name;
    @Column(name = "currentPrice")
    @Digits(integer = 14, fraction = 2)
    private BigDecimal currentPrice;
    @Column(name = "lastUpdate")
    private Instant lastUpdate;
    @Column(name = "deleted")
    private Boolean deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) && Objects.equals(name, stock.name) &&
                Objects.equals(currentPrice, stock.currentPrice) && Objects.equals(lastUpdate, stock.lastUpdate) &&
                Objects.equals(deleted, stock.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, currentPrice, lastUpdate, deleted);
    }
}
