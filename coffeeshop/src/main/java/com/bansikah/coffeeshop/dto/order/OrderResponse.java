package com.bansikah.coffeeshop.dto.order;

import java.math.BigDecimal;
import java.util.List;

/**
 * A Data Transfer Object for an order response.
 * @param orderId The ID of the order.
 * @param total The total price of the order.
 * @param items The list of items in the order.
 */
public record OrderResponse(String orderId, BigDecimal total, List<OrderItemResponse> items) {
}

