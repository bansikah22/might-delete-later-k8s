package java.streams.optional;

public record User( String name, int age, String email) {
    
    public boolean isAdult() {
        return age >= 18;
    }

    public boolean hasValidEmail() {
        return email != null && email.contains("@");
    }
}
