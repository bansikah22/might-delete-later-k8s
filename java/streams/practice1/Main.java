package java.streams.practice1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve");

       // without streams
       for (String n : names){
           System.out.println(n);
       }

       //with streams 
       names.stream()
            .filter(nm -> nm.startsWith("A"))
            .forEach(System.out::println);

    }
}
