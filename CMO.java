// Defining a simple class
class Car {
    // Fields (attributes)
    private String make;
    private String model;
    private int year;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Methods (behaviors)
    public void start() {
        System.out.println("The car is starting.");
    }

    public void drive() {
        System.out.println("The car is in motion.");
    }

    public void stop() {
        System.out.println("The car has stopped.");
    }
}

class Calculator {
    // A simple method that adds two numbers
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // Another method that subtracts two numbers
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }
}

public class CMO {
    public static void main(String[] args) {
        Car c1 = new Car("Audi", "A6", 2022);
        System.out.println(c1.getYear());
        c1.drive();

        // Creating an object of the Calculator class
        Calculator myCalculator = new Calculator();

        // Calling methods
        int result1 = myCalculator.add(5, 3);
        int result2 = myCalculator.subtract(8, 4);

        // Displaying results
        System.out.println("Addition result: " + result1);
        System.out.println("Subtraction result: " + result2);
    }
}
