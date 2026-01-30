package java.generics.practice1;
/**
 * A simple demonstration of a generic Box class that can hold any type of object.
 * This example shows how to create Box instances for different types (String and Integer).
 * The Box class is a generic class that can hold any type of object.
 * It has methods to set and get the value of the object it holds.
 * Generics avoids type casting and provides type safety at compile time.
 * @copyright Noel Bansikah 29 01 2026
 */

public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, Generics!");
        System.out.println("String Box contains: " + stringBox.getValue());

        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(123);
        System.out.println("Integer Box contains: " + integerBox.getValue());
    }
}
