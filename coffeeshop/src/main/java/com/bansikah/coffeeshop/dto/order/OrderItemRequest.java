package com.bansikah.coffeeshop.dto.order;

/**
 * A Data Transfer Object for an item in an order request.
 * @param coffeeId The ID of the coffee.
 * @param quantity The quantity of the coffee.
 */
public record OrderItemRequest(String coffeeId, int quantity) {
}
