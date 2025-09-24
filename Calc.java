public class Calc {
    // Method with return type int
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // Method with return type double
    public double divide(int numerator, int denominator) {
        // Ensure denominator is not zero to avoid division by zero
        if (denominator != 0) {
            return (double) numerator / denominator;
        } else {
            System.out.println("Cannot divide by zero.");
            return Double.NaN; // Not a Number
        }
    }

    // Method with return type void
    public void displayMessage(String message) {
        System.out.println("Message: " + message);
    }

    // Main method
    public static void main(String[] args) {
        Calc myCalculator = new Calc();

        // Calling methods with return types
        int sum = myCalculator.add(3, 5);
        double result = myCalculator.divide(10, 2);

        // Displaying results
        System.out.println("Sum: " + sum);
        System.out.println("Result of division: " + result);

        // Calling a method with void return type
        myCalculator.displayMessage("Hello, World!");
    }
}

