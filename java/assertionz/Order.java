package java.assertionz;

public record Order( String id, double totalAmount, boolean paid) {
    
    public Order{
        if (totalAmount <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than zero");
        }
    }
}
