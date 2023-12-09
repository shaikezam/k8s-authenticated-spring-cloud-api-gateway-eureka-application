package io.shaikezam.productservice.service.impl;

import io.shaikezam.productservice.model.Product;
import io.shaikezam.productservice.repository.IProductRepository;
import io.shaikezam.productservice.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProduct();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return Optional.empty();
    }
}
