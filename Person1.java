public class Person1 {
    private String name;
    private int age;

    // Constructor using this to distinguish between instance variables and parameters
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method using this to refer to the current instance
    public void displayDetails() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }

    public static void main(String[] args) {
        // Creating an object and calling a method
        Person1 person = new Person1("Alice", 25);
        person.displayDetails();
    }
}

