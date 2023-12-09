package io.shaikezam.orderservice.repository.impl;

import io.shaikezam.orderservice.model.Order;
import io.shaikezam.orderservice.repository.IOrderRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderRepository implements IOrderRepository {

    private JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createOrder(Order order) {
        String sql = "INSERT INTO orders (price) VALUES (?)";

        jdbcTemplate.update(sql, order.getPrice());
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    private static class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setPurchaseTimestamp(rs.getTimestamp("purchaseTimestamp"));
            order.setPrice(rs.getDouble("price"));
            return order;
        }
    }
}
