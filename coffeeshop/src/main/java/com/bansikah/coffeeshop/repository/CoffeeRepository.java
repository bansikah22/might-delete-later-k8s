package com.bansikah.coffeeshop.repository;

import com.bansikah.coffeeshop.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Coffee} entity.
 */
public interface CoffeeRepository extends JpaRepository<Coffee, String> {
}
