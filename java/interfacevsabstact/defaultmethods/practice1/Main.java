package java.interfacevsabstact.defaultmethods.practice1;
/**
 * Main class to demonstrate CardPayment processing
 * In this example, we have an interface Payment with a default method printPaymentDetails.
 * We notice that even without implementing the default method from the interface, the class works fine.
 * This shows the advantage of default methods in interfaces, allowing us to add new functionality without breaking existing implementations.
 */

public class Main{

    public static void main(String[] args){

        CardPayment cardPayment = new CardPayment();
        cardPayment.processPayment(100.0);
        System.out.println(cardPayment);

    }
}