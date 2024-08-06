package com.enoca.ecommorce.services;

import com.enoca.ecommorce.dto.request.CreateProductRequest;
import com.enoca.ecommorce.dto.request.UpdateProductRequest;
import com.enoca.ecommorce.dto.response.GetAllProductResponse;
import com.enoca.ecommorce.dto.response.GetProductResponse;
import com.enoca.ecommorce.entities.concretes.Product;
import com.enoca.ecommorce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<GetAllProductResponse> getProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, GetAllProductResponse.class))
                .collect(Collectors.toList());
    }

    public GetProductResponse getProduct(Long id) {
        return modelMapper.map(productRepository.findById(id).orElseThrow(), GetProductResponse.class);
    }

    public void addProduct(CreateProductRequest request) {
        productRepository.save(modelMapper.map(request, Product.class));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(UpdateProductRequest request) {
        Product existingProduct = productRepository.findById(request.getId())
                .orElseThrow();
        modelMapper.map(request, existingProduct);
        productRepository.save(existingProduct);
    }
}
