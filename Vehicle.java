public class Vehicle {
    // Default constructor
    public Vehicle() {
        System.out.println("A new Vehicle is created.");
    }

    // Parameterized constructor
    public Vehicle(String make, String model) {
        System.out.println("A " + make + " " + model + " is created.");
    }

    public static void main(String[] args) {
        // Creating objects using constructors
        new Vehicle(); // Calls the default constructor
        new Vehicle("Toyota", "Camry"); // Calls the parameterized constructor
    }
}

