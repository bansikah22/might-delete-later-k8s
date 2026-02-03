package java.functionalinterfaces.uservalidation;

import java.util.List;
import java.util.UUID;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        Supplier<String> idSupplier = () -> UUID.randomUUID().toString();

        List<User> users = List.of(
                new User(idSupplier.get(), "Alice", "alice@mail.com", 22),
                new User(idSupplier.get(), "Bob", "bobmail.com", 17),
                new User(idSupplier.get(), "Charlie", "charlie@mail.com", 30)
        );

        Predicate<User> isAdult = u -> u.age() >= 18;
        Predicate<User> hasValidEmail = u -> u.email().contains("@");
        Predicate<User> isValidUser = isAdult.and(hasValidEmail);

        // Records are immutable → create NEW object
        Function<User, User> formatUserName =
                user -> new User(
                        user.id(),
                        user.name().toUpperCase(),
                        user.email(),
                        user.age()
                );

        Consumer<User> printUser =
                user -> System.out.println("VALID USER -> " + user);

        users.stream()
             .filter(isValidUser)
             .map(formatUserName)
             .forEach(printUser);
    }
}

