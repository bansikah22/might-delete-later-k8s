package java.streams.collections.store;

public record Product(
    String id,
     String name, 
     double price,
    int inStock) {
  public Product{
    if(price < 0) throw new IllegalArgumentException("Price cannot be negative");
    if(inStock < 0) throw new IllegalArgumentException("Stock cannot be negative");
  }
    
}
