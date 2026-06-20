package com.redis.Caching;

import com.redis.Caching.model.Product;
import com.redis.Caching.repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CachingApplicationTests {

	@Test
	void contextLoads() {
	}

    @Autowired
    ProductRepo productRepo;
    @Test
    void testSaveProduct(){
        Product product=Product.builder()
                .id(1L)
                .name("Apple")
                .category("Elect")
                .price(BigDecimal.valueOf(2.154))
                .stock(2)
                .build();
        productRepo.save(product);
        System.out.println("----Passed----");
    }

}
