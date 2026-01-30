package java.interfacevsabstact.interfaces.practice1;

public class CashPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cash Payment.");
    }
    
}
