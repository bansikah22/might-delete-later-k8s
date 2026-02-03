package java.functionalinterfaces.uservalidation;

public record User(String id, String name, String email, int age) {

    public User {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
    }
}
