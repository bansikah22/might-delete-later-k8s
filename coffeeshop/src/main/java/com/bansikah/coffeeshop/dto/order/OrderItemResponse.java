package com.bansikah.coffeeshop.dto.order;

import java.math.BigDecimal;

/**
 * A Data Transfer Object for an item in an order response.
 * @param coffeeName The name of the coffee.
 * @param quantity The quantity of the coffee.
 * @param itemTotal The total price for this item.
 */
public record OrderItemResponse(String coffeeName, int quantity, BigDecimal itemTotal) {
}
