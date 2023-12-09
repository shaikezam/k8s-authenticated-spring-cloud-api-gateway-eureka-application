package io.shaikezam.orderservice.service.impl;

import io.shaikezam.orderservice.model.Order;
import io.shaikezam.orderservice.repository.IOrderRepository;
import io.shaikezam.orderservice.service.IOrderService;
import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Order order) {
        Validate.notNull(order);

        orderRepository.createOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
