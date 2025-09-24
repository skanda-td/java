// Public class
public class PublicClass {
    // Public method
    public void publicMethod() {
        System.out.println("This method is public.");
    }

    // Public field
    public int publicField = 10;

    // A class, method, or field declared as protected is accessible within the same
    // package and by subclasses.
    public static void main(String[] args) {
        BaseClass b = new BaseClass();
        System.out.println(b.protectedField);
        System.out.println(b.publicField);
    }
}

// Yes, in object-oriented programming, a subclass inherits members (fields and
// methods) from its superclass. Inheritance is a fundamental concept that
// allows a class to reuse the code of an existing class, promoting code reuse
// and extending functionality.

// Class with protected members
class BaseClass {
    // Protected method
    protected void protectedMethod() {
        System.out.println("This method is protected.");
    }

    // Protected field
    protected int protectedField = 20;
    public int publicField = 30;
}

// Subclass in the same package
class SubClass extends BaseClass {
    void accessProtectedMembers() {
        protectedMethod(); // Accessing protected method
        System.out.println("Value of protectedField: " + protectedField); // Accessing protected field
    }
}

// If no access modifier is specified (default), it is also known as
// package-private. A class, method, or field with default access is accessible
// only within the same package.

// Class with default access
class DefaultAccessClass {
    // Default access method
    void defaultAccessMethod() {
        System.out.println("This method has default access.");
    }

    // Default access field
    int defaultAccessField = 30;
}