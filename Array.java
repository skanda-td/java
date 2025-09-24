import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

        // Array Declaration
        int[] numbers;

        // Static Initialization
        int[] numbers1 = { 1, 2, 3, 4, 5 };

        // Dynamic Initialization
        int[] num2 = new int[5];

        // Accessing Elements

        System.out.println(numbers1[0]);

        // Array Length
        System.out.println(numbers1.length);

        // Iterating Over Arrays
        for (int i = 0; i < numbers1.length; i++) {
            System.out.println(numbers1[i]);
        }

        // Multi Dimensional Array
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(matrix[1][2]);

        // Array Copying
        int[] sourceArray = { 1, 2, 3 };
        int[] targetArray = new int[sourceArray.length];
        System.arraycopy(sourceArray, 0, targetArray, 0, 0);
        System.out.println(sourceArray.hashCode());
        System.out.println(targetArray.hashCode());

        // Array as objects
        int[] numbers2 = { 1, 2, 3 };
        int[] anotherArray = numbers2; // both variables point to the same array

        System.out.println(numbers2.hashCode());
        System.out.println(anotherArray.hashCode());

        // Enhanced For Loop
        for (int i : anotherArray) {
            System.out.println(i);
        }

        // Array of objects
        String[] names = { "Skanda", "Shamanth", "Arvind" };

        // Sorting Array
        int[] a = { 2, 5, 1, 3, 4 };
        for (int i : a) {
            System.out.println(i);
        }
        Arrays.sort(a);
        for (int i : a) {
            System.out.println(i);
        }

        // Multidimensional Arrays, Nested For Loops


    }
}
