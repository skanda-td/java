// SuperClass.java
class SuperClass {
    protected int value;

    public SuperClass(int value) {
        this.value = value;
    }

    public void display() {
        System.out.println("SuperClass display method");
    }
}

// SubClass.java
class SubClass extends SuperClass {
    public SubClass() {
        super(10); // Calling superclass constructor with value 10
    }

    @Override
    public void display() {
        super.display(); // Calling superclass method
        System.out.println("SubClass display method");
    }

    public void accessSuperclassField() {
        System.out.println("Superclass value accessed from Subclass: " + super.value);
    }
}

// Main.java
public class Main1 {
    public static void main(String[] args) {
        // Example 1: Calling superclass constructor from subclass
        SubClass subClass = new SubClass();

        // Example 2: Calling superclass method from subclass
        subClass.display();

        // Example 3: Accessing superclass field from subclass
        subClass.accessSuperclassField();

        // Example 4: Constructor chaining using super()
        System.out.println("Superclass value accessed from Subclass constructor: " + subClass.value);
    }
}

