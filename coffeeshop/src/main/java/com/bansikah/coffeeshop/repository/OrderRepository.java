package com.bansikah.coffeeshop.repository;

import com.bansikah.coffeeshop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Order} entity.
 */
public interface OrderRepository extends JpaRepository<Order, String> {
}
