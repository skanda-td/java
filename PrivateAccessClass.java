// Class with private members
public class PrivateAccessClass {
    // Private method
    private void privateMethod() {
        System.out.println("This method is private.");
    }

    // Private field
    private int privateField = 40;

    // Public method to access private members
    public void accessPrivateMembers() {
        privateMethod(); // Accessing private method
        System.out.println("Value of privateField: " + privateField); // Accessing private field
    }

    public static void main(String[] args) {
        PrivateAccessClass p = new PrivateAccessClass();
        //p.privateField;
        p.privateMethod();
    }
}