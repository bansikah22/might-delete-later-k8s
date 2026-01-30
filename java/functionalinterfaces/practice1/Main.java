package java.functionalinterfaces.practice1;

public class Main {
    public static void main(String[] args) {
        Greetings greetings = name -> System.out.println("Hello, " + name + "!");
        greetings.sayHello("Alice");
    }
}
