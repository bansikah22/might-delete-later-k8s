package generics.practice3;

/**
 * Bounded generics example , generics is bounded only to a specific type which Number
 * @author Noel Bansikah
 * @date 29 01 2026
 */

public class Main {
    public static void main(String[] args){

    System.out.println(MathUtils.doubleValue(10)); // OK
    System.out.println(MathUtils.doubleValue(3.5)); // OK
    //System.out.println(MathUtils.doubleValue("test")); // compile error

    }
}
