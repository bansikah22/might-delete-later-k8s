package generics.practice4;

/**
Generics exist for safety

Errors move from runtime → compile time

No casting is a feature, not a limitation

Use bounded generics when behavior depends on type
**/

public class Main {
    public static void main(String[] args) {
        Holder<String> holder = new Holder<>();
        holder.value = "Hello";
        // Integer x = (Integer) holder.value;
        // System.out.println(x); // runtime crash

    }
}
