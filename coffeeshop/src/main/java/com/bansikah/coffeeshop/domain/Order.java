package com.bansikah.coffeeshop.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

/**
 * Represents an order entity in the database.
 */
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    /**
     * Default constructor for JPA.
     */
    public Order(){}

    /**
     * Constructs a new Order with the given parameters.
     * @param id The ID of the order.
     * @param items The list of items in the order.
     */
    public Order(String id, List<OrderItem> items){
        this.id = id;
        this.items = items;
    }

    /**
     * @return The ID of the order.
     */
    public String getId() {
        return id;
    }

    /**
     * @return The list of items in the order.
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Adds an item to the order and sets the bidirectional relationship.
     * @param item The order item to add.
     */
    public void addItem(OrderItem item) {
        if (items == null) {
            items = new java.util.ArrayList<>();
        }
        items.add(item);
        item.setOrder(this);
    }

    /**
     * Calculates and returns the total price of the order.
     * @return The total price of all items in the order.
     */
    public BigDecimal getTotal(){
        if (items == null) {
            return BigDecimal.ZERO;
        }
        return items.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
