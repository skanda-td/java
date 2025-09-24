public class Singleton {
    // Private static instance variable
    private static Singleton instance;

    // Private constructor to prevent external instantiation
    private Singleton() {
        // Initialization code, if needed
    }

    // Public method to get the singleton instance
    public static Singleton getInstance() {
        // Create instance if not already present
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods or properties of the singleton class can be added here

    // Example method
    public void showMessage() {
        System.out.println("Hello, I am a singleton instance!");
    }

    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singletonInstance1 = Singleton.getInstance();
        Singleton singletonInstance2 = Singleton.getInstance();

        // Both instances will be the same
        System.out.println(singletonInstance1 == singletonInstance2); // Output: true

        // Use the singleton instance
        singletonInstance1.showMessage(); // Output: Hello, I am a singleton instance!
    }

}
