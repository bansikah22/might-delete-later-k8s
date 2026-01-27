public class Main {
	public static void main(String[] args) {

        User u1 = new User("Alice", 30);

        UserClass uc1 = new UserClass("Bob", 25);

        System.out.println("User Name: " + u1.name());
        System.out.println("User Age: " + u1.age());
        System.out.println("UserClass Name: " + uc1.getName());
        System.out.println("UserClass Age: " + uc1.getAge());
        System.out.println("Hello, Records!");
	}
}