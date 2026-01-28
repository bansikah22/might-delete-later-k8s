package errorhandling;
import errorhandling.Calculator;

public class RunCalc {

    public static void main(String[] args){

     int addResult = Calculator.add(3,5);
     System.out.println(addResult);

     int subtractResult = Calculator.subtract(10, 2);
     System.out.println(subtractResult);

     int multiplyResult = Calculator.multiply(3, 5);
     System.out.println(multiplyResult);

      try{
        int result = Calculator.divide(10, 0);
        System.out.println("Result: " + result);
      } catch (IllegalArgumentException e) {
        System.out.println("Caught an exception: " + e.getMessage());
      }
     

        System.out.println("Program continues after exception handling.");
    }
    
}