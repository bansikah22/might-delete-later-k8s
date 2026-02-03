package java.streams.collections.store;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StoreApp {

    //User Supplier for unique Product IDs
    static Supplier<String> productIdSupplier = () -> UUID.randomUUID().toString();

    public static void main(String[] args) {
        Set<Product> products = Set.of(
                new Product(productIdSupplier.get(), "Laptop", 999.99, 10),
                new Product(productIdSupplier.get(), "Smartphone", 499.49, 25),
                new Product(productIdSupplier.get(), "Tablet", 199.99, 15),
                new Product(productIdSupplier.get(), "Headphones", 49.99, 50)
        );


        System.out.println("Expensive Products (Price > 300):");
        products.stream()
                .filter(product -> product.price() > 300)
                .forEach(product -> System.out.println(product.name() + " - $" + product.price()));

        // Find a product by ID
        String searchId = products.stream().findFirst().map(Product::id).orElse(""); // Get ID of any product
        products.stream()
                .filter(product -> product.id().equals(searchId))
                .findFirst()
                .ifPresent(product -> System.out.println("Found Product: " + product.name() + " - $" + product.price()));


        // Sort products by price
        products.stream()
                .sorted(Comparator.comparingDouble(Product::price))
                .forEach(product -> System.out.printf("%s - $%.2f%n", product.name(), product.price()));

       // Calculate total inventory value
        double totalValue = products.stream()
                .mapToDouble(product -> product.price() * product.inStock())
                .sum();
        System.out.println("Total Inventory Value: $" + totalValue);


        // Step 2e — Map product ID → Product for fast lookup
        Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::id, p -> p));
        System.out.println("Product Map Keys (IDs): " + productMap.keySet());
    }
}
