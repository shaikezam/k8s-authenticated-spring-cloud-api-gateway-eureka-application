package io.shaikezam.productservice.repository.impl;

import io.shaikezam.productservice.model.Product;
import io.shaikezam.productservice.repository.IProductRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAllProduct() {
        String query = "SELECT * FROM product";
        return jdbcTemplate.query(query, this::mapRowToProduct);
    }

    @Override
    public Product getProductById(Long id) {
        String query = "SELECT * FROM product WHERE id = ?";
        return jdbcTemplate.queryForObject(query, this::mapRowToProduct, id);
    }

    private Product mapRowToProduct(ResultSet rs, int rowNum) throws SQLException {
        return Product
                .builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .price(rs.getDouble("price"))
                .build();
    }
}
