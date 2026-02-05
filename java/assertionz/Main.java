package java.assertionz;

public class Main {

     public static void main(String[] args) {

        OrderProcessor processor = new OrderProcessor();

        Order order1 = new Order("ORD-1", 200, true);
        Order order2 = new Order("ORD-2", 150, false);

        processor.process(order1);

        try {
            processor.process(order2);
        } catch (Exception e) {
            System.out.println("Business error: " + e.getMessage());
        }
    }
    
}
