public class Variables {

    // Error: Main method is not static in class Variables, please define the main method as: public static void main(String[] args)
    public static void main(String[] args) {

        // Declaring Variables
        int age; // Declaration of an integer variable
        double salary; // Declaration of a double variable
        String name; // Declaration of a String reference

        // Initializing Variables
        int age1 = 30; // Initialization of an integer variable
        double salary1 = 5000; // Initialization of a double variable
        String name1 = "John"; // Initialization of a String reference

        // Variable Scope
        int x = 10; // This variable is accessible in the entire method
        if (true) {
            int y = 20; // This variable is only accessible within the if block

            System.out.println(x);
            System.out.println(y);

        }

        System.out.println(x);
        // System.out.println(y);

        // Final Variables
        final int constantValue = 100;

        // constantValue = 120; // The final local variable constantValue cannot be
        // assigned.

        // Naming Conventions
        int myVariable;
        int _variable;
        int variable123;

        // Type Casting
        int a = 10;
        double b = (double) a; // Casting 'a' to a double

        System.out.println(b);

        // Literals
        int num = 42; // Integer literal
        double price = 19.99; // Double literal
        char grade = 'A'; // Character literal

        System.out.println(Counter.count);
        // Cannot make a static reference to the non-static field Counter.a
        // System.out.println(Counter.a);

    }
}

// Instance and Local Variables
class Person {
    String name; // Instance variable
    int age; // Instance variable

    public void doSomething() {
        int x = 5; // Local variable
        // ...
        System.out.println(x);
    }
}

// Static Variables
class Counter {
    static int count = 0; // Static variable
    public int a;
}
