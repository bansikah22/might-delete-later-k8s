package java.interfacevsabstact.abstract1;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        circle.printTpe();
        System.out.println("Area of circle: " + circle.area());
    }
}
