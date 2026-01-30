package java.interfacevsabstact.defaultmethods.practice1;

public class CardPayment implements Payment{
    @Override
    public void processPayment(double amount){
        System.out.println("Card payment processed" + amount);
    }
}