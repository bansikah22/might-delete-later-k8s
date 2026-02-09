package com.bansikah.coffeeshop.controller;

import com.bansikah.coffeeshop.domain.Coffee;
import com.bansikah.coffeeshop.dto.CoffeeDTO;
import com.bansikah.coffeeshop.service.CoffeeService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * REST controller for managing coffees.
 */
@RestController
@RequestMapping("/api/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    /**
     * Constructs a new CoffeeController with the given CoffeeService.
     * @param coffeeService The service to handle coffee-related business logic.
     */
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    /**
     * Creates a new coffee.
     * @param name The name of the coffee.
     * @param price The price of the coffee.
     * @return The created coffee as a DTO.
     */
    @PostMapping
    public CoffeeDTO createCoffee(
            @RequestParam String name,
            @RequestParam BigDecimal price) {

        Coffee savedCoffee = coffeeService.createCoffee(name, price);
        return new CoffeeDTO(savedCoffee.getId(), savedCoffee.getName(), savedCoffee.getPrice());
    }

    /**
     * Retrieves the full coffee menu.
     * @return A list of all coffees as DTOs.
     */
    @GetMapping
    public List<CoffeeDTO> getMenu(){
        return coffeeService.getMenu();
    }
}
