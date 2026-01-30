package java.interfacevsabstact.defaultmethods.practice1;

public interface Payment {
    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Processing payment of amount: " + amount);
    }
    
}
