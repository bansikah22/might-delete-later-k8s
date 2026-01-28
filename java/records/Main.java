import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {

        User u1 = new User("Alice", 30);

        UserClass uc1 = new UserClass("Bob", 25);

        System.out.println("User Name: " + u1.name());
        System.out.println("User Age: " + u1.age());
        System.out.println("UserClass Name: " + uc1.getName());
        System.out.println("UserClass Age: " + uc1.getAge());

        //UserClass uc2 = new UserClass("Eve", -10);
        //System.out.println(uc2.getAge());

        //print everything
        System.out.println(u1);
        System.out.println(uc1);


        System.out.println("Hello, Records!");

        //equals and hashcode
        User u2 = new User("Alice", 30);
        System.out.println("u1 == u2: " + (u1 == u2)); // == checks reference equality not data equality so we have false
        System.out.println("u1.equals(u2): " + u1.equals(u2)); // equals checks data equality so we have true

        System.out.println("u1.hashCode(): " + u1.hashCode());
        System.out.println("u2.hashCode(): " + u2.hashCode());

        System.out.println("Same hashcode: " + (u1.hashCode() == u2.hashCode()));

        Set<User> set = new HashSet<>();
        set.add(u1);
        set.add(u2); // should not add duplicate
        System.out.println("Set size: " + set.size()); // should be 1
        


	}
}