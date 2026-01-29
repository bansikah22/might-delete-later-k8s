package generics.practice2;

public class Printer<T> {
    
    public static <T> void print(T value) {
        System.out.println(value);
    }
}
