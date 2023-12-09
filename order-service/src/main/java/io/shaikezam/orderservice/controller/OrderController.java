package io.shaikezam.orderservice.controller;

import io.shaikezam.orderservice.model.Order;
import io.shaikezam.orderservice.service.IOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private static final Logger logger = Logger.getLogger(OrderController.class.getName());

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    List<Order> getAllProducts() {
        return orderService.getAllOrders();
    }

    @PostMapping
    void createOrder(@RequestBody Order order) {
        logger.info(String.format("create order: %s", order));
        orderService.createOrder(order);
    }
}
