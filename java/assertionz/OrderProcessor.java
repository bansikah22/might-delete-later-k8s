package java.assertionz;

public class OrderProcessor {
    public void process(Order order){
        // Developer sanity checks
        assert order != null : "Order cannot be null";

        // Business logic validation
        if (!order.paid()){
            throw new IllegalStateException("Order is not paid");
        }

        // Internal assumption
        assert order.totalAmount() >= 0 : "Total amount cannot be negative";

        System.out.println("Processing order: " + order);
    }
}
