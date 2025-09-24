public class Strings {
    public static void main(String[] args) {

        // String Declaration
        String greeting; // Declaring a String variable

        // String Initialization
        String name = "Alice"; // Initialization using a literal
        String address = new String("123 Main St."); // Initialization using the 'new' keyword

        // String Concatenation
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName; // Concatenation

        // String Methods
        String txt = "Hello, World!";
        System.out.println(txt.length()); // Length of the string
        System.out.println(txt.charAt(0)); // Access character at index 0
        System.out.println(txt.substring(7)); // Substring starting at index 7
        System.out.println(txt.indexOf("World")); // // Find the index of a substring

        // String Immutability
        String org = "Hello";
        String mod = org + " World"; // Creates a new string

        // String Comparison
        String s1 = "Skanda";
        String s2 = "Skanda";
        System.out.println(s1 == s2); // Compares content
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));

        // String Formatting
        String formatting = String.format("My name is %s, age is %d", "Skanda", 23);
        System.out.printf("Formatted: %s%n", formatting);

        // String Literal Pool
        String a = "Sasd";
        String b = "Sasd"; // Reuses the existing "Hello" from the pool
        boolean sameObj = (a == b); // true
        System.out.println(sameObj);

        // StringBuilder and StringBuffer
        StringBuilder str1 = new StringBuilder("Hello");
        StringBuffer string1 = new StringBuffer("Bye");
        // string1.
        str1.append(", World!"); // Mutable string
        String result = str1.toString(); // // Convert back to String
        System.out.println(result);

        // String Splitting
        String sentence = "This is a sentence!";
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }

        System.out.println();

    }
}