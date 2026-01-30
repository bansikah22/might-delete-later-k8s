package java.interfacevsabstact.abstract1;
/**
 * Demonstrates the use of abstract classes in Java.
 * Here, we define an abstract class Shape with an abstract method area().
 * The Circle class extends Shape and provides an implementation for the area() method.
 * In the Main class, we create an instance of Circle and call its methods.
 * Abstract classes allow us to define methods that must be implemented by subclasses,
 * providing a common interface while allowing for specific implementations.
 * @author Noel Bansikah
 * @date 29 01 2026
 * 
 */


public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        circle.printTpe();
        System.out.println("Area of circle: " + circle.area());
    }
}
