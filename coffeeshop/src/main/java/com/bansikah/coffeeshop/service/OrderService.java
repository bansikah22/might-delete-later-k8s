package com.bansikah.coffeeshop.service;

import com.bansikah.coffeeshop.domain.Coffee;
import com.bansikah.coffeeshop.domain.Order;
import com.bansikah.coffeeshop.domain.OrderItem;
import com.bansikah.coffeeshop.dto.order.*;
import com.bansikah.coffeeshop.repository.CoffeeRepository;
import com.bansikah.coffeeshop.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing orders.
 */
@Service
public class OrderService {

    private final CoffeeRepository coffeeRepository;
    private final OrderRepository orderRepository;

    /**
     * Constructs a new OrderService with the given repositories.
     * @param coffeeRepository The repository for coffee data access.
     * @param orderRepository The repository for order data access.
     */
    public OrderService(CoffeeRepository coffeeRepository,
                        OrderRepository orderRepository) {
        this.coffeeRepository = coffeeRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * Creates a new order from a request DTO.
     * This method is transactional, so all database operations are performed in a single transaction.
     * @param request The request DTO containing the order details.
     * @return The created order as a response DTO.
     * @throws RuntimeException if a coffee in the order is not found.
     */
    @Transactional
    public OrderResponse createOrder(CreateOrderRequest request) {

        // Create Order Entity
        Order order = new Order();

        // Loop Through Request Items
        for (OrderItemRequest itemRequest : request.items()) {

            // Fetch Coffee From DB
            Coffee coffee = coffeeRepository.findById(itemRequest.coffeeId())
                    .orElseThrow(() -> new RuntimeException("Coffee not found"));

            // Create Order Item
            OrderItem orderItem = new OrderItem(coffee, itemRequest.quantity());

            // Attach Order Relationship
            order.addItem(orderItem);
        }

        //  Save Order (Cascade saves items)
        Order savedOrder = orderRepository.save(order);

        // Build Response DTO
        List<OrderItemResponse> itemResponses = savedOrder.getItems().stream()
                .map(item -> new OrderItemResponse(
                        item.getCoffee().getName(),
                        item.getQuantity(),
                        item.getTotalPrice()
                ))
                .toList();

        // Return Response DTO
        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.getTotal(),
                itemResponses
        );
    }
}
