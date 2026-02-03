package java.streams.optional;

import java.util.Optional;

public class UserApp {
    public static void main(String[] args) {

        Optional<User> user1 =
                Optional.of(new User("Alice", 30, "alice@mail.com"));

        user1.ifPresent(user -> {
            System.out.println(user.name());
            System.out.println(user.age());
            System.out.println(user.email());
        });
    }
}

