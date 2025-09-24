public class Greeting {
    // Method with parameters
    public void greetPerson(String name, int age) {
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }

    // Main method
    public static void main(String[] args) {
        Greeting greeting = new Greeting();

        // Calling the method with arguments
        greeting.greetPerson("Alice", 25);
        greeting.greetPerson("Bob", 30);
    }
}
