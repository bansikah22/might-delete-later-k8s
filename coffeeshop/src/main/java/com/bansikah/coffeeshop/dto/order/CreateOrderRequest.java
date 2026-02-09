package com.bansikah.coffeeshop.dto.order;

import java.util.List;

/**
 * A Data Transfer Object for creating a new order.
 * @param items The list of items in the order.
 */
public record CreateOrderRequest(List<OrderItemRequest> items) {
}

