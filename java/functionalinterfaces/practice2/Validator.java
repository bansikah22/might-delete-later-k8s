package java.functionalinterfaces.practice2;

public interface Validator {
    boolean isValid(String input);

    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
