package com.bansikah.coffeeshop.service;

import com.bansikah.coffeeshop.domain.Coffee;
import com.bansikah.coffeeshop.dto.CoffeeDTO;
import com.bansikah.coffeeshop.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Service class for managing coffees.
 */
@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    /**
     * Constructs a new CoffeeService with the given CoffeeRepository.
     * @param coffeeRepository The repository for coffee data access.
     */
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    /**
     * Creates and saves a new coffee.
     * @param name The name of the coffee.
     * @param price The price of the coffee.
     * @return The saved coffee entity.
     */
    public Coffee createCoffee(String name, BigDecimal price) {
        Coffee coffee = new Coffee(
                UUID.randomUUID().toString(),
                name,
                price
        );
        return coffeeRepository.save(coffee);
    }

    /**
     * Retrieves the full coffee menu.
     * @return A list of all coffees as DTOs.
     */
    public List<CoffeeDTO> getMenu() {
        return coffeeRepository.findAll()
                .stream()
                .map(coffee -> new CoffeeDTO(
                        coffee.getId(),
                        coffee.getName(),
                        coffee.getPrice()
                ))
                .toList();
    }

}
