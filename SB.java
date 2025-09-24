import java.lang.StringBuilder;

public class SB {
    public static void main(String[] args) {
        // Using the constructor
        StringBuilder stringBuilder1 = new StringBuilder();

        // Using StringBuilder literal
        StringBuilder stringBuilder2 = new StringBuilder("Hello");

        System.out.println(stringBuilder2);
        stringBuilder2.append(" World");

        System.out.println(stringBuilder2);
        stringBuilder2.insert(5, " Beautiful");

        System.out.println(stringBuilder2);

        StringBuilder result = new StringBuilder().append("Hello").append(" World").insert(5, " Beautiful");
        System.out.println(result);

        String reString = stringBuilder1.toString();
        System.out.println(stringBuilder1.getClass());
        System.out.println(reString.getClass());

        int length = stringBuilder1.length();
        int capacity = stringBuilder1.capacity();
        System.out.format("Length : %d \nCapacity : %d\n", length, capacity);

        StringBuilder stringBuilder = new StringBuilder("Hello");
        System.out.println("Original capacity: " + stringBuilder.capacity()); // Print original capacity

        // Create a new StringBuilder with increased capacity
        int newCapacity = stringBuilder.capacity() * 2; // Double the capacity, or use any desired strategy
        StringBuilder newStringBuilder = new StringBuilder(newCapacity);

        // Append the content of the original StringBuilder to the new StringBuilder
        newStringBuilder.append(stringBuilder);

        // Assign the new StringBuilder back to the original reference variable
        stringBuilder = newStringBuilder;

        System.out.println("New capacity: " + stringBuilder.capacity()); // Print new capacity

        StringBuilder sb2 = new StringBuilder("Hello");
        System.out.println(sb2);

        sb2.setLength(3);
        System.out.println(sb2);

        System.out.println(sb2.capacity());
        System.out.println(sb2.length());
        sb2.trimToSize();
        System.out.println(sb2.capacity());
        System.out.println(sb2.length());

        StringBuilder sb4 = new StringBuilder("Hello");
        sb4.reverse();
        System.out.println(sb4);

        StringBuilder sb5 = new StringBuilder("Hello World");
        System.out.println(sb5);
        sb5.delete(5, 11);
        System.out.println(sb5);
        sb5.replace(0, 5, "Hi");
        System.out.println(sb5);

        StringBuilder s = new StringBuilder("Hello");
        System.out.println(s);
        s.append(" World");
        System.out.println(s);

        // Less efficient
        String result1 = "";
        for (int i = 0; i < 10000; i++) {
            result1 += i;
        }

        System.out.println(result1);

        // More efficient
        StringBuilder stringBuilder21 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder21.append(i);
        }
        String result2 = stringBuilder21.toString();
        System.out.println(result2);
    }
}
