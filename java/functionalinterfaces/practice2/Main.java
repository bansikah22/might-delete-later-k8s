package java.functionalinterfaces.practice2;

public class Main {
    public static void main(String[] args) {
        Validator emailValidator = input -> input != null && input.contains("@");

        String email1 = "Ht7X2@example.com";

        if (emailValidator.isValid(email1) && emailValidator.isNotEmpty(email1)) {
            System.out.println(email1 + " is a valid email.");
        } else {
            System.out.println(email1 + " is not a valid email.");
        }

        String email2 = null;       
        if (emailValidator.isValid(email2) && emailValidator.isNotEmpty(email2)) {
            System.out.println(email2 + " is a valid email.");
        } else {
            System.out.println(email2 + " is not a valid email.");
        }
    }
}
