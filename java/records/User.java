/**
 * 
 * A simple record to represent a User with name and age.
 * Records automatically provide accessor methods, a constructor,
 * equals(), hashCode(), and toString() methods.
 * Records are immutable data carriers.
 * Records were introduced in Java 14 as a preview feature and became a standard feature in Java 16.
 * Records help reduce boilerplate code in data classes.
 * Records are ideal for simple data structures that primarily hold data.
 * Records can have validation logic in their constructors.
 * Records can implement interfaces but cannot extend other classes.
 */

public record User( String name, int age ) {

    // Compact constructor for validation
    public User {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be negative or zero");
        }
    }
    
}
