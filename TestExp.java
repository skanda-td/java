public class TestExp {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30 };
        int count = 0;
        try {
            while (true) {
                int x = arr[count];
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Reached the end of array
        }
        System.out.println(count); // Output: 3
    }
}
