class MyClass {
    // Static variable
    static int staticVar = 10;
}

class MathUtils {
    // Static method
    public static int add(int a, int b) {
        return a + b;
    }
}

class Circle {
    // Final variable
    final double PI = 3.14159;
    int radius;

    // Constructor
    public Circle(int radius) {
        this.radius = radius;
    }

    // Method using a final variable
    public double calculateArea() {
        return PI * radius * radius;
    }
}

class Animal1 {
    // Final method
    public final void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog11 extends Animal1 {
    // Attempting to override a final method will result in a compilation error
    // Error: Cannot override the final method from Animal
    // @Override
    // public void makeSound() {
    // System.out.println("Dog barks.");
    // }
}

final class FinalClass {
    // Class code
}

// Attempting to extend a final class will result in a compilation error
// Error: The type Subclass cannot subclass the final class FinalClass
// class Subclass extends FinalClass {}

class Constants {
    // Static and final variable (constant)
    public static final double PI = 3.14159;
}

public class StaticFinal {
    public static void main(String[] args) {
        // Accessing a static variable
        System.out.println("Static variable: " + MyClass.staticVar);

        // Modifying a static variable
        MyClass.staticVar = 20;
        System.out.println("Modified static variable: " + MyClass.staticVar);

        // Calling a static method
        int result = MathUtils.add(5, 3);
        System.out.println("Result of addition: " + result);

        // Creating an object and using a final variable
        Circle myCircle = new Circle(5);
        System.out.println("Area of the circle: " + myCircle.calculateArea());

        // Accessing a static and final variable
        System.out.println("Value of PI: " + Constants.PI);

        PublicClass a = new PublicClass();
        System.out.println(a.publicField);
        a.publicMethod();
    }
}
