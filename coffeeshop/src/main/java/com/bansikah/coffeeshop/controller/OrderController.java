package com.bansikah.coffeeshop.controller;

import com.bansikah.coffeeshop.dto.order.CreateOrderRequest;
import com.bansikah.coffeeshop.dto.order.OrderResponse;
import com.bansikah.coffeeshop.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing orders.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    /**
     * Constructs a new OrderController with the given OrderService.
     * @param orderService The service to handle order-related business logic.
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Creates a new order.
     * @param request The request body containing the order details.
     * @return The created order as a DTO.
     */
    @PostMapping
    public OrderResponse createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }
}
