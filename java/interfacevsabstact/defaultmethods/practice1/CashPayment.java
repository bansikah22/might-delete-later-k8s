package java.interfacevsabstact.defaultmethods.practice1;

public class CashPayment implements Payment {

    @Override
    public void processPayment(double amount){
        System.out.println("Cash payment of amount: " + amount);
    }


    //overriding default method
    @Override
    public void refund(double amount){
        System.out.println("Cash payment refunded: " + amount);
    }
}
