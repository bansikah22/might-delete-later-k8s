package java.interfacevsabstact.interfaces.practice1;
/*
- Interfaces is used to define a contract that implementing classes must follow.
- It allows multiple inheritance since a class can implement multiple interfaces.
- Interfaces are ideal for defining capabilities that can be shared across different class hierarchies.
- They are used when you want to specify behavior without dictating how that behavior should be implemented.
- Polymorphism: same interface, different behavior.
*/

public class Main {
    public static void main(String[] args) {
       
        Payment cashPayment = new CashPayment();
        cashPayment.pay(100);
        System.out.println("Cash payment processed." + cashPayment);

        Payment cardPayment = new CardPayment();
        cardPayment.pay(200);
        System.out.println("Card payment processed." + cardPayment);

    }
    
}
