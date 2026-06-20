package com.redis.Caching.service;

import com.redis.Caching.dto.ProductDto;
import com.redis.Caching.model.Product;
import com.redis.Caching.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    private void simulateSlowDbCall() {
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public List<Product> getAllProducts() {
        log.info("----FETCHING ALL PRODCUTS from DB");
        simulateSlowDbCall();
        return productRepo.findAll();
    }

    @Cacheable(value = "products",key = "#id")
    public Product getProductById(Long id) {
        log.info("---- FETCHING PRODUCT:{} from DB",id);
        simulateSlowDbCall();
        return productRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Product: "+id+" not found"));
    }

    public Product createProduct(ProductDto productDto) {
        log.info("---- Creating new product: {} in DB",productDto.getName());
        Product product=Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .category(productDto.getCategory())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .build();
        return productRepo.save(product);
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        log.info("---- Updating product {} in DB",id);
        Product existing=getProductById(id);
        existing.setName(productDto.getName());
        existing.setDescription(productDto.getDescription());
        existing.setCategory(productDto.getCategory());
        existing.setPrice(productDto.getPrice());
        existing.setStock(productDto.getStock());
        return productRepo.save(existing);
    }

    public void deleteProductById(Long id) {
        log.info("---- DELETING product {} in DB",id);
        productRepo.deleteById(id);
    }


}
