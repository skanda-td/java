public class Wrapper {
    public static void main(String[] args) {
        // Autoboxing: Converting primitive types to wrapper objects
        Integer intValue = 10; // Autoboxing int to Integer
        Double doubleValue = 3.14; // Autoboxing double to Double
        Character charValue = 'a'; // Autoboxing char to Character
        
        // Unboxing: Converting wrapper objects to primitive types
        int a = intValue; // Unboxing Integer to int
        double b = doubleValue; // Unboxing Double to double
        char c = charValue; // Unboxing Character to char
        
        System.out.println("Autoboxing values:");
        System.out.println("Integer value: " + intValue);
        System.out.println("Double value: " + doubleValue);
        System.out.println("Character value: " + charValue);
        
        System.out.println("Unboxing values:");
        System.out.println("Unboxed int value: " + a);
        System.out.println("Unboxed double value: " + b);
        System.out.println("Unboxed char value: " + c);
    }
}
