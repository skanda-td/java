public class Calc1 {
    // Method Overloading
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    String add(String a, String b) {
        return a + b;
    }

    // Usage

    public static void main(String[] args) {
        Calc1 calculator = new Calc1();
        System.out.println(calculator.add(1, 2)); // Output: 3
        System.out.println(calculator.add(1.5, 2.5)); // Output: 4.0
        System.out.println(calculator.add("Hello", "World")); // Output: HelloWorld
    }
}