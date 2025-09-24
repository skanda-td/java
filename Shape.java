// Base class with a protected method
public class Shape {
    protected void draw() {
        System.out.println("Drawing a shape");
    }
}

// Subclass extending the base class
class Cir extends Shape {
    private int radius;

    // Constructor
    public Cir(int radius) {
        this.radius = radius;
    }

    // Public method to access the protected method of the base class
    public void drawCir() {
        draw(); // Accessing protected method from the base class
        System.out.println("Drawing a Cir with radius " + radius);
    }

    public static void main(String[] args) {
        // Creating an object of the Cir class
        Cir myCir = new Cir(5);

        // Calling the public method that internally calls the protected method
        myCir.drawCir();
    }
}

