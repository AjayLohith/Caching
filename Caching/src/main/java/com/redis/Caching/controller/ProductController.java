package com.redis.Caching.controller;

import com.redis.Caching.dto.ProductDto;
import com.redis.Caching.model.Product;
import com.redis.Caching.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product>createProduct(@RequestBody ProductDto request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.createProduct(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product>updateProduct(@PathVariable Long id,
                                                @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.updateProduct(id,productDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
