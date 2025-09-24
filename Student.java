public class Student {
    // Private attributes (encapsulated)
    private String name;
    private int age;

    // Public methods to access and modify the attributes (getters and setters)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Additional validation or logic can be added here
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // Additional validation or logic can be added here
        this.age = age;
    }
}

// ABS

// Abstract class with abstract and concrete methods
// abstract class Shape {
//     abstract void draw();  // Abstract method without implementation

//     void resize() {
//         System.out.println("Resizing the shape");
//     }
// }

// // Concrete class extending the abstract class
// class Circle extends Shape {
//     // Implementation of the abstract method
//     void draw() {
//         System.out.println("Drawing a Circle");
//     }
// }

// // Usage
// public class Main {
//     public static void main(String[] args) {
//         Circle myCircle = new Circle();
//         myCircle.draw();    // Calls the overridden draw() method in Circle
//         myCircle.resize();  // Calls the inherited resize() method from Shape
//     }
// }


// Interface with abstract methods
interface Shape1 {
    void draw();  // Abstract method without implementation

    void resize();  // Another abstract method
}

// Concrete class implementing the interface
class Circle1 implements Shape1 {
    // Implementation of the draw() method
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    // Implementation of the resize() method
    public void resize() {
        System.out.println("Resizing the Circle");
    }
    public static void main(String[] args) {
        Circle1 myCircle = new Circle1();
        myCircle.draw();    // Calls the implemented draw() method in Circle
        myCircle.resize();  // Calls the implemented resize() method in Circle

        // Shape1 s2 = new Shape
    }
}

