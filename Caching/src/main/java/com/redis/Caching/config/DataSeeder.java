package com.redis.Caching.config;

import com.redis.Caching.model.Product;
import com.redis.Caching.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final ProductRepo productRepository;

    @Override
    public void run(String... args) {

        if (productRepository.count() == 0) {

            log.info("Seeding product data...");

            productRepository.saveAll(List.of(

                    Product.builder()
                            .name("MacBook Pro 14")
                            .description("Apple M4 Pro Laptop")
                            .price(new BigDecimal("199999"))
                            .stock(20)
                            .category("Laptop")
                            .build(),

                    Product.builder()
                            .name("Dell XPS 15")
                            .description("Intel Core Ultra Laptop")
                            .price(new BigDecimal("149999"))
                            .stock(15)
                            .category("Laptop")
                            .build(),

                    Product.builder()
                            .name("iPhone 16")
                            .description("Apple Flagship Smartphone")
                            .price(new BigDecimal("89999"))
                            .stock(30)
                            .category("Mobile")
                            .build(),

                    Product.builder()
                            .name("Samsung Galaxy S26")
                            .description("Premium Android Smartphone")
                            .price(new BigDecimal("79999"))
                            .stock(25)
                            .category("Mobile")
                            .build(),

                    Product.builder()
                            .name("iPad Air")
                            .description("Apple Tablet with M3 Chip")
                            .price(new BigDecimal("64999"))
                            .stock(18)
                            .category("Tablet")
                            .build(),

                    Product.builder()
                            .name("Sony WH-1000XM6")
                            .description("Noise Cancelling Wireless Headphones")
                            .price(new BigDecimal("29999"))
                            .stock(40)
                            .category("Accessories")
                            .build(),

                    Product.builder()
                            .name("Apple Watch Series 12")
                            .description("Smartwatch with Health Tracking")
                            .price(new BigDecimal("45999"))
                            .stock(22)
                            .category("Wearables")
                            .build(),

                    Product.builder()
                            .name("Logitech MX Master 4")
                            .description("Wireless Productivity Mouse")
                            .price(new BigDecimal("9999"))
                            .stock(50)
                            .category("Accessories")
                            .build(),

                    Product.builder()
                            .name("Samsung 32-inch 4K Monitor")
                            .description("UHD Monitor for Work and Gaming")
                            .price(new BigDecimal("34999"))
                            .stock(12)
                            .category("Monitors")
                            .build(),

                    Product.builder()
                            .name("ASUS ROG Strix G18")
                            .description("High Performance Gaming Laptop")
                            .price(new BigDecimal("189999"))
                            .stock(10)
                            .category("Laptop")
                            .build()

            ));

            log.info("Products seeded successfully");
        }
    }
}