package com.bansikah.coffeeshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Represents an item within an order.
 */
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private Coffee coffee;
    private int quantity;

    @ManyToOne
    private Order order;

    /**
     * Default constructor for JPA.
     */
    protected OrderItem() {}

    /**
     * Constructs a new OrderItem with the given coffee and quantity.
     * @param coffee The coffee for this item.
     * @param quantity The quantity of the coffee.
     */
    public OrderItem(Coffee coffee, int quantity){
        this.coffee = coffee;
        this.quantity = quantity;
    }

    /**
     * @return The coffee associated with this order item.
     */
    public Coffee getCoffee(){
        return coffee;
    }

    /**
     * @return The quantity of the coffee in this order item.
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Calculates and returns the total price for this order item.
     * @return The total price (coffee price * quantity).
     */
    public BigDecimal getTotalPrice(){
        return coffee.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    /**
     * Sets the order for this item.
     * @param order The parent order.
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
