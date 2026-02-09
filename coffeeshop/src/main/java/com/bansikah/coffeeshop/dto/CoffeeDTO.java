package com.bansikah.coffeeshop.dto;

import java.math.BigDecimal;

/**
 * A Data Transfer Object for the Coffee entity.
 * @param id The ID of the coffee.
 * @param name The name of the coffee.
 * @param price The price of the coffee.
 */
public record CoffeeDTO(String id, String name, BigDecimal price) {
}

