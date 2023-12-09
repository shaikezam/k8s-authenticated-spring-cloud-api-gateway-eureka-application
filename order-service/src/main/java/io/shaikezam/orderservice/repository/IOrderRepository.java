package io.shaikezam.orderservice.repository;

import io.shaikezam.orderservice.model.Order;

import java.util.List;

public interface IOrderRepository {
    void createOrder(Order order);
    List<Order> getAllOrders();
}
