package io.shaikezam.productservice.repository;

import io.shaikezam.productservice.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();
    Product getProductById(Long id);
}
