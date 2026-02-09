package com.bansikah.coffeeshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

/**
 * Represents a coffee entity in the database.
 */
@Entity
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private BigDecimal price;

    /**
     * Default constructor for JPA.
     */
    public Coffee(){}

    /**
     * Constructs a new Coffee with the given parameters.
     * @param id The ID of the coffee.
     * @param name The name of the coffee.
     * @param price The price of the coffee.
     */
    public Coffee(String id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * @return The ID of the coffee.
     */
    public String getId(){
        return id;
    }

    /**
     * @return The name of the coffee.
     */
    public String getName(){
        return name;
    }

    /**
     * @return The price of the coffee.
     */
    public BigDecimal getPrice(){
        return price;
    }
}
