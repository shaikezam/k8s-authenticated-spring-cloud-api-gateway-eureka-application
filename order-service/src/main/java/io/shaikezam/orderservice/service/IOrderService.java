package io.shaikezam.orderservice.service;

import io.shaikezam.orderservice.model.Order;

import java.util.List;

public interface IOrderService {
    void createOrder(Order order);
    List<Order> getAllOrders();
}
