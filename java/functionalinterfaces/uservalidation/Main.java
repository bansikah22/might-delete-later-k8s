package java.functionalinterfaces.uservalidation;

public class Main {
    
    public static void main(String[] args) {

        Supplier<String> idSupplier = () -> UUID.randomUUID().toString();

        List<User> users = List.of(
                new User(idSupplier.get(), "Alice", "alice@mail.com", 22),
                new User(idSupplier.get(), "Bob", "bobmail.com", 17),
                new User(idSupplier.get(), "Charlie", "charlie@mail.com", 30)
        );

        Predicate<User> isAdult = u -> u.getAge() >= 18;
        Predicate<User> hasValidEmail = u -> u.getEmail().contains("@");
        Predicate<User> isValidUser = isAdult.and(hasValidEmail);

        Function<User, User> formatUserName = user -> {
            user.setName(user.getName().toUpperCase());
            return user;
        };

        Consumer<User> printUser =
                user -> System.out.println("VALID USER -> " + user);

        users.stream()
             .filter(isValidUser)
             .map(formatUserName)
             .forEach(printUser);
    }
}
