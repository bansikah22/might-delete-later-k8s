package generics.practice3;

public class MathUtils {
    
    public static <T extends Number> double doubleValue(T number) {
        return number.doubleValue();
    }
}
