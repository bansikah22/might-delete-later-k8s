
package java.functionalinterfaces.uservalidation;

import java.lang.Record;

public record User(int id, String name, String email, int age) {
    public User {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be negative or zero");
        }
    }
}