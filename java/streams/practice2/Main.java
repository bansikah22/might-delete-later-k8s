package java.streams.practice2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var users = List.of(
                new User("Alice", 30, "USA"),
                new User("Bob", 25, "Canada"),
                new User("Charlie", 35, "USA"),
                new User("Diana", 28, "UK"),
                new User("Eve", 22, "Canada")
        );

        // Filter users older than 25 and from USA
        users.stream()
             .filter(user -> user.age() > 25)
             .filter(user -> user.country().equals("USA"))
             .forEach(user -> System.out.println(user.name()));
    }
}
