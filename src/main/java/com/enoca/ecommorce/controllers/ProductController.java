package com.enoca.ecommorce.controllers;

import com.enoca.ecommorce.dto.request.CreateProductRequest;
import com.enoca.ecommorce.dto.request.UpdateProductRequest;
import com.enoca.ecommorce.dto.response.GetAllProductResponse;
import com.enoca.ecommorce.dto.response.GetProductResponse;
import com.enoca.ecommorce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<GetAllProductResponse> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public GetProductResponse getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping()
    public void addProduct(@RequestBody CreateProductRequest request) {
        productService.addProduct(request);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping
    public void updateProduct(@RequestBody UpdateProductRequest request) {
        productService.updateProduct(request);
    }
}

