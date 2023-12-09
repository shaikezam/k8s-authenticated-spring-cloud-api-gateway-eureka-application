package io.shaikezam.productservice.service;

import io.shaikezam.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProducts();

    Optional<Product> getProduct(Long id);
}
