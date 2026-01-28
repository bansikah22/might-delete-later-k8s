public class UserClass {
    private String name;
    private int age;

    public UserClass(String name, int age) {
      if (age <= 0) {
        throw new IllegalArgumentException("Age cannot be negative or zero");
      }
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}