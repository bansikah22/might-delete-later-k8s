
public class Main{

    public static void main(String[] args){
        ConsoleLogger logger = new ConsoleLogger();
        logger.log("This is a test log message.");
        logger.logError("This is a test error message.");

        

        System.out.println("Logging completed.");
    }
}