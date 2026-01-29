package generics.practice2;
/**
 * The compiler figures out the type automatically.
 * This example demonstrates a generic Printer class with a static method to print values of any type.
 * @author Noel Bansikah
 * @date 29 01 2026
 */

public class Main {
    public static void main(String[] args) {
        Printer.print("Hello, Generics Printer!");
        Printer.print(456);
    }
}
