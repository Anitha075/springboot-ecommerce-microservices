package com.app.ecom.service;


import com.app.ecom.Repository.ProductRepository;
import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public ProductResponse createProduct(ProductRequest productRequest) {

return " ";

    }
}
