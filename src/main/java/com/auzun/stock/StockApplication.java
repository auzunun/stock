package com.auzun.stock;

import com.auzun.stock.config.StockAppConfig;
import com.auzun.stock.config.SwaggerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
@Import({StockAppConfig.class, SwaggerConfig.class})
@EnableJpaRepositories("com.auzun.stock.repository")
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }
}
