package errorhandling;

public class Calculator {
    int x;
    int y;

    // use static methods to avoid unnecessary object creation

    static int add(int x, int y) {
        return x + y;
    }

    static int divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return x / y;
    }

    static int multiply(int x, int y) {
        return x * y;
    }

    static int subtract(int x, int y) {
        return x - y;
    }
}